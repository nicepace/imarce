package com.imarce.webadmin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imarce.core.service.BaseService;
import com.imarce.core.service.Result;
import com.imarce.webadmin.dao.ReleaseRequirementDao;
import com.imarce.wechat.vo.CustomKnowledge;
import com.imarce.wechat.vo.CustomSkill;
import com.imarce.wechat.vo.RequirementKnowledgeVo;
import com.imarce.wechat.vo.RequirementSkillVo;
import com.imarce.wechat.vo.RequirementVo;

/**
* @version
* @author xsc 
* @time 2016年6月16日下午9:48:16
* 发布需求的业务逻辑层
*/
@Service("/release_requirement")
@Transactional
public class ReleaseRequirementService extends BaseService {

	/**
	 * 发布需求数据访问层对象
	 */
	@Autowired
	private ReleaseRequirementDao releaseRequirementDao;
	
	/**
	 * 1.将requirementVo对象存入数据库发布需求表中
	 * 2.将选择知识与对应的需求id存入数据库关系表中
	 * 3.将选择技能与对应的需求id存入数据库关系表中
	 * 4.将选择自定义知识与对应的需求id存入数据库技能表中
	 * 5.将选择自定义技能与对应的需求id存入数据库技能表中
	 * @param requirementVo
	 */
	public Result insertInto(RequirementVo requirementVo,String positionName,List<String> knowledgeNameList,List<String> skillNameList,List<String> customKnowledgeNameList,List<String> customSkillNameList){
		Result result = new Result();
			try {
				if(requirementVo!=null){
					int positionId = releaseRequirementDao.getPositionIdByPositionName(positionName);
					requirementVo.setPositionId(positionId);
					releaseRequirementDao.insertIntoRequirement(requirementVo);
					
					if(customKnowledgeNameList==null){
						if(knowledgeNameList==null){
							
						}else{
							List<RequirementKnowledgeVo> requirementKnowledgeVoList = new ArrayList<RequirementKnowledgeVo>();
							for (int i = 0; i < knowledgeNameList.size(); i++) {
								RequirementKnowledgeVo requirementKnowledgeVo = new RequirementKnowledgeVo();
								requirementKnowledgeVo.setRequirementId(requirementVo.getRequirementId());
								Integer knowledgeId = releaseRequirementDao.getKnowledgeIdByKnowledgeName(knowledgeNameList.get(i));
								requirementKnowledgeVo.setKnowledgeId(knowledgeId);
								requirementKnowledgeVoList.add(requirementKnowledgeVo);
							}
							for (RequirementKnowledgeVo requirementKnowledge : requirementKnowledgeVoList) {
								releaseRequirementDao.insertIntoRequirementKnowledge(requirementKnowledge);
							}
						}
					}else{
						List<CustomKnowledge> customKnowledgeList = new ArrayList<CustomKnowledge>();
						for(String customKnowledgeName:customKnowledgeNameList){
							CustomKnowledge customKnowledge = new CustomKnowledge();
							customKnowledge.setRequirementId(requirementVo.getRequirementId());
							customKnowledge.setKnowledgeName(customKnowledgeName);
							customKnowledge.setSkillmoduleId(8);
							customKnowledgeList.add(customKnowledge);
						}
						for (CustomKnowledge customKnowledge : customKnowledgeList) {
							releaseRequirementDao.insertIntoKnowledge(customKnowledge);
						}
						if(knowledgeNameList.size()-customKnowledgeNameList.size()>0){
							List<RequirementKnowledgeVo> requirementKnowledgeVoList = new ArrayList<RequirementKnowledgeVo>();
							for (int i = 0; i < (knowledgeNameList.size()-customKnowledgeNameList.size()); i++) {
								RequirementKnowledgeVo requirementKnowledgeVo = new RequirementKnowledgeVo();
								requirementKnowledgeVo.setRequirementId(requirementVo.getRequirementId());
								Integer knowledgeId = releaseRequirementDao.getKnowledgeIdByKnowledgeName(knowledgeNameList.get(i));
								requirementKnowledgeVo.setKnowledgeId(knowledgeId);
								requirementKnowledgeVoList.add(requirementKnowledgeVo);
							}
							for (RequirementKnowledgeVo requirementKnowledge : requirementKnowledgeVoList) {
								releaseRequirementDao.insertIntoRequirementKnowledge(requirementKnowledge);
							}
						}
					}	
					
					if(customSkillNameList==null){
						if(skillNameList==null){
							
						}else{
							List<RequirementSkillVo> requirementSkillVoList = new ArrayList<RequirementSkillVo>();
							for (int i = 0; i < skillNameList.size(); i++) {
								RequirementSkillVo requirementSkillVo = new RequirementSkillVo();
								requirementSkillVo.setRequirementId(requirementVo.getRequirementId());
								Integer skillId = releaseRequirementDao.getSkillIdBySkillName(skillNameList.get(i));
								requirementSkillVo.setSkillId(skillId);
								requirementSkillVoList.add(requirementSkillVo);
							}
							for (RequirementSkillVo requirementSkill : requirementSkillVoList) {
								releaseRequirementDao.insertIntoRequirementSkill(requirementSkill);
							}
						}
					}else{
						List<CustomSkill> customSkillList = new ArrayList<CustomSkill>();
						for (String customSkillName : customSkillNameList) {
							CustomSkill customSkill = new CustomSkill();
							customSkill.setRequirementId(requirementVo.getRequirementId());
							customSkill.setSkillName(customSkillName);
							customSkillList.add(customSkill);
						}
						for (CustomSkill customSkill : customSkillList) {
							releaseRequirementDao.insertIntoSkill(customSkill);
						}
						if(skillNameList.size()-customSkillNameList.size()>0){
							List<RequirementSkillVo> requirementSkillVoList = new ArrayList<RequirementSkillVo>();
							for (int i = 0; i < (skillNameList.size()-customSkillNameList.size()); i++) {
								RequirementSkillVo requirementSkillVo = new RequirementSkillVo();
								requirementSkillVo.setRequirementId(requirementVo.getRequirementId());
								Integer skillId = releaseRequirementDao.getSkillIdBySkillName(skillNameList.get(i));
								requirementSkillVo.setSkillId(skillId);
								requirementSkillVoList.add(requirementSkillVo);
							}
							for (RequirementSkillVo requirementSkill : requirementSkillVoList) {
								releaseRequirementDao.insertIntoRequirementSkill(requirementSkill);
							}
						}
					}
					result.setCode(1);
					result.setMsg( "您已成功发布职位需求，</br>我们将尽快与您联系" );
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return result;
	}

	
	/**
	 * 显示所有岗位的方法
	 * @return 岗位对象集合
	 */
	public Result showPosition(){
		Result result = new Result();
		try {
			if(releaseRequirementDao.showPosition()!=null){
				result.setCode(1);
				result.setObjResult(releaseRequirementDao.showPosition());
			}else{
				result.setCode(0);
				result.setMsg("没有数据！");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 显示所选岗位的所有技能模块的方法
	 * @param position岗位对象
	 * @return 技能模块对象集合
	 */
	public Result showSkillmodule(String positionName){
		Result result = new Result();
		try {
			int positionId = releaseRequirementDao.getPositionIdByPositionName(positionName);
			if(!releaseRequirementDao.showSkillmodule(positionId).isEmpty()){
				result.setCode(1);
				result.setObjResult(releaseRequirementDao.showSkillmodule(positionId));
			}else{
				result.setCode(0);
				result.setMsg("没有数据！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 显示所有技能的方法
	 * @return 技能对象集合
	 */
	public Result showSkill(){
		Result result = new Result();
		try {
			if(releaseRequirementDao.showSkill()!=null){
				result.setCode(1);
				result.setObjResult(releaseRequirementDao.showSkill());
			}else{
				result.setCode(0);
				result.setMsg("没有数据！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
