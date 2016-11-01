package com.imarce.wechat.vo;
/*
*@version 
*@author xsc
*@ time 2016年6月20日下午12:15:33
*/
public class RequirementSkillVo {

	/**
	 * 需求id
	 */
	private Integer requirementId;
	
	/**
	 * 技能id
	 */
	private Integer skillId;
	
	public RequirementSkillVo(){}

	public RequirementSkillVo(Integer requirementId, Integer skillId) {
		super();
		this.requirementId = requirementId;
		this.skillId = skillId;
	}

	public Integer getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}
	
	
}
