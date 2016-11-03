package com.imarce.webadmin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.KnowledgeDao;
import com.imarce.webadmin.entity.Knowledge;
import com.imarce.webadmin.entity.vo.ComboTreeLeafVO;
import com.imarce.webadmin.entity.vo.ComboTreeVO;
import com.imarce.webadmin.entity.vo.KnowledgeVO;
import com.imarce.webadmin.service.RequirementService;


/**
 * 
 * 2016年7月8日 上午7:56:56
 * @author shadow
 * 说明：技能知识表业务逻辑层实现类
 *
 */
@Service
public class KnowledgeServiceImpl {
	
	//日志对象
	Log  log  = LogFactory.getLog(RequirementService.class);
	
	//Knowledge数据访问层对象
	@Autowired
	private KnowledgeDao knowledgeDao;
	
	/**
	 * 查询技能知识
	 * @return List
	 */
	public List queryKnowledgeBySkillModule(int skillModuleId){
		List list = null;
		try {
			list = knowledgeDao.queryKnowledgeBySkillModule(skillModuleId);
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return list;
	}
	
	/**
	 * 根据id查询技能知识
	 * @return Knowledge
	 */
	public Knowledge queryKnowledgeById(int knowledgeId){
		Knowledge knowledge = new Knowledge();
		try {
			knowledge = knowledgeDao.queryKnowledgeById(knowledgeId);
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return knowledge;
	}
	
	/**
	 * 添加技能知识
	 * @param knowledge
	 * @return boolean
	 */
	public boolean addKnowledge(Knowledge knowledge){
		int line = 0;
		try {
			line = knowledgeDao.addKnowledge(knowledge);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return line > 0 ? true : false;
	}
	
	/**
	 * 修改技能知识
	 * @param knowledge
	 * @return boolean
	 */
	public boolean updateKnowledge(Knowledge knowledge){
		int line = 0;
		try {
			line = knowledgeDao.updateKnowledge(knowledge);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return line > 0 ? true : false;
	}
	
	public boolean deleteKnowledge(int knowledgeId){
		int line = 0;
		try {
			line = knowledgeDao.deleteKnowledge(knowledgeId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return line > 0 ? true : false;
	}
	
	
	/**
	 * 查询知识列表
	 * @param sid
	 * @return List
	 */
	public List queryKnowledgeList(int sid){
		List<ComboTreeLeafVO> knowledgeTree = new ArrayList<ComboTreeLeafVO>();
		try {
			List<KnowledgeVO> kvoList = knowledgeDao.queryKnowledgeBySkillModule(sid);
			for (KnowledgeVO knowledgeVO : kvoList) {
				ComboTreeLeafVO knowledgeEle = new ComboTreeLeafVO();
				knowledgeEle.setId(new Integer("4"+knowledgeVO.getId()));
				knowledgeEle.setText(knowledgeVO.getKnowledgeName());
				knowledgeTree.add(knowledgeEle);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return knowledgeTree;
	}
}
