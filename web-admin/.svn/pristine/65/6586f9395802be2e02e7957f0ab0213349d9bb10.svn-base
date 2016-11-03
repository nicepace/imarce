/**
 * 2016年7月6日
 */
package com.imarce.webadmin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.GoodStuDao;
import com.imarce.webadmin.dao.PositionDao;
import com.imarce.webadmin.dao.StudentKnowledgeDao;
import com.imarce.webadmin.entity.Position;
import com.imarce.webadmin.entity.Student;
import com.imarce.webadmin.entity.StudentKnowledge;
import com.imarce.webadmin.entity.vo.KnowledgeVO;
import com.imarce.webadmin.entity.vo.SkillVO;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;

/**
 * Author: Qian
 * 
 * Date: 2016年7月6日
 * 
 * Description:
 */
@Service
public class GoodStuService {
	Log log = LogFactory.getLog(GoodStuService.class);

	@Autowired
	private GoodStuDao goodStuDao;
	@Autowired
	private PositionDao pDao;
	@Autowired
	private StudentKnowledgeDao skDao;

	public DataGridData queryGoodStu(Pager page) {
		DataGridData result = new DataGridData();
		try {
			List<Student> ls = goodStuDao.queryGoodStu(page);
			result.setRows(ls);
			int cnt = goodStuDao.countGoodStu();
			result.setTotal(cnt);
		} catch (Exception e) {
			e.printStackTrace();

			log.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 添加学生信息和掌握知识
	 * @param student
	 * @param knowledgeStr
	 * @return boolean
	 */
	public boolean saveStudentBasic(Student student,String knowledgeStr) {
		int stu_result = 0;
		int k_result = 0;
		try {
			stu_result = goodStuDao.saveStudentBasic(student);
			if(stu_result>0){
				String knowledges = knowledgeStr.substring(2,knowledgeStr.length()-2);
				String[] knowledgeArr = knowledges.split("\",\"");
				List<Integer> kidList = new ArrayList();
				//筛选数组中非知识点的数据id
				for (int i = 0; i < knowledgeArr.length; i++) {
					int mark = new Integer(knowledgeArr[i].substring(0, 1));
					int kid = new Integer(knowledgeArr[i].substring(1));
					if(mark==4){
						kidList.add(kid);
					}
				}
				for (int k : kidList) {
					StudentKnowledge studentKnowledge = new StudentKnowledge();
					studentKnowledge.setStudentId(student.getStudentId());
					studentKnowledge.setKnowledgeId(k);
					k_result = skDao.addStudentKnowledge(studentKnowledge);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return k_result > 0 ? true : false;
	}

	/**
	 * @param
	 * 
	 * @return
	 * 
	 * 				Introduction
	 */
	public Student queryRegistedStuById(int studentId) {
		Student student = new Student();		
		try {
			student = this.goodStuDao.queryRegistedStuById(studentId);
			Position position = new Position();
			position = pDao.queryPositionById(student.getPosition().getPositionId());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return student;
	}
	
	/**
	 * 修改学生信息和掌握知识
	 * @param student
	 * @param knowledgeStr
	 * @return boolean
	 */
	public boolean updateStu(Student student,String knowledgeStr) {
		int stu_result = 0;
		int kDel_result = -1;
		int kAdd_result = -1;
		int final_result = 0;
		try {
			stu_result = goodStuDao.updateStu(student);
			
			String knowledges = knowledgeStr.substring(2,knowledgeStr.length()-2);
			String[] knowledgeArr = knowledges.split("\",\"");
			List<Integer> kidList = new ArrayList();
			//筛选数组中非知识点的数据id
			for (int i = 0; i < knowledgeArr.length; i++) {
				int mark = new Integer(knowledgeArr[i].substring(0, 1));
				int kid = new Integer(knowledgeArr[i].substring(1));
				if(mark==4){
					kidList.add(kid);
				}
			}
			List<KnowledgeVO> kvoList = skDao.queryStudentKnowledge(student.getStudentId());
			if(kvoList.size()!=0){
				//遍历该学生原有知识列表，删除取消勾选的知识
				for (KnowledgeVO kvo : kvoList) {
					for(int i=0;i<kidList.size();i++){
						if(kvo.getId()==kidList.get(i)){
							break;
						}else if(i==kidList.size()-1){
							StudentKnowledge studentKnowledge = new StudentKnowledge();
							studentKnowledge.setStudentId(student.getStudentId());
							studentKnowledge.setKnowledgeId(kvo.getId());	
							kDel_result = skDao.deleteStudentKnowledge(studentKnowledge);
						}
					}
				}
				
				//遍历修改后的学生知识id数组，添加新增知识
				for(int k:kidList){
					for(int j=0;j<kvoList.size();j++){
						if(k==kvoList.get(j).getId()){
							break;
						}else if(j==kvoList.size()-1){
							StudentKnowledge studentKnowledge = new StudentKnowledge();
							studentKnowledge.setStudentId(student.getStudentId());
							//添加知识id
							studentKnowledge.setKnowledgeId(k);	
							kAdd_result = skDao.addStudentKnowledge(studentKnowledge);
						}
					}
				}
			}else{
				for (int k : kidList) {
					StudentKnowledge studentKnowledge = new StudentKnowledge();
					studentKnowledge.setStudentId(student.getStudentId());
					studentKnowledge.setKnowledgeId(k);
					kAdd_result = skDao.addStudentKnowledge(studentKnowledge);
				}
			}
			//判断三个结果值，全成功或者无修改则设置final结果为1
			if(stu_result>0 && (kDel_result==-1||kDel_result>0) && (kAdd_result==-1||kAdd_result>0)){
				final_result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return final_result > 0 ? true : false;
	}

	public boolean deleteStu(int studentId) {
		int result = 0;
		try {
			result = goodStuDao.deleteStu(studentId);			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ? true : false;
	}

}
