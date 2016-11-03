/**
 * 2016年7月6日
 */
package com.imarce.webadmin.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.imarce.core.utils.DateUtils;
import com.imarce.webadmin.entity.vo.KnowledgeVO;

/**
 * Author: Qian
 * 
 * Date: 2016年7月6日
 * 
 * Description:
 */
public class Student {

	// 编号
	private Integer studentId;
	// 头像文件地址
	private String headPicture;
	// 姓名
	private String studentName;
	// 出生日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	// 工作年限
	private String workTime;
	// 区域
	private String area;
	// 自我介绍
	private String studentIntroduce;
	// 薪资
	private Double salary;
	// 入职公司
	private String employed;
	// 入职日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workDate;
	// 工作状态，0表示未入职，1表示已入职
	private Integer workState;
	// 岗位，包含岗位id，名称，描述
	private Position position;
	// 级别，包含级别id，名称，头像，描述
	private Level level;
	// 出生日期字符串信息
	private String birthdayStr;
	// 入职日期字符串信息
	private String workDateStr;

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
	 * @return the headPicture
	 */
	public String getHeadPicture() {
		return headPicture;
	}

	/**
	 * @param headPicture
	 *          the headPicture to set
	 */
	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
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
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *          the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the workTime
	 */
	public String getWorkTime() {
		return workTime;
	}

	/**
	 * @param workTime
	 *          the workTime to set
	 */
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area
	 *          the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the studentIntroduce
	 */
	public String getStudentIntroduce() {
		return studentIntroduce;
	}

	/**
	 * @param studentIntroduce
	 *          the studentIntroduce to set
	 */
	public void setStudentIntroduce(String studentIntroduce) {
		this.studentIntroduce = studentIntroduce;
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *          the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/**
	 * @return the employed
	 */
	public String getEmployed() {
		return employed;
	}

	/**
	 * @param employed
	 *          the employed to set
	 */
	public void setEmployed(String employed) {
		this.employed = employed;
	}

	/**
	 * @return the workDate
	 */
	public Date getWorkDate() {
		return workDate;
	}

	/**
	 * @param workDate
	 *          the workDate to set
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	/**
	 * @return the workState
	 */
	public Integer getWorkState() {
		return workState;
	}

	/**
	 * @param workState
	 *          the workState to set
	 */
	public void setWorkState(Integer workState) {
		this.workState = workState;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position
	 *          the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level
	 *          the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * @return the birthdayStr
	 */
	public String getBirthdayStr() {
		if (this.birthday != null) {
			birthdayStr = DateUtils.formatDate(birthday, "yyyy-MM-dd");
			return birthdayStr;
		} else
			return "";
	}

	/**
	 * @param birthdayStr
	 *          the birthdayStr to set
	 */
	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	/**
	 * @return the workDateStr
	 */
	public String getWorkDateStr() {
		if (this.workDate != null) {
			workDateStr = DateUtils.formatDate(workDate, "yyyy-MM-dd");
			return workDateStr;
		} else
			return "";
	}

	/**
	 * @param workDateStr
	 *          the workDateStr to set
	 */
	public void setWorkDateStr(String workDateStr) {
		this.workDateStr = workDateStr;
	}

	
}
