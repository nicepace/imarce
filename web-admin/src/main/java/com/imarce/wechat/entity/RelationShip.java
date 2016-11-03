package com.imarce.wechat.entity;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48 
 * 发布需求关系类
 */
public class RelationShip {
    
    /**
     * 需求ID
     */
    private Integer requirementId;
    /**
     * 技能ID
     */
    private Integer SkillId;
    
    public RelationShip() {
        // TODO Auto-generated constructor stub
    }
    
    public RelationShip(Integer requirementId, Integer skillId) {
        super();
        this.requirementId = requirementId;
        SkillId = skillId;
    }
    
    public Integer getRequirementId() {
        
        return requirementId;
    }
    
    public void setRequirementId( Integer requirementId ) {
        
        this.requirementId = requirementId;
    }
    
    public Integer getSkillId() {
        
        return SkillId;
    }
    
    public void setSkillId( Integer skillId ) {
        
        SkillId = skillId;
    }
    
}
