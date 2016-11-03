package com.imarce.webadmin.dao;

import java.util.List;

import com.imarce.webadmin.entity.PositionSkillModule;

/**
 * 
 * 2016年7月8日 上午8:16:53
 * @author shadow
 * 说明：岗位和技能关系表数据访问层
 *
 */
public interface PositionSkillModuleDao {

	public List querySkillByPosition(int positionId) throws Exception;
	
	public int addRelationship(PositionSkillModule relationship) throws Exception;
}
