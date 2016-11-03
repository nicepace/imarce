/**
 * 2016年7月8日
 */
package com.imarce.webadmin.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.imarce.core.utils.DateUtils;

/**
 * Author: Qian
 * 
 * Date: 2016年7月8日
 * 
 * Description:
 */
public class WorkExperience {
	private int workExperienceId;
	private int studentId;
	private String workCompany;
	private String workIntroduce;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date workStart;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date workEnd;

	private String workStartStr;
	private String workEndStr;

	/**
	 * @return the workExperienceId
	 */
	public int getWorkExperienceId() {
		return workExperienceId;
	}

	/**
	 * @param workExperienceId
	 *          the workExperienceId to set
	 */
	public void setWorkExperienceId(int workExperienceId) {
		this.workExperienceId = workExperienceId;
	}

	/**
	 * @return the student_id
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param student_id
	 *          the student_id to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the workCompany
	 */
	public String getWorkCompany() {
		return workCompany;
	}

	/**
	 * @param workCompany
	 *          the workCompany to set
	 */
	public void setWorkCompany(String workCompany) {
		this.workCompany = workCompany;
	}

	/**
	 * @return the workIntroduce
	 */
	public String getWorkIntroduce() {
		return workIntroduce;
	}

	/**
	 * @param workIntroduce
	 *          the workIntroduce to set
	 */
	public void setWorkIntroduce(String workIntroduce) {
		this.workIntroduce = workIntroduce;
	}

	/**
	 * @return the workStart
	 */
	public Date getWorkStart() {
		return workStart;
	}

	/**
	 * @param workStart
	 *          the workStart to set
	 */
	public void setWorkStart(Date workStart) {
		this.workStart = workStart;
	}

	/**
	 * @return the workEnd
	 */
	public Date getWorkEnd() {
		return workEnd;
	}

	/**
	 * @param workEnd
	 *          the workEnd to set
	 */
	public void setWorkEnd(Date workEnd) {
		this.workEnd = workEnd;
	}

	/**
	 * @return the workStartStr
	 */
	public String getWorkStartStr() {
		if(this.workStart != null){
			workStartStr = DateUtils.formatDate(workStart, "yyyy-MM-dd");
			return workStartStr;
		}else
		return "";
	}

	/**
	 * @param workStartStr
	 *          the workStartStr to set
	 */
	public void setWorkStartStr(String workStartStr) {
		this.workStartStr = workStartStr;
	}

	/**
	 * @return the workEndStr
	 */
	public String getWorkEndStr() {
		if(this.workEnd != null){
			workEndStr = DateUtils.formatDate(workEnd, "yyyy-MM-dd");
			return workEndStr;
		}else
		return "";
	}

	/**
	 * @param workEndStr
	 *          the workEndStr to set
	 */
	public void setWorkEndStr(String workEndStr) {
		this.workEndStr = workEndStr;
	}

}
