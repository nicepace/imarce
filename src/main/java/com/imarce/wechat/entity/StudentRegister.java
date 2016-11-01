package com.imarce.wechat.entity;

import java.util.Date;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48 
 * 注册i码士类
 */
public class StudentRegister {
    
    /**
     * 学员姓名
     */
    private String studentName;
    /**
     * 学员QQ
     */
    private String studentQQ;
    /**
     * 学员手机号码
     */
    private String studentPhone;
    /**
     * 学员所在城市
     */
    private String studentCity;
    /**
     * 学员注册ip
     */
    private String studentRegister_ip;
    /**
     * 微信用户id
     */
    private String userId;
    /**
     * 发布时间
     */
    private Date releaseTime;
    
    public StudentRegister() {
        // TODO Auto-generated constructor stub
    }
    
    public StudentRegister( String studentName, String studentQQ, String studentPhone, String studentCity, String studentRegister_ip,
            String userId, Date releseTime) {
        super();
        this.studentName = studentName;
        this.studentQQ = studentQQ;
        this.studentPhone = studentPhone;
        this.studentCity = studentCity;
        this.studentRegister_ip = studentRegister_ip;
        this.userId = userId;
        this.releaseTime = releseTime;
    }
    
    
    public String getStudentName() {
        
        return studentName;
    }
    
    public void setStudentName( String studentName ) {
        
        this.studentName = studentName;
    }
    
    public String getStudentQQ() {
        
        return studentQQ;
    }
    
    public void setStudentQQ( String studentQq ) {
        
        this.studentQQ = studentQq;
    }
    
    public String getStudentPhone() {
        
        return studentPhone;
    }
    
    public void setStudentPhone( String studentPhone ) {
        
        this.studentPhone = studentPhone;
    }
    
    public String getStudentCity() {
        
        return studentCity;
    }
    
    public void setStudentCity( String studentCity ) {
        
        this.studentCity = studentCity;
    }
    
    public String getStudentRegister_ip() {
        
        return studentRegister_ip;
    }
    
    public void setStudentRegister_ip( String studentRegister_ip ) {
        
        this.studentRegister_ip = studentRegister_ip;
    }
    
    public String getUserId() {
        
        return userId;
    }
    
    public void setUserId( String userId ) {
        
        this.userId = userId;
    }
    
    public Date getReleseTime() {
        
        return releaseTime;
    }
    
    public void setReleseTime( Date releseTime ) {
        
        this.releaseTime = releseTime;
    }
    
}
