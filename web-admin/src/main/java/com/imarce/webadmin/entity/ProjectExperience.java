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
public class ProjectExperience {
	private int projectExperienceId;
	private int studentId;
	private String projectName;
	private String projectIntroduce;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date projectStart;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date projectEnd;
	
	private String projectStartStr;
	private String projectEndStr;

	/**
	 * @return the projectExperienceId
	 */
	public int getProjectExperienceId() {
		return projectExperienceId;
	}

	/**
	 * @param projectExperienceId
	 *          the projectExperienceId to set
	 */
	public void setProjectExperienceId(int projectExperienceId) {
		this.projectExperienceId = projectExperienceId;
	}

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId
	 *          the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *          the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the projectIntroduce
	 */
	public String getProjectIntroduce() {
		return projectIntroduce;
	}

	/**
	 * @param projectIntroduce
	 *          the projectIntroduce to set
	 */
	public void setProjectIntroduce(String projectIntroduce) {
		this.projectIntroduce = projectIntroduce;
	}

	/**
	 * @return the projectStart
	 */
	public Date getProjectStart() {
		return projectStart;
	}

	/**
	 * @param projectStart
	 *          the projectStart to set
	 */
	public void setProjectStart(Date projectStart) {
		this.projectStart = projectStart;
	}

	/**
	 * @return the projectEnd
	 */
	public Date getProjectEnd() {
		return projectEnd;
	}

	/**
	 * @param projectEnd
	 *          the projectEnd to set
	 */
	public void setProjectEnd(Date projectEnd) {
		this.projectEnd = projectEnd;
	}

	/**
	 * @return the projectStartStr
	 */
	public String getProjectStartStr() {
		if(this.projectStart != null){
			projectStartStr = DateUtils.formatDate(projectStart, "yyyy-MM-dd");
			return projectStartStr;
		}else
			return "";
	}

	/**
	 * @param projectStartStr
	 *          the projectStartStr to set
	 */
	public void setProjectStartStr(String projectStartStr) {
		this.projectStartStr = projectStartStr;
	}

	/**
	 * @return the projectEndStr
	 */
	public String getProjectEndStr() {
		if(this.projectEnd != null){
			projectEndStr = DateUtils.formatDate(projectEnd, "yyyy-MM-dd");
			return projectEndStr;
		}else
			return "";
	}

	/**
	 * @param projectEndStr
	 *          the projectEndStr to set
	 */
	public void setProjectEndStr(String projectEndStr) {
		this.projectEndStr = projectEndStr;
	}

}
