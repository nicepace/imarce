package com.imarce.wechat.vo;

import java.util.List;

import com.imarce.wechat.entity.ProjectExperience;
import com.imarce.wechat.entity.Student;
import com.imarce.wechat.entity.WorkExperience;

/*
* @ version:
* @ 作者 ：zjf
* @ 时间：2016年6月16日上午11:49:48
*/
public class StudentInfo {
	/**
	 * 学生对象
	 */
	private Student student;
    /**
     * 工作经验
     */
    private List< WorkExperience > workexperience;
    /**
     * 项目经验
     */
    private List< ProjectExperience > projectexperience;
    
    public StudentInfo() {
		// TODO Auto-generated constructor stub
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<WorkExperience> getWorkexperience() {
		return workexperience;
	}

	public void setWorkexperience(List<WorkExperience> workexperience) {
		this.workexperience = workexperience;
	}

	public List<ProjectExperience> getProjectexperience() {
		return projectexperience;
	}

	public void setProjectexperience(List<ProjectExperience> projectexperience) {
		this.projectexperience = projectexperience;
	}
    
}
