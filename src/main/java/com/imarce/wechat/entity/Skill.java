package com.imarce.wechat.entity;

public class Skill {
	private Integer skillId;
	private String skillName;
	public Skill() {
		// TODO Auto-generated constructor stub
	}
	
	public Skill(String skillName) {
		super();
		this.skillName = skillName;
	}

	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}
	
}
