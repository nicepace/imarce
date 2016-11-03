package com.imarce.webadmin.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.imarce.core.db.BaseDao;
import com.imarce.wechat.entity.EmployTend;
import com.imarce.wechat.entity.Knowledge;
import com.imarce.wechat.entity.Level;
import com.imarce.wechat.entity.ProjectExperience;
import com.imarce.wechat.entity.Student;
import com.imarce.wechat.entity.WorkExperience;
import com.imarce.wechat.vo.StudentInfo;

@Repository("better_student_dao")
public interface BetterStudentDao extends BaseDao{
	/**
	 * 1.得到所有未入职的优秀学员；
	 * @ return 学生对象Student集合
	 */
	public List<Student> getStudents(Map map) throws Exception;
	/**
	 * 返回总记录数
	 * @ return Integer
	 * @ param
	 */
	public Integer getStudentTotal(Map map) throws Exception;
	
	
	/**
	 * 根据岗位id获取岗位名称
	 * @ return String
	 * @ param 岗位positionId
	 */
	public String getPositionByPositionId(Map map) throws Exception;
	
	
	/**
	 * 查询所有的i码士等级集合
	 * @ return 码士等级集合
	 */
	public List<Level> getLevels(Map map) throws Exception;
	
	/**
	 * 根据i码士等级id获取i码士等级名称
	 * @ return String
	 * @ param i码士等级id
	 */
	public String getLevelByLevelId(Map map) throws Exception;
	
	/**
	 * 根据学员id得到学员的基本信息;
	 * @ return StudentInfo
	 * @ param 学生对象student
	 */
	public Student getStudentInfoByStudentId(Map map) throws Exception;
	
	
	/**
	 * 招募勇士，像EmployTend添加信息
	 * @ param 录取意向对象
	 * @ return 是否添加成功
	 */
	public boolean insertEmployTend(EmployTend employTend) throws Exception;
	
	/**
	 * 查询工作经历根据主键
	 * @ return WorkExperience
	 * @ param 工作经历的id 
	 */
	public List<WorkExperience> getWorkExperienceByStudentId(Map map) throws Exception;
	
	/**
	 * 根据主键查询项目经验
	 * @ return ProjectExperience
	 * @ param 项目经验id
	 */
	public List<ProjectExperience> getProjectExperienceByStudentId(Map map) throws Exception;
	/**
	 * 获取学生的专业技能知识点集合
	 * @ return StudentInfo
	 * @ param 学生ID
	 */
	public List<Knowledge> getStudentKnowledge(Map map) throws Exception;
	
}
