package com.imarce.webadmin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.entity.PositionSkillModule;
import com.imarce.webadmin.service.impl.PositionSkillModuleServiceImpl;
import com.imarce.webadmin.util.Result;

/**
 * 
 * 2016年7月8日 上午8:32:57
 * @author shadow
 * 说明：岗位和技能关系表
 *
 */
@Controller
@RequestMapping
public class PositionSkillModuleController {
	//PositionSkillModule的业务逻辑层实现类对象
	@Autowired
	PositionSkillModuleServiceImpl positionSkillModuleServiceImpl;
	
	/**
	 * 根据岗位id查询岗位技能
	 * @param positionId
	 * @return List
	 */
	@RequestMapping("/query_skill_by_position")
	@ResponseBody
	public List querySkillByPosition(int positionId){
		return positionSkillModuleServiceImpl.querySkillByPosition(positionId);
	}
	
	/**
	 * 查询技能和掌握的知识列表
	 * @param pid
	 * @param stuId
	 * @return
	 */
	@RequestMapping("/query_skillmodule_and_knowledge")
	@ResponseBody
	public List querySkillModuleAndKnowledge(int pid,int stuId){
		return positionSkillModuleServiceImpl.querySkillModuleAndKnowledge(pid, stuId);
	}
	
	
	/**
	 * 查询技能模块列表
	 * @param pid
	 * @return List
	 */
	@RequestMapping("/query_skillmodule_list")
	@ResponseBody
	public List querySkillModuleList(int pid){
		return positionSkillModuleServiceImpl.querySkillModuleList(pid);
	}
	
}
