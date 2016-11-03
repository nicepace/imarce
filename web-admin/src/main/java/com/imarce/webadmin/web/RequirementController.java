package com.imarce.webadmin.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.entity.Requirement;
import com.imarce.webadmin.entity.vo.KnowledgeVO;
import com.imarce.webadmin.entity.vo.SkillVO;
import com.imarce.webadmin.service.RequirementService;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;
import com.imarce.webadmin.util.Result;

/**
  2016年7月5日 下午2:07:03
  @kriss
    说明：用人单位招聘需求
    版本：
*/

@Controller
@RequestMapping
public class RequirementController {

	/**
	 * 
	 */
	@Autowired
	RequirementService  requirementService;
	
	/**
	 * @return
	 */
	@RequestMapping("/requirements")
	@ResponseBody
	public DataGridData queryRequirements(Pager page){
		DataGridData   dataGridData   = requirementService.queryRequirements(page);
	
		return dataGridData;
	}
	 
	@RequestMapping("/query_req_by_id")
        public String queryReqById(Model model,int requirementId){
	    List<KnowledgeVO> knowledge= ( ArrayList< KnowledgeVO > ) requirementService.queryReqKnowledgeById( requirementId ).getData();
	    List<SkillVO> skill= ( ArrayList< SkillVO > ) requirementService.queryReqSkillById( requirementId ).getData();
	    model.addAttribute("knowledge" , knowledge);
	    model.addAttribute("skill" , skill);
            return "fragment/req_info";
        }
	
	@RequestMapping("/delete_requirement")
	@ResponseBody
	public Result deleteRequirement(int requirementId) {	
		Result result = new Result();		
		if (!requirementService.deleteRequirement(requirementId)) {
			result.setInfo("10002", "信息删除失败!");
		}
		return result;
	}
	
}
