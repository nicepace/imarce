package com.imarce.wechat.vo;
/**
* @version
* @author xsc 
* @time 2016年6月16日下午9:10:45
* 自定义知识类
*/
public class CustomKnowledge {

	/**
	 * 知识id
	 */
	private Integer knowledgeId;
	/**
	 * 知识名称
	 */
	private String knowledgeName;
	/**
	 * 技能模块id（属于其他技能模块）
	 */
	private Integer skillmoduleId;
	/**
	 * 需求id
	 */
	private Integer requirementId;
	
	public CustomKnowledge(){
		
	}

	public CustomKnowledge(String knowledgeName, Integer requirementId) {
		super();
		this.knowledgeName = knowledgeName;
		this.requirementId = requirementId;
	}

	public CustomKnowledge(Integer knowledgeId, String knowledgeName, Integer skillmoduleId, Integer requirementId) {
		super();
		this.knowledgeId = knowledgeId;
		this.knowledgeName = knowledgeName;
		this.skillmoduleId = skillmoduleId;
		this.requirementId = requirementId;
	}

	public String getKnowledgeName() {
		return knowledgeName;
	}

	public void setKnowledgeName(String knowledgeName) {
		this.knowledgeName = knowledgeName;
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

	public Integer getSkillmoduleId() {
		return skillmoduleId;
	}

	public void setSkillmoduleId(Integer skillmoduleId) {
		this.skillmoduleId = skillmoduleId;
	}
	
	
}
