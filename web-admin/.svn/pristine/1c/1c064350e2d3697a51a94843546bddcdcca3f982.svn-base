package com.imarce.webadmin.dao;

import java.util.List;

import com.imarce.webadmin.entity.Knowledge;

/**
 * 
 * 2016年7月8日 上午7:42:59
 * @author shadow
 * 说明：技能知识表数据访问层
 *
 */
public interface KnowledgeDao {
	
	public List queryKnowledgeBySkillModule(int skillModuleId) throws Exception;
	
	public Knowledge queryKnowledgeById(int knowledgeId) throws Exception;
	
	public int addKnowledge(Knowledge knowledge) throws Exception;
	
	public int updateKnowledge(Knowledge knowledge) throws Exception;
	
	public int deleteKnowledge(int knowledgeId) throws Exception;
	
	public int querySkillModuleIdByKnowledge(int knowledgeId) throws Exception;
}
