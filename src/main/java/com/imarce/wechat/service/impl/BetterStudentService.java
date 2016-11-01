package com.imarce.wechat.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.set.SynchronizedSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imarce.core.service.BaseService;
import com.imarce.core.service.Page;
import com.imarce.core.service.Result;
import com.imarce.core.utils.DateUtils;
import com.imarce.wechat.dao.BetterStudentDao;
import com.imarce.wechat.dao.ReleaseRequirementDao;
import com.imarce.wechat.entity.EmployTend;
import com.imarce.wechat.entity.Level;
import com.imarce.wechat.entity.Position;
import com.imarce.wechat.entity.Student;
import com.imarce.wechat.entity.StudentKnowledge;
import com.imarce.wechat.entity.WorkExperience;
import com.imarce.wechat.vo.StudentInfo;

@Service("better_student_service")
@ Transactional
public class BetterStudentService extends BaseService {

	@Autowired
	private BetterStudentDao  betterStudentDao;
	@Autowired
	private ReleaseRequirementDao releaseRequirementDao;
	
	private Result result;
	/**
	 * 返回未入职学员的总记录数
	 * @ return Result
	 * @ param
	 */
	public Result getStudentTotal(Student student){
		result = new Result();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("student",student);
		try {
			result.setObjResult(betterStudentDao.getStudentTotal(map));
			if(result.getObjResult()!=null){
				result.setCode(1);
			}else{
				result.setCode(0);
				result.setMsg("没有查到数据");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 得到所有的优秀学员
	 * @ return 学生对象Student
	 */
	public Result getStudents(Student student,Page page){
		result = new Result();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("student",student);
		map.put("page", page);
		/**
		 * 查询
		 * 1.未入职的优秀学员 ,也就是默认的没有筛选条件
		 * 2.根据岗位查询未入职的优秀学员 ,用到student的岗位id
		 * 3.根据i码士等级查询优秀学员  ,用到student的i码士的等级id
		 * 4.根据i码士等级和岗位查询优秀学员
		 */
		try {
			List<Student> stu = betterStudentDao.getStudents(map);
			if(stu!=null){
				for(Student s:stu){
					map.put("levelId", s.getLevelId());
					map.put("positionId", s.getPositionId());
					s.setLevel(betterStudentDao.getLevelByLevelId(map));
					s.setPosition(betterStudentDao.getPositionByPositionId(map));
				}
				result.setCode(1);
				result.setObjResult(stu);
			}else{
				result.setCode(0);
				result.setMsg("没有查到数据");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Result getStudentInfo(Student student){
		result = new Result();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("student",student);
		StudentInfo studentInfo = new StudentInfo();
		try {
			/**
			 * 先查有没有项目经验
			 */
			studentInfo.setProjectexperience(betterStudentDao.getProjectExperienceByStudentId(map));
			studentInfo.setWorkexperience(betterStudentDao.getWorkExperienceByStudentId(map));
			/**
			 * 再查学生基本信息
			 */
			studentInfo.setStudent(betterStudentDao.getStudentInfoByStudentId(map));
			if(studentInfo.getStudent()!=null){
				map.put("levelId", studentInfo.getStudent().getLevelId());
				map.put("positionId", studentInfo.getStudent().getPositionId());
				studentInfo.getStudent().setLevel(betterStudentDao.getLevelByLevelId(map));
				studentInfo.getStudent().setPosition(betterStudentDao.getPositionByPositionId(map));
				
				result.setCode(1);
				result.setObjResult(studentInfo);
			}else{
				result.setCode(0);
				result.setMsg("没有查到数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 查询所有的i码士等级集合
	 * @ return 码士等级集合
	 */
	public Result getLevels(Page page){
		result = new Result();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("page", page);
		try {
			if(betterStudentDao.getLevels(map)!=null){
				result.setCode(1);
				result.setObjResult(betterStudentDao.getLevels(map));
			}else{
				result.setCode(0);
				result.setMsg("没有查到数据");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 查询所有的岗位
	 * @ return Result
	 * @ param
	 */
	public Result getPositions(){
		result = new Result();
		try {
			if(releaseRequirementDao.showPosition()!=null){
				result.setCode(1);
				result.setObjResult(releaseRequirementDao.showPosition());
			}else{
				result.setCode(0);
				result.setMsg("没有查到数据");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 招募勇士，向EmployTend添加信息
	 * @ param 录取意向对象
	 * @ return 是否添加成功
	 */
	public Result insertEmployTend(EmployTend employTend){
		result = new Result();
		try {
			boolean flag=betterStudentDao.insertEmployTend(employTend);
			if(flag){
				result.setCode(1);
				result.setMsg("录取意向数据添加成功");
			}else{
				result.setCode(0);
				result.setMsg("数据添加失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
