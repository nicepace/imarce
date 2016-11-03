package com.imarce.webadmin.dao;

import java.util.List;

import com.imarce.webadmin.entity.vo.KnowledgeVO;
import com.imarce.webadmin.entity.vo.SkillVO;
import com.imarce.webadmin.util.Pager;

/**
  2016年7月5日 下午2:12:10
  @kriss
    说明：
    版本：
*/
public interface RequirementDao {

	/**
	 * 查询需求列表
	 * @return
	 */
	public List queryRequirements(Pager page) throws Exception;
	
	public int countRequirements() throws Exception;
	
	public int deleteRequirement(int requirementId) throws Exception;
	
	public List<KnowledgeVO> queryReqKnowledge(int requirementId) throws Exception;
	
	public List<SkillVO> queryReqSkill(int requirementId) throws Exception;
	
}
