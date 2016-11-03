package com.imarce.wechat.entity;

import java.util.Date;
/**
*@version 1.0
*@author zhoujb,zjf
*@time 2016年6月15日上午11:08:48
*
*/
public class EmployTend {
    /**
     * 学员ID
     */
	private Integer studentId;
	/**
     * 录用意向公司名称
     */
	private String employCompany;
	/**
     * 公司联系人姓名
     */
	private String employName;
	/**
     * 联系人QQ
     */
	private String employQQ;
	/**
     * 联系人手机
     */
	private String employPhone;
	/**
     * 微信用户ID
     */
	private Integer userId;
	/**
     * 发布时间
     */
	private Date releaseTime;
	public EmployTend() {
		// TODO Auto-generated constructor stub
	}
	public EmployTend(String employCompan,
			String employName, String employQq, String employPhone) {
		super();
		this.employCompany = employCompan;
		this.employName = employName;
		this.employQQ = employQq;
		this.employPhone = employPhone;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
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
	public String getEmployQQ() {
		return employQQ;
	}
	public void setEmployQQ(String employQQ) {
		this.employQQ = employQQ;
	}
	public String getEmployPhone() {
		return employPhone;
	}
	public void setEmployPhone(String employPhone) {
		this.employPhone = employPhone;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

}
