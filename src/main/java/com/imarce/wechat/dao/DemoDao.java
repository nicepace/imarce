package com.imarce.wechat.dao;


import org.springframework.stereotype.Repository;

import com.imarce.core.db.BaseDao;
import com.imarce.wechat.entity.Skill;

@Repository("demoDao")
public interface DemoDao extends BaseDao{

	/*
	 * 通过id获取到技能信息
	 */
	public Skill getSkillById();
}
