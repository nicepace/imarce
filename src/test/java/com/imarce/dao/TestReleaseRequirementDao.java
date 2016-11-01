package com.imarce.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.imarce.wechat.dao.ReleaseRequirementDao;
import com.imarce.wechat.entity.Position;
import com.imarce.wechat.entity.Skill;
import com.imarce.wechat.vo.CustomKnowledge;
import com.imarce.wechat.vo.CustomSkill;
import com.imarce.wechat.vo.RequirementKnowledgeVo;
import com.imarce.wechat.vo.RequirementSkillVo;
import com.imarce.wechat.vo.RequirementVo;
import com.imarce.wechat.vo.SkillmoduleVo;

/*
*@version 
*@author xsc
*@ time 2016年6月21日下午5:02:47
*/
public class TestReleaseRequirementDao {

	ApplicationContext ac = null;
	
	@Before
	public void init(){
		 ac = new ClassPathXmlApplicationContext("spring*.xml");
	}
	
	
	@Test
	public void testShow(){
		ReleaseRequirementDao  rrd   = ac.getBean(ReleaseRequirementDao.class);
			try {
				List<Position> positionList;
				positionList = rrd.showPosition();
				System.out.println("岗位的个数："+positionList.size());
				List<Skill> skillList = rrd.showSkill();
				System.out.println("技能的个数："+skillList.size());
				List<SkillmoduleVo> skillmoduleList = rrd.showSkillmodule(1);
				System.out.println("技能模块的个数："+skillmoduleList.size());
				System.out.println("第一个技能模块里知识的个数："+skillmoduleList.get(0).getKnowledgeList().size());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@Test
	public void testInsertRequirement(){
		ReleaseRequirementDao rrd = ac.getBean(ReleaseRequirementDao.class);
		try {
			RequirementVo rv = new RequirementVo();
			rv.setCompanyName("网易");
			rv.setContacts("丁磊");
			rv.setPhoneNumber("15858585858");
			rv.setPositionId(1);
			rv.setSalaryMin(20000.0);
			rv.setSalaryMax(50000.0);
			rv.setRequirementIntroduce("网聚人的力量");
			rrd.insertIntoRequirement(rv);
			System.out.println(rv.getRequirementId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertRequirementKnowledge(){
		ReleaseRequirementDao rrd = ac.getBean(ReleaseRequirementDao.class);
		try {
			RequirementKnowledgeVo rkv = new RequirementKnowledgeVo();
			rkv.setRequirementId(1);
			rkv.setKnowledgeId(5);
			rrd.insertIntoRequirementKnowledge(rkv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertRequirementSkill(){
		ReleaseRequirementDao rrd = ac.getBean(ReleaseRequirementDao.class);
		try {
			RequirementSkillVo rsv = new RequirementSkillVo();
			rsv.setSkillId(3);
			rsv.setRequirementId(2);
			rrd.insertIntoRequirementSkill(rsv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertSkill(){
		ReleaseRequirementDao rrd = ac.getBean(ReleaseRequirementDao.class);
		try {
			CustomSkill cs = new CustomSkill();
			cs.setRequirementId(444);
			cs.setSkillName("IOSAPP");
			rrd.insertIntoSkill(cs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertKnowledge(){
		ReleaseRequirementDao rrd = ac.getBean(ReleaseRequirementDao.class);
		try {
			CustomKnowledge ck = new CustomKnowledge();
			ck.setRequirementId(444);
			ck.setKnowledgeName("IOS");
			rrd.insertIntoKnowledge(ck);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testShowKnowledge(){
		ReleaseRequirementDao rrd = ac.getBean(ReleaseRequirementDao.class);
		try {
			int id = rrd.getKnowledgeIdByKnowledgeName("c#");
			System.out.println(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testShowSkill(){
		ReleaseRequirementDao rrd = ac.getBean(ReleaseRequirementDao.class);
		try {
			int id = rrd.getSkillIdBySkillName("PHP");
			System.out.println(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetPositionIdByPositionName(){
		ReleaseRequirementDao rrd = ac.getBean(ReleaseRequirementDao.class);
		try {
			int id = rrd.getPositionIdByPositionName("java开发工程师");
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
