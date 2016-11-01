package com.imarce.wechat.entity;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48
 * 学员知识关系表
 */
public class StudentKnowledge {
    
    /**
     * 学员知识ID
     */
    private Integer studentKnowledgeId;
    /**
     * 学员ID
     */
    private Integer studentId;
    /**
     * 知识ID
     */
    private Integer knowledgeId;
    
    public StudentKnowledge() {
        // TODO Auto-generated constructor stub
    }
    
    public StudentKnowledge(Integer studentId, Integer knowledgeId) {
        super();
        this.studentId = studentId;
        this.knowledgeId = knowledgeId;
    }
    
    public Integer getStudentKnowledgeId() {
        
        return studentKnowledgeId;
    }
    
    public void setStudentKnowledgeId( Integer studentKnowledgeId ) {
        
        this.studentKnowledgeId = studentKnowledgeId;
    }
    
    public Integer getStudentId() {
        
        return studentId;
    }
    
    public void setStudentId( Integer studentId ) {
        
        this.studentId = studentId;
    }
    
    public Integer getKnowledgeId() {
        
        return knowledgeId;
    }
    
    public void setKnowledgeId( Integer knowledgeId ) {
        
        this.knowledgeId = knowledgeId;
    }
    
}
