package com.imarce.webadmin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.entity.Knowledge;
import com.imarce.webadmin.service.impl.KnowledgeServiceImpl;
import com.imarce.webadmin.util.Result;


/**
 * 
 * 2016年7月8日 上午8:01:05
 * @author shadow
 * 说明：技能知识表
 *
 */
@Controller
@RequestMapping
public class KnowledgeController {
	//Knowledge的业务逻辑层实现类对象
	@Autowired
	KnowledgeServiceImpl knowledgeServiceImpl;
	
	/**
	 * 根据技能id查询技能知识
	 * @param skillModuleId
	 * @return List
	 */
	@RequestMapping("/query_knowledge_by_skillmodule")
	@ResponseBody
	public List queryKnowledgeBySkillModule(int skillModuleId){
		return knowledgeServiceImpl.queryKnowledgeBySkillModule(skillModuleId);
	}
	
	/**
	 * 根据id查询技能知识
	 * @param skillModuleId
	 * @return String
	 */
	@RequestMapping("/query_knowledge_by_id")
	public String queryKnowledgeById(Model model, int knowledgeId){
		Knowledge knowledge = knowledgeServiceImpl.queryKnowledgeById(knowledgeId);
		model.addAttribute("knowledge", knowledge);
		return "fragment/knowledge_editor";
	}
	
	/**
	 * 添加技能知识
	 * @param knowledge
	 * @return Result
	 */
	@RequestMapping("/add_knowledge")
	@ResponseBody
	public Result addKnowledge(Knowledge knowledge){
		Result result = new Result();
		if(knowledgeServiceImpl.addKnowledge(knowledge)){
			result.setInfo("10001", "添加成功！");
		}else{
			result.setInfo("10002", "添加失败!");
		}
		return result;
	}
	
	/**
	 * 修改技能知识
	 * @param knowledge
	 * @return Result
	 */
	@RequestMapping("/update_knowledge")
	@ResponseBody
	public Result updateKnowledge(Knowledge knowledge){
		Result result = new Result();
		if(knowledgeServiceImpl.updateKnowledge(knowledge)){
			result.setInfo("10001", "修改成功！");
		}else{
			result.setInfo("10002", "修改失败!");
		}
		return result;
	}
	
	@RequestMapping("/delete_knowledge")
	@ResponseBody
	public Result deleteKnowledge(int knowledgeId){
		Result result = new Result();
		if(knowledgeServiceImpl.deleteKnowledge(knowledgeId)){
			result.setInfo("10001", "修改成功！");
		}else{
			result.setInfo("10002", "修改失败!");
		}
		return result;
	}
	
	
	/**
	 * 查询知识列表
	 * @param skillModuleId
	 * @return List
	 */
	@RequestMapping("/query_knowledge_list")
	@ResponseBody
	public List queryKnowledgeList(int sid){
		return knowledgeServiceImpl.queryKnowledgeList(sid);
	}
	
}
