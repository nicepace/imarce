package com.imarce.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.imarce.core.service.Page;
import com.imarce.core.service.Result;
import com.imarce.wechat.entity.Position;
import com.imarce.wechat.entity.Student;
import com.imarce.wechat.service.impl.BetterStudentService;
 
/*
* @ version:
* @ 作者 ：zjf
* @ 时间：2016年6月23日上午11:23:41
*/
public class TestBetterStudentService {
	ApplicationContext ac = null;
	
	@ Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring*.xml");
	}
	@ Test
	public void testAdd(){
		  /**
		   * ************************测试service层的方法*******************************
		   */
		  BetterStudentService bss = ac.getBean(BetterStudentService.class);
		  Page page = new  Page();
		  page.setPageStart();
		  Student student = new Student();
		  
		  //1.未入职的优秀学员 
//		  Result result= bss.getStudents(1, student, page);
//		  if(result.getCode()==1){
//			  List<Student> list = (List<Student>) result.getObjResult();
//			  for(Student s:list){
//				  System.out.println("名字:"+s.getStudentName());
//			  }
//		  }else{
//			  System.out.println(result.getMsg());
//		  }
		  
		  //2.根据岗位查询未入职的优秀学员 ,用到student的岗位id
//		  student.setPositionId(1);
//		  Result result= bss.getStudents(2, student, page);
//		  if(result.getCode()==1){
//			  List<Student> list = (List<Student>) result.getObjResult();
//			  for(Student s:list){
//				  System.out.println("名字:"+s.getStudentName());
//			  }
//		  }else{
//			  System.out.println(result.getMsg());
//		  }
		  
		//3.根据i码士等级查询优秀学员 ,用到student的i码士的等级id
//		  student.setLevelId(1);
//		  Result result= bss.getStudents(3, student, page);
//		  if(result.getCode()==1){
//			  List<Student> list = (List<Student>) result.getObjResult();
//			  for(Student s:list){
//				  System.out.println("名字:"+s.getStudentName());
//			  }
//		  }else{
//			  System.out.println(result.getMsg());
//		  }
		  
		  //根据学员ID查询学员的详细信息 ,用到student的id
//		  student.setStudentId(2);
//		  Result result= bss.getStudents(4, student, page);
//		  if(result.getCode()==1){
//			  StudentInfo stu = (StudentInfo) result.getObjResult();
//			  List<ProjectExperience> list = (List<ProjectExperience>) stu.getProjectexperoence();
//			  for(ProjectExperience s:list){
//				  System.out.println("名字:"+s.getProjectName());
//			  }
//		  }else{
//			  System.out.println(result.getMsg());
//		  }
		  
		  
		  // 招募勇士，向EmployTend添加信息
//		  EmployTend  employTend  = new  EmployTend();
//		  employTend.setStudentId(3);
//		  employTend.setEmployName("lishi");
//		  Result result= bss.insertEmployTend(employTend);
//		  if(result.getCode()==1){
//			  System.out.println("插入成功！");
//		  }else{
//			  System.out.println(result.getMsg());
//		  }
		  
		  //查询所有的i码士等级集合
//		  Result result= bss.getLevels(page);
//		  if(result.getCode()==1){
//			  List<Level> list = (List<Level>) result.getObjResult();
//			  for(Level l:list){
//				  System.out.println("等级名称："+l.getLevelName());
//			  }
//		  }else{
//			  System.out.println(result.getMsg());
//		  }
		  
		  //查询所有的岗位
//		  Result result= bss.getPositions();
//		  if(result.getCode()==1){
//			  List<Position> list = (List<Position>) result.getObjResult();
//			  for(Position l:list){
//				  System.out.println("等级名称："+l.getPositionName());
//			  }
//		  }else{
//			  System.out.println(result.getMsg());
//		  }
	}
}
