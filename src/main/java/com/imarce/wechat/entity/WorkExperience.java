package com.imarce.wechat.entity;

import java.util.Date;

import com.imarce.core.utils.DateUtils;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48
 * 工作经历类
 */
public class WorkExperience {
    /**
     * 工作经验id
     */
	private Integer workExperienceId;
    /**
     * 学员ID
     */
    private String studentId;
    /**
     * 工作公司
     */
    private String workCompany;
    /**
     * 工作内容
     */
    private String workIntroduce;
    /**
     * 工作起始时间
     */
    private Date workStart;
    private String start;
    /**
     * 工作结束时间
     */
    private Date workEnd;
    private String end;
    
    public WorkExperience() {
        // TODO Auto-generated constructor stub
    }
    
    public WorkExperience(String studentId, String workCompany, String workIntroduce, Date workStart, Date workEnd) {
        super();
        this.studentId = studentId;
        this.workCompany = workCompany;
        this.workIntroduce = workIntroduce;
        this.workStart = workStart;
        this.workEnd = workEnd;
    }
    
    
    public Integer getWorkExperienceId() {
		return workExperienceId;
	}

	public void setWorkExperienceId(Integer workExperienceId) {
		this.workExperienceId = workExperienceId;
	}

	public String getStudentId() {
        
        return studentId;
    }
    
    public void setStudentId( String studentId ) {
        
        this.studentId = studentId;
    }
    
    public String getWorkCompany() {
        
        return workCompany;
    }
    
    public void setWorkCompany( String workCompany ) {
        
        this.workCompany = workCompany;
    }
    
    public String getWorkIntroduce() {
        
        return workIntroduce;
    }
    
    public void setWorkIntroduce( String workIntroduce ) {
        
        this.workIntroduce = workIntroduce;
    }
    
    public Date getWorkStart() {
        
        return workStart;
    }
    public String getStart(){
    	return DateUtils.formatDate(workStart,"yyyy.MM");
    }
    public void setStart(){
    	this.start = DateUtils.formatDate(workStart,"yyyy.MM");
    }
  
    public void setWorkStart( Date workStart ) {   
        this.workStart = workStart;
    }
    
    public Date getWorkEnd(){
        return workEnd;
    }
    /////显示的日期
    public void setEnd(){
    	this.end = DateUtils.formatDate(workEnd,"yyyy.MM");
    }
    public String getEnd(){
    	return DateUtils.formatDate(workEnd,"yyyy.MM");
    }
    
    public void setWorkEnd( Date workEnd ) {
        
        this.workEnd = workEnd;
    }
    
}
