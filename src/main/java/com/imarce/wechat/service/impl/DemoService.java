package com.imarce.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.imarce.core.service.BaseService;
import com.imarce.wechat.dao.DemoDao;
import com.imarce.wechat.entity.Skill;

@Service("demoService")
public class DemoService extends BaseService {

	@Autowired
	private DemoDao  demoDao;
	
	public Skill getSkillById(){
		return demoDao.getSkillById();
	}
	

}
