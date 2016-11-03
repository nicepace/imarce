package com.imarce.webadmin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.entity.SkillModule;
import com.imarce.webadmin.service.impl.SkillModuleServiceImpl;
import com.imarce.webadmin.util.Result;

/**
 * 
 * 2016年7月7日 下午10:10:38
 * @author shadow
 * 说明：岗位技能表
 *
 */
@Controller
@RequestMapping
public class SkillModuleController {
	//SkillModule的业务逻辑层实现类对象
	@Autowired
	SkillModuleServiceImpl skillModuleServiceImpl;
	
	/**
	 * 查询岗位技能表
	 * @return List
	 */
	@RequestMapping("/skillmodule")
	@ResponseBody
	public List querySkillModule(){
		return skillModuleServiceImpl.querySkillModule();
	}
	
	/**
	 * 根据id查询岗位技能表
	 * @param model
	 * @param skillModuleId
	 * @return String
	 */
	@RequestMapping("/query_skillmodule_by_id")
	public String queryLevelById(Model model, int skillModuleId){
		SkillModule skillModule = skillModuleServiceImpl.querySkillModuleById(skillModuleId);
		model.addAttribute("skillModule", skillModule);
		return "fragment/skillmodule_editor";
	}
	
	/**
	 * 添加岗位技能
	 * @param skillModule
	 * @return Result
	 */
	@RequestMapping("/add_skillmodule")
	@ResponseBody
	public Result addSkillModule(SkillModule skillModule,int pid){
		Result result = new Result();
		if(skillModuleServiceImpl.addSkillModule(skillModule,pid)){
				result.setInfo("10001", "添加成功！");
		}else{
			result.setInfo("10002", "添加失败!");
		}
		return result;
	}
	
	/**
	 * 修改岗位技能
	 * @param skillModule
	 * @return Result
	 */
	@RequestMapping("/update_skillmodule")
	@ResponseBody
	public Result updateSkillModule(SkillModule skillModule){
		Result result = new Result();
		if(skillModuleServiceImpl.updateSkillModule(skillModule)){
			result.setInfo("10001", "修改成功！");
		}else{
			result.setInfo("10002", "修改失败!");
		}
		return result;
	}
	
	@RequestMapping("/delete_skillmodule")
	@ResponseBody
	public Result updateSkillModule(int skillModuleId){
		Result result = new Result();
		if(skillModuleServiceImpl.deleteSkillModule(skillModuleId)){
			result.setInfo("10001", "修改成功！");
		}else{
			result.setInfo("10002", "修改失败!");
		}
		return result;
	}
}
