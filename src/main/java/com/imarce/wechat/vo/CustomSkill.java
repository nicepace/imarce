package com.imarce.wechat.vo;
/**
* @version
* @author xsc 
* @time 2016年6月16日下午9:10:45
* 自定义技能类
*/
public class CustomSkill {

	/**
	 * 技能id
	 */
	private Integer skillId;
	/**
	 * 技能名称
	 */
	private String skillName;
	
	/**
	 * 需求id
	 */
	private Integer requirementId;
	
	public CustomSkill(){
		
	}
	
	public CustomSkill(String skillName, Integer requirementId) {
		super();
		this.skillName = skillName;
		this.requirementId = requirementId;
	}

	public CustomSkill(Integer skillId, String skillName, Integer requirementId) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.requirementId = requirementId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
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
