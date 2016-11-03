package com.imarce.webadmin.dao;

import java.util.List;

import com.imarce.core.db.BaseDao;
import com.imarce.wechat.entity.Position;
import com.imarce.wechat.entity.Skill;
import com.imarce.wechat.vo.CustomKnowledge;
import com.imarce.wechat.vo.CustomSkill;
import com.imarce.wechat.vo.RequirementKnowledgeVo;
import com.imarce.wechat.vo.RequirementSkillVo;
import com.imarce.wechat.vo.RequirementVo;
import com.imarce.wechat.vo.SkillmoduleVo;

/*
*@version 
*@author xsc
*@ time 2016年6月15日下午5:43:55
*发布需求的数据访问层
*/
public interface ReleaseRequirementDao extends BaseDao{
	
	/**
	 * 将需求对象存入数据库的Requirement表中的方法
	 * @param requirementVo需求对象
	 */
	public void insertIntoRequirement(RequirementVo requirementVo) throws Exception;
	
	/**
	 * 根据需求对象在数据库的requirement_knowledge关系表中添加数据的方法
	 * @param requirementVo需求对象
	 */
	public void insertIntoRequirementKnowledge(RequirementKnowledgeVo requirementKnowledgeVo) throws Exception;
	
	/**
	 * 根据需求对象在数据库的requirement_skill关系表中添加数据的方法
	 * @param requirementVo需求对象
	 */
	public void insertIntoRequirementSkill(RequirementSkillVo requirementSkillVo) throws Exception;
	
	/**
	 * 在skill表中添加自定义的技能的方法
	 * @param customSkill需求对象
	 */
	public void insertIntoSkill(CustomSkill customSkill) throws Exception;
	
	/**
	 * 在knowledge表中添加自定义的知识的方法
	 * @param customKnowledge需求对象
	 */
	public void insertIntoKnowledge(CustomKnowledge customKnowledge) throws Exception;
	
	/**
	 * 显示所有岗位的方法
	 * @return 岗位对象集合
	 */
	public List<Position> showPosition() throws Exception;
	
	/**
	 * 显示所选岗位的所有技能模块的方法
	 * @param position岗位对象
	 * @return 技能模块对象集合
	 */
	public List<SkillmoduleVo> showSkillmodule(int positionId) throws Exception;

	/**
	 * 显示所有技能的方法
	 * @return 技能对象集合
	 */
	public List<Skill> showSkill() throws Exception;
	
	/**
	 * 通过知识名称获取知识id
	 * @return 知识id
	 * @throws Exception
	 */
	public Integer getKnowledgeIdByKnowledgeName(String knowledgeName) throws Exception;
	
	/**
	 * 通过技能名称获取技能id
	 * @return 技能id
	 * @throws Exception
	 */
	public Integer getSkillIdBySkillName(String skillName) throws Exception;
	
	/**
	 * 通过知识名称获取知识id
	 * @return 知识id
	 * @throws Exception
	 */
	public Integer getPositionIdByPositionName(String positionName) throws Exception;

}
