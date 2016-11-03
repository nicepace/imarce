/**
 * 2016年7月8日
 */
package com.imarce.webadmin.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.entity.ProjectExperience;
import com.imarce.webadmin.service.ProjectExperienceService;
import com.imarce.webadmin.util.Result;

/**
 * Author: Qian
 * 
 * Date: 2016年7月8日
 * 
 * Description:
 */
@Controller
public class ProjectExperienceController {
	@Autowired
	ProjectExperienceService projectExperienceService;

	@RequestMapping("/query_project_experience")
	public String queryWorkExperience(Model model, int studentId) {
		List projectExperiences  = projectExperienceService.queryProjectExperience(studentId);
		model.addAttribute("projectExperiences", projectExperiences);
		
		return "fragment/project_experience";
	}

	@RequestMapping("/query_project_exp_by_id")
	@ResponseBody
	public String queryWorkExpById(Model model, int projectExperienceId) {
		ProjectExperience projectExperience = projectExperienceService.queryProjectExpById(projectExperienceId);
		model.addAttribute("projectExperience", projectExperience);
		return "project_experience";
	}

	@RequestMapping("/save_project_experience")
	@ResponseBody
	public Result saveProjectExperience(ProjectExperience projectExperience) {
		Result result = new Result();
		if (projectExperienceService.saveProjectExperience(projectExperience)) {
			result.setInfo("10001", "项目经历添加成功!",projectExperience);
		}else{
			result.setInfo("10002", "项目经历添加失败!");
		}
		return result;
	}

	@RequestMapping("/update_project_experience")
	@ResponseBody
	public Result updateProjectExperience(ProjectExperience projectExperience) {
		Result result = new Result();
		if (!projectExperienceService.updateProjectExperience(projectExperience)) {
			result.setInfo("10002", "项目经历修改失败!");
		}
		return result;
	}

	@RequestMapping("/delete_project_experience")
	@ResponseBody
	public Result deleteWorkExpById(int projectExperienceId) {
		Result result = new Result();
		if (!projectExperienceService.deleteProjectExpById(projectExperienceId)) {
			result.setInfo("10002", "项目经历删除失败!");
		}
		return result;
	}
	
}
