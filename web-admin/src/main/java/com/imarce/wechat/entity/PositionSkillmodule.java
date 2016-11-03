package com.imarce.wechat.entity;

/**
 * @version 1.0
 * @author zhoujb,zjf
 * @time 2016年6月15日上午11:08:48 
 * 职位与技能模块关系类
 */
public class PositionSkillmodule {
    
    /**
     * 关系ID
     */
    private Integer relationshipId;
    /**
     * 职位ID
     */
    private Integer positionId;
    /**
     * 技能模块ID
     */
    private Integer skillmoduleId;
    
    public PositionSkillmodule() {
        // TODO Auto-generated constructor stub
    }
    
    public PositionSkillmodule(Integer positionId, Integer skillmoduleId) {
        super();
        this.positionId = positionId;
        this.skillmoduleId = skillmoduleId;
    }
    
    public Integer getRelationshipId() {
        
        return relationshipId;
    }
    
    public void setRelationshipId( Integer relationshipId ) {
        
        this.relationshipId = relationshipId;
    }
    
    public Integer getPositionId() {
        
        return positionId;
    }
    
    public void setPositionId( Integer positionId ) {
        
        this.positionId = positionId;
    }
    
    public Integer getSkillmoduleId() {
        
        return skillmoduleId;
    }
    
    public void setSkillmoduleId( Integer skillmoduleId ) {
        
        this.skillmoduleId = skillmoduleId;
    }
    
}
