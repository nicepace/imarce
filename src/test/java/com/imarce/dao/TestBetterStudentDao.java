package com.imarce.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.imarce.core.service.Page;
import com.imarce.wechat.dao.BetterStudentDao;
import com.imarce.wechat.entity.Knowledge;
import com.imarce.wechat.entity.ProjectExperience;
import com.imarce.wechat.entity.Student;
import com.imarce.wechat.entity.WorkExperience;
import com.imarce.wechat.vo.StudentInfo;

/*
*@version 
*@author xsc
*@ time 2016年6月21日下午5:02:47
*/
public class TestBetterStudentDao {

	ApplicationContext ac = null;
	
	@Before
	public void init(){
		 ac = new ClassPathXmlApplicationContext("spring*.xml");
	}
	
	
	@Test
	public void testAdd() throws Exception{
		  BetterStudentDao  bsd   = ac.getBean(BetterStudentDao.class);
//		  EmployTend  et  = new  EmployTend();
//		  et.setStudentId(3);
//		  bsd.insertEmployTend(et);
		  System.out.println("进来测试");
		  Page page = new  Page();
		  Map<String, Object> map = new HashMap<String,Object>();
		  page.setPageStart();
		  map.put("page", page);
		  Student student = new Student();
		  student.setStudentId(1);
		  map.put("student",student);
		  
		  StudentInfo studentInfo = new StudentInfo();
//		  studentInfo.setProjectexperience(bsd.getProjectExperienceByStudentId(map));
//		  studentInfo.setWorkexperience(bsd.getWorkExperienceByStudentId(map));
//		  List<WorkExperience> ww = studentInfo.getWorkexperience();
//		  List<ProjectExperience> pp = studentInfo.getProjectexperience();
//		  for (ProjectExperience p:pp) {
//			  System.out.println("shuju:"+p.getProjectName());
//		}
//		  for (WorkExperience w:ww) {
//			  System.out.println("hh:"+w.getWorkCompany()+"shijian: "+w.getStart());
//		}
//		  studentInfo.setStudent(bsd.getStudentInfoByStudentId(map));
//		  Student st = studentInfo.getStudent();
//		  System.out.println(st.getStudentName()+"  工作年限："+st.getWorkTime());
		
//		  map.put("studentId", 3);
//		  List<Knowledge> kk= bsd.getStudentKnowledge(map);
//		  for(Knowledge k:kk){
//			  System.out.println(k.getknowledgeName());
//		  }
		  
		  //查询学员信息
		  List<Student> list = bsd.getStudents(map);
		  System.out.println("集合的长度："+list.size());
		  for(Student st:list){
			  System.out.println(st.getStudentName()+"  等级："+st.getLevelId());
			  List<Knowledge> list1= st.getKnowledge();
			  for(Knowledge k:list1){
				  System.out.println(k.getknowledgeName());
			  }
		  }
		  
		  //根据岗位查询学员
//		  Position position = new Position();
//		  position.setPositionId(2);
//		  map.put("position", position);
//		  List<Student> list = bsd.getStudentsByPosition(map);
//		  System.out.println("hh"+list.size());
		  
		  
		  //跟据i码士等级查询学员
//		  Level level = new Level();
//		  level.setLevelId(1);
//		  map.put("level", level);
//		  List<Student> list = bsd.getStudentsByLevel(map);
//		  System.out.println("gg"+list.size());
		  
		  //根据查询所有的i码士等级集合
//		  List<Level> list = bsd.getLevels(map);
//		  for(Level l:list){
//			  System.out.println(l.getLevelName());
//		  }
		 
		  //查询工作经历根据主键
//		  map.put("studentId", new Integer("3"));
//		  List<WorkExperience> list = bsd.getWorkExperienceByStudentId(map);
//		  for(WorkExperience wk:list){
//			  System.out.println("hh"+wk.getWorkIntroduce());
//		  }
		  
		  //根据学生ID查询项目经验
//		  map.put("studentId", new Integer("3"));
//		  List<ProjectExperience> list = bsd.getProjectExperienceByStudentId(map);
//		  for(ProjectExperience wk:list){
//			  System.out.println("hh"+wk.getProjectIntroduce());
//		  }
		  
		  
		  //根据学生id 查询专业知识点ID
//		  Student student = new Student();
//		  student.setStudentId(1);
//		  map.put("student", student);
//		  List<Knowledge> list  = bsd.getStudentKnowledge(map);
//		  for(Knowledge k:list){
//			  System.out.println("hh"+k.getknowledgeName());
//		  }
//		  
		  

		//根据学生ID查询项目经验
//		  Student student = new Student();
//		  student.setStudentId(1);
//		  map.put("student", student);
//		  List<Knowledge> list = bsd.getStudentKnowledgeByStudent(map);
//		  for(Knowledge wk:list){
//			  System.out.println("hh"+wk.getknowledgeName());
//		  }
		  
		  
		  //根据学生id 查询详细信息
//		  Student  student = new Student();
//		  student.setStudentId(3);
//		  map.put("student", student);
//		  StudentInfo stu;
//		  
//		try {
//			stu = bsd.getStudentInfoByStudentId(map);
//			List<Knowledge> list = stu.getKnowledge();
//			  List<WorkExperience> list1= stu.getWorkexperience();
//			  System.out.println("mignzhi:"+stu.getStudentName());
//			  for(Knowledge k:list){
//				  System.out.println("知识点名称："+k.getknowledgeName());
//			  }
//			  for(WorkExperience wk:list1){
//				  System.out.println("项目介绍："+wk.getWorkIntroduce());
//			  }
//			  
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		  
		  
		  
	}
}
