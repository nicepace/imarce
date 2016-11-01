package com.imarce.wechat.entity;

import java.util.Date;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48 
 * 推荐类
 */
public class Recommend {
    
    /**
     * 被推荐人姓名
     */
    private String candidateName;
    /**
     * 被推荐人职位
     */
    private String candidatePosition;
    /**
     * 被推荐人联系方式
     */
    private String candidatePhone;
    /**
     * 推荐人姓名
     */
    private String recommendName;
    /**
     * 推荐人联系方式
     */
    private String recommendPhone;
    /**
     * 微信用户ID
     */
    private Integer userId;
    /**
     * 发布时间
     */
    private Date releaseTime;
    
    public Recommend() {
        // TODO Auto-generated constructor stub
    }
    
    public Recommend(String candidateName, String candidatePosition, String candidatePhone, String recommendName, String recommendPhone,
            Integer userId, Date releaseTime) {
        super();
        this.candidateName = candidateName;
        this.candidatePosition = candidatePosition;
        this.candidatePhone = candidatePhone;
        this.recommendName = recommendName;
        this.recommendPhone = recommendPhone;
        this.userId = userId;
        this.releaseTime = releaseTime;
    }
    
    public String getCandidateName() {
        
        return candidateName;
    }
    
    public void setCandidateName( String candidateName ) {
        
        this.candidateName = candidateName;
    }
    
    public String getCandidatePosition() {
        
        return candidatePosition;
    }
    
    public void setCandidatePosition( String candidatePosition ) {
        
        this.candidatePosition = candidatePosition;
    }
    
    public String getCandidatePhone() {
        
        return candidatePhone;
    }
    
    public void setCandidatePhone( String candidatePhone ) {
        
        this.candidatePhone = candidatePhone;
    }
    
    public String getRecommendName() {
        
        return recommendName;
    }
    
    public void setRecommendName( String recommendName ) {
        
        this.recommendName = recommendName;
    }
    
    public String getRecommendPhone() {
        
        return recommendPhone;
    }
    
    public void setRecommendPhone( String recommendPhone ) {
        
        this.recommendPhone = recommendPhone;
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
