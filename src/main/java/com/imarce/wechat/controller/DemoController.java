package com.imarce.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imarce.core.controller.BaseController;
import com.imarce.wechat.entity.Skill;
import com.imarce.wechat.service.impl.DemoService;

@Controller
@RequestMapping(value = "/demo")
public class DemoController extends BaseController{

	@Autowired
	private DemoService  demoService;

	@RequestMapping("/querySkill")
	public String queryUser(Model  model)throws Exception{
		Skill skill=demoService.getSkillById();
		model.addAttribute("skill",skill);
		
		return "querySkill";
	}
}