/**
 * 2016年7月6日
 */
package com.imarce.webadmin.entity;

import java.util.Date;

import com.imarce.core.utils.DateUtils;

/**
 * Author: Qian
 * 
 * Date: 2016年7月6日
 * 
 * Description: 对应student_register表的已注册学员的实体类
 */
public class RegistedStudent {
	private Integer studentId;
	private String studentName;
	private String studentQQ;
	private String studentPhone;
	private String studentCity;
	private String studentRegisterIP;
	private String userID;
	private Date releaseTime;

	private String releaseTimeStr;

	/**
	 * @return the studentId
	 */
	public Integer getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId
	 *          the studentId to set
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName
	 *          the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentQQ
	 */
	public String getStudentQQ() {
		return studentQQ;
	}

	/**
	 * @param studentQQ
	 *          the studentQQ to set
	 */
	public void setStudentQQ(String studentQQ) {
		this.studentQQ = studentQQ;
	}

	/**
	 * @return the studentPhone
	 */
	public String getStudentPhone() {
		return studentPhone;
	}

	/**
	 * @param studentPhone
	 *          the studentPhone to set
	 */
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	/**
	 * @return the studentCity
	 */
	public String getStudentCity() {
		return studentCity;
	}

	/**
	 * @param studentCity
	 *          the studentCity to set
	 */
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	/**
	 * @return the studentRegisterIP
	 */
	public String getStudentRegisterIP() {
		return studentRegisterIP;
	}

	/**
	 * @param studentRegisterIP
	 *          the studentRegisterIP to set
	 */
	public void setStudentRegisterIP(String studentRegisterIP) {
		this.studentRegisterIP = studentRegisterIP;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *          the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the releaseTime
	 */
	public Date getReleaseTime() {
		return releaseTime;
	}

	/**
	 * @param releaseTime
	 *          the releaseTime to set
	 */
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	/**
	 * @return the releaseTimeStr
	 */
	public String getReleaseTimeStr() {
		if (this.releaseTime != null) {
			releaseTimeStr = DateUtils.formatDate(releaseTime, "yyyy-MM-dd HH:mm");
			return releaseTimeStr;
		} else
			return "";
	}

	/**
	 * @param releaseTimeStr
	 *          the releaseTimeStr to set
	 */
	public void setReleaseTimeStr(String releaseTimeStr) {
		this.releaseTimeStr = releaseTimeStr;
	}

}
