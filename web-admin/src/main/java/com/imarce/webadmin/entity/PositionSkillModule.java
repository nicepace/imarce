package com.imarce.webadmin.entity;
/**
 * 
 * 2016年7月7日 下午9:35:05
 * @author shadow
 * 说明：岗位和技能模块对应关系实体类
 *
 */
public class PositionSkillModule {
	private int relationshipId;

	private Position position;

	private SkillModule skillModule;

	public int getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(int relationshipId) {
		this.relationshipId = relationshipId;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public SkillModule getSkillModule() {
		return skillModule;
	}

	public void setSkillModule(SkillModule skillModule) {
		this.skillModule = skillModule;
	}

}
