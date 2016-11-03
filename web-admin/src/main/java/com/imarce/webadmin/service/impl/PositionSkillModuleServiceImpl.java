package com.imarce.webadmin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.KnowledgeDao;
import com.imarce.webadmin.dao.PositionDao;
import com.imarce.webadmin.dao.PositionSkillModuleDao;
import com.imarce.webadmin.dao.StudentKnowledgeDao;
import com.imarce.webadmin.entity.PositionSkillModule;
import com.imarce.webadmin.entity.vo.ComboTreeLeafVO;
import com.imarce.webadmin.entity.vo.ComboTreeVO;
import com.imarce.webadmin.entity.vo.KnowledgeVO;
import com.imarce.webadmin.entity.vo.SkillVO;
import com.imarce.webadmin.service.RequirementService;

/**
 * 
 * 2016年7月8日 上午8:29:30
 * @author shadow
 * 说明：岗位和技能关系表业务逻辑层的实现类
 *
 */
@Service
public class PositionSkillModuleServiceImpl {
	//日志对象
	Log  log  = LogFactory.getLog(RequirementService.class);
	
	//PositionSkillModule数据访问层对象
	@Autowired
	private PositionSkillModuleDao positionSkillModuleDao;
	@Autowired
	private PositionDao pDao;
	@Autowired
	private StudentKnowledgeDao skDao;
	@Autowired
	private KnowledgeDao kDao;
	
	/**
	 * 根据岗位id查询岗位技能
	 * @param positionId
	 * @return List
	 */
	public List querySkillByPosition(int positionId){
		List list = null;
		try {
			list = positionSkillModuleDao.querySkillByPosition(positionId);
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		
		return list;
	}
	/**
	 * 向岗位和技能关系表添加新关系
	 * @param relationship
	 * @return boolean
	 */
	public boolean addRelationship(PositionSkillModule relationship){
		int line = 0;
		try {
			line = positionSkillModuleDao.addRelationship(relationship);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return line > 0 ? true : false;
	}
	/**
	 * 查询技能和掌握的列表
	 * @param pid
	 * @param stuId
	 * @return List<ComboTreeVO>
	 */
	public List<ComboTreeVO> querySkillModuleAndKnowledge(int pid,int stuId){
		//根节点列表
		List<ComboTreeVO> rootList = new ArrayList<ComboTreeVO>();
		try {
			//根节点
			ComboTreeVO rootTree = new ComboTreeVO();
			rootList.add(rootTree);
			//添加根节点id（岗位标识符2+岗位id）
			rootTree.setId(new Integer("2"+pid));
			rootTree.setText(pDao.queryPositionById(pid).getPositionName()+"技能模块");
			rootTree.setState("open");
			//技能节点列表
			List<ComboTreeVO> skillmoduleList = new ArrayList<ComboTreeVO>();
			rootTree.setChildren(skillmoduleList);
			List<SkillVO> svoList = positionSkillModuleDao.querySkillByPosition(pid);
			//学生掌握知识列表
			List<KnowledgeVO> kvoCheckedList = skDao.queryStudentKnowledge(stuId);
			//展开的知识列表
			List<KnowledgeVO> kvoList = new ArrayList<KnowledgeVO>(); 		

			for (SkillVO skillVO: svoList) {
				//技能节点
				ComboTreeVO skillmoduleEle = new ComboTreeVO();
				//添加技能节点id（技能节点标识符3+技能id）
				skillmoduleEle.setId(new Integer("3"+skillVO.getId()));
				skillmoduleEle.setText(skillVO.getSkillModuleName());
				//添加技能节点列表数据
				skillmoduleList.add(skillmoduleEle);
			}
			
			for (KnowledgeVO kChecked : kvoCheckedList) {
				int sid = kDao.querySkillModuleIdByKnowledge(kChecked.getId());
				for(int i=0;i<skillmoduleList.size();i++){
					int sl_id = new Integer((skillmoduleList.get(i).getId()+"").substring(1));
					if(sid==sl_id){
						if(skillmoduleList.get(i).getChildren()==null){
							kvoList = kDao.queryKnowledgeBySkillModule(sid);
							//知识节点列表
							List<ComboTreeLeafVO> knowledgeList = new ArrayList<ComboTreeLeafVO>();
							for (KnowledgeVO kvo : kvoList) {
								ComboTreeLeafVO knowledgeEle = new ComboTreeLeafVO();
								//添加知识节点id（知识节点标识符4+知识id）
								knowledgeEle.setId(new Integer("4"+kvo.getId()));
								knowledgeEle.setText(kvo.getKnowledgeName());
								for (KnowledgeVO kCheck : kvoCheckedList) {
									if(kCheck.getId()==kvo.getId()){
										knowledgeEle.setChecked(true);
										break;
									}
								}
								//添加知识节点列表数据
								knowledgeList.add(knowledgeEle);
							}
							System.out.println();
							skillmoduleList.get(i).setChildren(knowledgeList);
							skillmoduleList.get(i).setState("open");
							break;
						}
					}
				}				
			}				
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return rootList;
	}
	
	/**
	 * 查询技能模块列表
	 * @param pid
	 * @return List<ComboTreeVO>
	 */
	
	public List<ComboTreeVO> querySkillModuleList(int pid){
		//根节点列表
		List<ComboTreeVO> rootList = new ArrayList<ComboTreeVO>();
		try {
			//根节点
			ComboTreeVO rootTree = new ComboTreeVO();
			rootList.add(rootTree);
			//添加根节点id（岗位标识符2+岗位id）
			rootTree.setId(new Integer("2"+pid));
			rootTree.setText(pDao.queryPositionById(pid).getPositionName()+"技能模块");
			rootTree.setState("open");
			//技能节点列表
			List<ComboTreeVO> skillmoduleList = new ArrayList<ComboTreeVO>();
			rootTree.setChildren(skillmoduleList);
			List<SkillVO> svoList = positionSkillModuleDao.querySkillByPosition(pid);
			for (SkillVO skillVO: svoList) {
				//技能节点
				ComboTreeVO skillmoduleEle = new ComboTreeVO();
				//添加技能节点id（技能节点标识符3+技能id）
				skillmoduleEle.setId(new Integer("3"+skillVO.getId()));
				skillmoduleEle.setText(skillVO.getSkillModuleName());
				//添加技能节点列表数据
				skillmoduleList.add(skillmoduleEle);
			}				
		} catch (Exception e) {
			e.printStackTrace();
		    log.error(e.getMessage());
		}
		return rootList;
	}
}
