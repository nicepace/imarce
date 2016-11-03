package com.imarce.wechat.entity;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48 
 * 技能模块知识关系类
 */
public class SkillmoduleKnowledge {
    
    /**
     * 关系ID
     */
    private Integer relationShipId;
    /**
     * 技能模块ID
     */
    private Integer skillmoduleId;
    /**
     * 知识ID
     */
    private Integer knowledge;
    
    public SkillmoduleKnowledge() {
        // TODO Auto-generated constructor stub
    }
    
    public SkillmoduleKnowledge(Integer skillmoduleId, Integer knowledge) {
        super();
        this.skillmoduleId = skillmoduleId;
        this.knowledge = knowledge;
    }
    
    public Integer getRelationShipId() {
        
        return relationShipId;
    }
    
    public void setRelationShipId( Integer relationShipId ) {
        
        this.relationShipId = relationShipId;
    }
    
    public Integer getSkillmoduleId() {
        
        return skillmoduleId;
    }
    
    public void setSkillmoduleId( Integer skillmoduleId ) {
        
        this.skillmoduleId = skillmoduleId;
    }
    
    public Integer getKnowledge() {
        
        return knowledge;
    }
    
    public void setKnowledge( Integer knowledge ) {
        
        this.knowledge = knowledge;
    }
    
}
