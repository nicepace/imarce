package com.imarce.wechat.entity;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48
 * 知识类
 */
public class Knowledge {
    
    /**
     * 知识ID
     */
    private Integer knowledgeId;
    /**
     * 知识名称
     */
    private String knowledgeName;
    
    public Knowledge() {
        // TODO Auto-generated constructor stub
    }
    
    public Knowledge(String knowledgeName) {
        super();
        this.knowledgeName = knowledgeName;
    }
    
    public Integer getKnowledgeId() {
        
        return knowledgeId;
    }
    
    public void setKnowledgeId( Integer knowledgeId ) {
        
        this.knowledgeId = knowledgeId;
    }
    
    public String getknowledgeName() {
        
        return knowledgeName;
    }
    
    public void setknowledgeName( String knowledgeName ) {
        
        this.knowledgeName = knowledgeName;
    }
    
}
