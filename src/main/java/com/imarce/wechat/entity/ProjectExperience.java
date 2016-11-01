package com.imarce.wechat.entity;

import java.util.Date;

import com.imarce.core.utils.DateUtils;

/**
 * @version 1.0
 * @author zhoujb,zjf   
 * @time 2016年6月15日上午11:08:48
 * 工作经验类
 */
public class ProjectExperience {
    /**
     * 项目经验ID
     */
    private Integer projectExperience;
    /**
     * 学员ID
     */
    private Integer StudentId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目内容
     */
    private String projectIntroduce;
    /**
     * 项目启示时间
     */
    private Date projectStart;
    private String start;
    /**
     * 项目结束时间
     */
    private Date projectEnd;
    private String end;
    
    public ProjectExperience() {
        // TODO Auto-generated constructor stub
    }
    
    public ProjectExperience(Integer projectExperience, Integer studentId, String projectName, String projectIntroduce, Date projectStart,
            Date projectEnd) {
        super();
        this.projectExperience = projectExperience;
        StudentId = studentId;
        this.projectName = projectName;
        this.projectIntroduce = projectIntroduce;
        this.projectStart = projectStart;
        this.projectEnd = projectEnd;
    }
    
    public Integer getProjectExperience() {
        
        return projectExperience;
    }
    
    public void setProjectExperience( Integer projectExperience ) {
        
        this.projectExperience = projectExperience;
    }
    
    public Integer getStudentId() {
        
        return StudentId;
    }
    
    public void setStudentId( Integer studentId ) {
        
        StudentId = studentId;
    }
    
    public String getProjectName() {
        
        return projectName;
    }
    
    public void setProjectName( String projectName ) {
        
        this.projectName = projectName;
    }
    
    public String getProjectIntroduce() {
        
        return projectIntroduce;
    }
    
    public void setProjectIntroduce( String projectIntroduce ) {
        
        this.projectIntroduce = projectIntroduce;
    }
    
    public Date getProjectStart() {  
        return projectStart;
    }
    public String getStart(){
    	return DateUtils.formatDate(projectStart,"yyyy.MM");
    }
    public String getEnd(){
    	return DateUtils.formatDate(projectEnd,"yyyy.MM");
    }
    
    public void setProjectStart( Date projectStart ) {
        this.projectStart = projectStart;
    }
    
    public Date getProjectEnd() {
        return projectEnd;
    }
    
    public void setProjectEnd( Date projectEnd ) {
        this.projectEnd = projectEnd;
    }
    
}
