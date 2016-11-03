/**
 * 
 */
package com.imarce.webadmin.entity;

import java.util.Date;

import com.imarce.core.utils.DateUtils;

/**
 * @author JianqMQ
 * 2016年7月6日 上午10:33:34
 */
public class EmployTend {

	private int employTendId;
	private String employCompany;
	private String employName;
	private String employQq;
	private String employPhone;
	private Date releaseTime;
	private Student student;
	
	private String releaseTimeStr;

	public String getEmployCompany() {
		return employCompany;
	}
	public void setEmployCompany(String employCompany) {
		this.employCompany = employCompany;
	}
	public String getEmployName() {
		return employName;
	}
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public String getEmployQq() {
		return employQq;
	}
	public void setEmployQq(String employQq) {
		this.employQq = employQq;
	}
	public String getEmployPhone() {
		return employPhone;
	}
	public void setEmployPhone(String employPhone) {
		this.employPhone = employPhone;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getReleaseTimeStr() {
		if(this.releaseTime!=null){
			releaseTimeStr=DateUtils.formatDate(releaseTime,"yyyy-MM-dd HH:mm");
			return  releaseTimeStr;
		}	
		else	
		   return "";
	}
	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * @return the employTendId
	 */
	public int getEmployTendId() {
		return employTendId;
	}
	/**
	 * @param employTendId the employTendId to set
	 */
	public void setEmployTendId(int employTendId) {
		this.employTendId = employTendId;
	}

	
}
