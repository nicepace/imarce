package com.imarce.wechat.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48 
 * 发布需求类
 */
public class Requirement {
    
    /**
     * 职位名称列表
     */
    private ArrayList< Integer > positionIdList;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 联系人
     */
    private String contacts;
    /**
     * 联系电话
     */
    private String phoneNumber;
    /**
     * 最低薪资
     */
    private Double salaryMin;
    /**
     * 最高薪资
     */
    private Double salaryMax;
    /**
     * 需求内容，即工作内容介绍
     */
    private String requirementIntroduce;
    /**
     * 微信用户ID
     */
    private Integer userId;
    /**
     * 发布时间
     */
    private Date releaseTime;
    
    public Requirement() {
        // TODO Auto-generated constructor stub
    }
    
    public Requirement(String companyName, String contacts, String phoneNumber, Double salaryMin, Double salaryMax, String requirementIntroduce,
            Integer userId, Date releaseTime) {
        super();
        this.companyName = companyName;
        this.contacts = contacts;
        this.phoneNumber = phoneNumber;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.requirementIntroduce = requirementIntroduce;
        this.userId = userId;
        this.releaseTime = releaseTime;
    }
    
    public ArrayList< Integer > getPositionIdList() {
        
        return positionIdList;
    }
    
    public void setPositionIdList( ArrayList< Integer > positionIdList ) {
        
        this.positionIdList = positionIdList;
    }
    
    public String getCompanyName() {
        
        return companyName;
    }
    
    public void setCompanyName( String companyName ) {
        
        this.companyName = companyName;
    }
    
    public String getContacts() {
        
        return contacts;
    }
    
    public void setContacts( String contacts ) {
        
        this.contacts = contacts;
    }
    
    public String getPhoneNumber() {
        
        return phoneNumber;
    }
    
    public void setPhoneNumber( String phoneNumber ) {
        
        this.phoneNumber = phoneNumber;
    }
    
    public Double getSalaryMin() {
        
        return salaryMin;
    }
    
    public void setSalaryMin( Double salaryMin ) {
        
        this.salaryMin = salaryMin;
    }
    
    public Double getSalaryMax() {
        
        return salaryMax;
    }
    
    public void setSalaryMax( Double salaryMax ) {
        
        this.salaryMax = salaryMax;
    }
    
    public String getRequirementIntroduce() {
        
        return requirementIntroduce;
    }
    
    public void setRequirementIntroduce( String requirementIntroduce ) {
        
        this.requirementIntroduce = requirementIntroduce;
    }
    
    public Integer getUserId() {
        
        return userId;
    }
    
    public void setUserId( Integer userId ) {
        
        this.userId = userId;
    }
    
    public Date getReleaseTime() {
        
        return releaseTime;
    }
    
    public void setReleaseTime( Date releaseTime ) {
        
        this.releaseTime = releaseTime;
    }
    
}
