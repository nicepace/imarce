package com.imarce.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.imarce.core.service.Result;
import com.imarce.wechat.entity.Knowledge;
import com.imarce.wechat.entity.Position;
import com.imarce.wechat.entity.Skill;
import com.imarce.wechat.service.impl.ReleaseRequirementService;
import com.imarce.wechat.vo.CustomKnowledge;
import com.imarce.wechat.vo.CustomSkill;
import com.imarce.wechat.vo.RequirementVo;
import com.imarce.wechat.vo.SkillmoduleVo;

/*
*@version 
*@author xsc
*@ time 2016年6月23日上午9:36:09
*/
public class TestReleaseRequirementService {

	
	ApplicationContext ac = null;
	
	@Before
	public void init(){
		 ac = new ClassPathXmlApplicationContext("spring*.xml");
	}
	@Test
	public void testInsertInto(){
		ReleaseRequirementService rrs = ac.getBean(ReleaseRequirementService.class);
		RequirementVo rv = new RequirementVo();
		rv.setCompanyName("京东");
		rv.setContacts("刘强东");
		rv.setPhoneNumber("13888888888");
		rv.setSalaryMin(50000.0);
		rv.setSalaryMax(100000.0);
		rv.setRequirementIntroduce("京东");
		String positionName = "java开发工程师";
		List<String> knowledgeNameList = new ArrayList<String>();
		knowledgeNameList.add("Mysql");
		knowledgeNameList.add("Redis");
		List<String> skillNameList = new ArrayList<String>();
		skillNameList.add("大数据");
		skillNameList.add("高并发");
		skillNameList.add("PHP");
		List<String> customSkillNameList = new ArrayList<String>();
		customSkillNameList.add("技能1");
		customSkillNameList.add("技能2");
		customSkillNameList.add("技能3");
		List<String> customKnowledgeNameList = new ArrayList<String>();
		customKnowledgeNameList.add("知识1");
		customKnowledgeNameList.add("知识2");
		customKnowledgeNameList.add("知识3");
		rrs.insertInto(rv, positionName, knowledgeNameList, skillNameList, customKnowledgeNameList, customSkillNameList);
	}
	
	@Test
	public void testShowPosition(){
		ReleaseRequirementService rrs = ac.getBean(ReleaseRequirementService.class);
		Result result = rrs.showPosition();
		List<Position> positionList= (List<Position>)result.getObjResult();
		for (Position position : positionList) {
			System.out.println(position.getPositionName());
		}
	}
	
	@Test
	public void testShowSkillmodule(){
		ReleaseRequirementService rrs = ac.getBean(ReleaseRequirementService.class);
		Result result = rrs.showSkillmodule("java开发工程师");
		List<SkillmoduleVo> skillmoduleVoList = (List<SkillmoduleVo>)result.getObjResult();
		for (SkillmoduleVo skillmoduleVo : skillmoduleVoList) {
			System.out.println(skillmoduleVo.getSkillmoduleName());
			List<Knowledge> knowledgeList = skillmoduleVo.getKnowledgeList();
			for (Knowledge knowledge : knowledgeList) {
				System.out.println(knowledge.getknowledgeName());
			}
			System.out.println("*******************************");
		}	
	}
	
	@Test
	public void testShowSkill(){
		ReleaseRequirementService rrs = ac.getBean(ReleaseRequirementService.class);
		Result result = rrs.showSkill();
		List<Skill> skillList= (List<Skill>)result.getObjResult();
		for (Skill skill : skillList) {
			System.out.println(skill.getSkillName());
		}
	}
}
