package com.imarce.wechat.entity;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48 
 * 学员类
 */
public class Student {
	/**
	 * 1.学员的ID
	 */
	public Integer studentId;
    
    /**
     * 2.头像照片地址
     */
    private String headPicture;
    /**
     * 3.学员姓名
     */
    private String studentName;
    /**
     * 4.职位ID(所学专业)
     */
    private Integer positionId;
    /**
     * 职位名称
     */
    private String position;
    /**
     * 5.等级ID
     */
    private Integer levelId;
    /**
     * 等级名称
     */
    private String level;
    /**
     * 6.工作时间
     */
    private String workTime;
    /**
     * 7.期望工作地点
     */
    private String area;
    /**
     * 8.自我评价
     */
    private String studentIntroduce;
    /**
     * 9.薪资
     */
    private String salary;
    /**
     * 10.入职公司
     */
    private String employed;
    /**
     * 11.入职时间
     */
    private Date dateTime;
    
    /**
     * 12.是否入职，0 表示未入职  1表示已入职
     */
    private Integer workState=0;
    
    /**
     * 学生对应的知识点关系
     */
    private List<StudentKnowledge> studentKnowledge;
    
    /**
     * 知识点集合
     */
    private List<Knowledge> knowledge;
    
    public Student() {
        // TODO Auto-generated constructor stub
    }

	public Student(Integer studentId, String headPicture, String studentName, Integer positionId, String position,
			Integer levelId, String level, String workTime, String area, String studentIntroduce, String salary,
			String employed, Date dateTime, Integer workState, List<StudentKnowledge> studentKnowledge,
			List<Knowledge> knowledge) {
		super();
		this.studentId = studentId;
		this.headPicture = headPicture;
		this.studentName = studentName;
		this.positionId = positionId;
		this.position = position;
		this.levelId = levelId;
		this.level = level;
		this.workTime = workTime;
		this.area = area;
		this.studentIntroduce = studentIntroduce;
		this.salary = salary;
		this.employed = employed;
		this.dateTime = dateTime;
		this.workState = workState;
		this.studentKnowledge = studentKnowledge;
		this.knowledge = knowledge;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getHeadPicture() {
		return headPicture;
	}

	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStudentIntroduce() {
		return studentIntroduce;
	}

	public void setStudentIntroduce(String studentIntroduce) {
		this.studentIntroduce = studentIntroduce;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEmployed() {
		return employed;
	}

	public void setEmployed(String employed) {
		this.employed = employed;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getWorkState() {
		return workState;
	}

	public void setWorkState(Integer workState) {
		this.workState = workState;
	}

	public List<StudentKnowledge> getStudentKnowledge() {
		return studentKnowledge;
	}

	public void setStudentKnowledge(List<StudentKnowledge> studentKnowledge) {
		this.studentKnowledge = studentKnowledge;
	}

	public List<Knowledge> getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(List<Knowledge> knowledge) {
		this.knowledge = knowledge;
	}
	
    
}
