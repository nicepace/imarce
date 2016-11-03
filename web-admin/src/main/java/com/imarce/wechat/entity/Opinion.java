package com.imarce.wechat.entity;

import java.util.Date;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48 
 * 意见类
 */
public class Opinion {
    
    /**
     * 意见内容
     */
    private String opinion;
    /**
     * 微信用户ID
     */
    private Integer userId;
    /**
     * 发布时间
     */
    private Date releaseTime;
    
    public Opinion() {
        // TODO Auto-generated constructor stub
    }
    
    public Opinion(String opinion, Integer userId, Date releaseTime) {
        super();
        this.opinion = opinion;
        this.userId = userId;
        this.releaseTime = releaseTime;
    }
    
    public String getOpinion() {
        
        return opinion;
    }
    
    public void setOpinion( String opinion ) {
        
        this.opinion = opinion;
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
