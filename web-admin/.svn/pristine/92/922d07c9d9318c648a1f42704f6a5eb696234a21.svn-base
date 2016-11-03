package com.imarce.webadmin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.PositionSkillModuleDao;
import com.imarce.webadmin.dao.SkillModuleDao;
import com.imarce.webadmin.entity.Position;
import com.imarce.webadmin.entity.PositionSkillModule;
import com.imarce.webadmin.entity.SkillModule;
import com.imarce.webadmin.service.RequirementService;

/**
 * 
 * 2016年7月7日 下午10:05:52
 * @author shadow
 * 说明：岗位技能表业务逻辑层的实现类
 *
 */
@Service
public class SkillModuleServiceImpl {
	//日志对象
	Log  log  = LogFactory.getLog(RequirementService.class);
	
	//SkillModule数据访问层对象
	@Autowired
	private SkillModuleDao skillModuleDao;
	
	@Autowired
	private PositionSkillModuleDao psDao;
	
	/**
	 * 查询岗位技能
	 * @return List
	 */
	public List querySkillModule(){
		List list = null;
		try {
			list = skillModuleDao.querySkillModule();
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return list;
	}
	
	/**
	 * 根据id查询岗位技能
	 * @return List
	 */
	public SkillModule querySkillModuleById(int skillModuleId){
		SkillModule skillModule = new SkillModule();
		try {
			skillModule = skillModuleDao.querySkillModuleById(skillModuleId);
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return skillModule;
	}
	
	
	
	/**
	 * 添加岗位技能
	 * @param skillModule
	 * @return boolean
	 */
	public boolean addSkillModule(SkillModule skillModule, int pid){
		int sLine = 0;
		int psLine = 0;
		try {
			PositionSkillModule relationship = new PositionSkillModule();
			Position position = new Position();
			sLine = skillModuleDao.addSkillModule(skillModule);
			if(sLine>0){
				position.setPositionId(pid);
				relationship.setPosition(position);
				relationship.setSkillModule(skillModule);
				psLine = psDao.addRelationship(relationship);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return (sLine > 0 && psLine > 0) ? true : false;
	}
	
	/**
	 * 修改岗位技能
	 * @param skillModule
	 * @return boolean
	 */
	public boolean updateSkillModule(SkillModule skillModule){
		int line = 0;
		try {
			line = skillModuleDao.updateSkillModule(skillModule);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return line > 0 ? true : false;
	}
	
	public boolean deleteSkillModule(int skillModuleId){
		int line = 0;
		try {
			line = skillModuleDao.deleteSkillModule(skillModuleId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return line > 0 ? true : false;
	}
	
}
