package com.imarce.wechat.vo;
/*
*@version 
*@author xsc
*@ time 2016年6月20日下午12:13:15
*/
public class RequirementKnowledgeVo {

	/**
	 * 需求id
	 */
	private Integer requirementId;
	
	/**
	 * 知识id
	 */
	private Integer knowledgeId;
	
	public RequirementKnowledgeVo(){}

	public RequirementKnowledgeVo(Integer requirementId, Integer knowledgeId) {
		super();
		this.requirementId = requirementId;
		this.knowledgeId = knowledgeId;
	}

	public Integer getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}

	public Integer getKnowledgeId() {
		return knowledgeId;
	}

	public void setKnowledgeId(Integer knowledgeId) {
		this.knowledgeId = knowledgeId;
	}
	
	
}
