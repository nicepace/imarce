package com.imarce.webadmin.entity;

import java.util.Date;

import com.imarce.core.utils.DateUtils;

/**
 * 2016年7月5日 下午2:45:33
 * 
 * @kriss 说明： 版本：
 */
public class Requirement {

	private Integer requirementId;
	private String companyName;
	private String contacts;
	private String phoneNumber;
	private Double salaryMin;
	private Double salaryMax;
	private String requirementIntroduce;
	private Date releaseTime;
	
	private Position  position;	
	
	
	private String releaseTimeStr;
	
	
	public Integer getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Double getSalaryMin() {
		return salaryMin;
	}
	public void setSalaryMin(Double salaryMin) {
		this.salaryMin = salaryMin;
	}
	public Double getSalaryMax() {
		return salaryMax;
	}
	public void setSalaryMax(Double salaryMax) {
		this.salaryMax = salaryMax;
	}
	public String getRequirementIntroduce() {
		return requirementIntroduce;
	}
	public void setRequirementIntroduce(String requirementIntroduce) {
		this.requirementIntroduce = requirementIntroduce;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public String getReleaseTimeStr() {
		if(this.releaseTime!=null){
			releaseTimeStr=DateUtils.formatDate(releaseTime,"yyyy-MM-dd HH:mm");
			return  releaseTimeStr;
		}	
		else	
		   return "";
	}
	
	
	
}
