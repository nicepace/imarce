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

import com.imarce.webadmin.entity.WorkExperience;
import com.imarce.webadmin.service.WorkExperienceService;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Result;

/**
 * Author: Qian
 * 
 * Date: 2016年7月8日
 * 
 * Description:
 */
@Controller
public class WorkExperienceController {
	@Autowired
	 WorkExperienceService workExperienceService;

	@RequestMapping("/query_work_experience")
	public String queryWorkExperience(Model model,int studentId) {
		List workExperience = workExperienceService .queryWorkExperience(studentId);
		model.addAttribute("workExperience", workExperience);
		return "fragment/work_experience";
	}

	@RequestMapping("/query_work_exp_by_id")
	@ResponseBody
	public String queryWorkExpById(Model model, int workExperienceId) {
		WorkExperience workExperience = workExperienceService.queryWorkExpById(workExperienceId);
		model.addAttribute("editWorkExperience", workExperience);
		return "fragment/work_experience";
	}

	@RequestMapping("/save_work_experience")
	@ResponseBody
	
	public Result saveWorkExperience(WorkExperience workExperience) {
		Result result = new Result();
		if (!workExperienceService.saveWorkExperience(workExperience)) {
			result.setInfo("10002", "工作经历添加失败!");
		}else{
			result.setInfo("10001", "工作经历添加成功",workExperience);
		}
		return result;
	}

	@RequestMapping("/update_work_experience")
	@ResponseBody	
	public Result updateWorkExperience(WorkExperience workExperience) {
		Result result = new Result();
		if (!workExperienceService.updateWorkExperience(workExperience)) {
			result.setInfo("10002", "工作经历修改失败!");
		}
		return result;
	}

	@RequestMapping("/delete_work_experience")
	@ResponseBody
	public Result deleteWorkExpById(int workExperienceId) {
		Result result = new Result();
		if (!workExperienceService.deleteWorkExpById(workExperienceId)) {
			result.setInfo("10002", "工作经历删除失败!");
		}
		return result;
	}
	
}
