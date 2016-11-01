package com.imarce.wechat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.core.controller.BaseController;
import com.imarce.core.service.Result;
import com.imarce.wechat.entity.Position;
import com.imarce.wechat.entity.Skill;
import com.imarce.wechat.service.impl.ReleaseRequirementService;
import com.imarce.wechat.vo.RequirementVo;
import com.imarce.wechat.vo.SkillmoduleVo;

/**
* @version
* @author xsc 
* @time 2016年6月16日下午10:04:04
* 发布需求的控制器类
*/
@Controller
@RequestMapping(value = "/release_requirement")
public class ReleaseRequirementController extends BaseController{


	/**
	 * 发布需求的业务逻辑层对象
	 */
	@Autowired
	private ReleaseRequirementService releaseRequirementService;	

	/**
	 * 跳转到发布需求页面
	 * @return
	 */
	@RequestMapping("/to")
	public String toRelease_requirement(){
		return "release_requirement";
	}
	
	@RequestMapping("/save_requirement")
	@ResponseBody
	public Result saveRequirement(HttpSession httpSession){
		RequirementVo requirementVo = new RequirementVo();
		requirementVo.setCompanyName((String)httpSession.getAttribute("companyName"));
		requirementVo.setContacts((String)httpSession.getAttribute("contacts"));
		requirementVo.setPhoneNumber((String)httpSession.getAttribute("phoneNumber"));
		requirementVo.setRequirementIntroduce((String)httpSession.getAttribute("introduce"));
		int minsal = (int)httpSession.getAttribute("minsal");
		int maxsal = (int)httpSession.getAttribute("maxsal");
		requirementVo.setSalaryMin((double)minsal);
		requirementVo.setSalaryMax((double)maxsal);

		String positionName = (String)httpSession.getAttribute("positionName");
		List<String> knowledgeNameList = (List<String>)httpSession.getAttribute("knowledgeList");
		List<String> skillNameList = (List<String>)httpSession.getAttribute("skillList");
		List<String> customKnowledgeNameList = (List<String>)httpSession.getAttribute("customKnowledgeNameList");
		List<String> customSkillNameList = (List<String>)httpSession.getAttribute("customSkillNameList");
		Result result = releaseRequirementService.insertInto(requirementVo, positionName, knowledgeNameList, skillNameList, customKnowledgeNameList, customSkillNameList);
		if(result.getCode()==1){
			httpSession.removeAttribute("companyName");
			httpSession.removeAttribute("contacts");
			httpSession.removeAttribute("phoneNumber");
			httpSession.removeAttribute("introduce");
			httpSession.removeAttribute("minsal");
			httpSession.removeAttribute("maxsal");
			httpSession.removeAttribute("positionName");
			httpSession.removeAttribute("knowledgeList");
			httpSession.removeAttribute("skillList");
			httpSession.removeAttribute("customKnowledgeNameList");
			httpSession.removeAttribute("customSkillNameList");
		}
		return result;
	}
	
	/**
	 * 显示岗位页面方法
	 * @param model
	 * @return jsp页面的名称
	 * @throws Exception
	 */
	@RequestMapping("/show_position")
	public String showPosition(Model model){
		Result result = releaseRequirementService.showPosition();
		List<Position> positionList = (List<Position>)result.getObjResult();
		model.addAttribute("positionList",positionList);
		return "position";
	}
	
	/**
	 * 显示技能模块和其知识的页面方法
	 * @param model
	 * @return jsp页面的名称
	 * @throws Exception
	 */
	@RequestMapping("/show_skillmodule")
	public String showSkillmodule(Model model,String positionName,String delete,HttpSession httpSession){
		if(delete!=null){
			if(delete.equals("yes")){
				httpSession.removeAttribute("positionName");
				httpSession.removeAttribute("knowledgeList");
				httpSession.removeAttribute("customKnowledgeNameList");
			}
		}
		Result result = releaseRequirementService.showSkillmodule(positionName);
		List<SkillmoduleVo> skillmoduleList = (List<SkillmoduleVo>)result.getObjResult();
		model.addAttribute("skillmoduleList",skillmoduleList);
		model.addAttribute("positionName",positionName);
		return "skillmodule_knowledge";
	}
	
	/**
	 * 显示技能页面方法
	 * @param model
	 * @return jsp页面的名称
	 * @throws Exception
	 */
	@RequestMapping("/show_skill")
	public String showSkill(Model model){
		Result result = releaseRequirementService.showSkill();
		List<Skill> skillList = (List<Skill>)result.getObjResult();
		model.addAttribute("skillList",skillList);
		return "fragment/skill_list";
	}
	
	/**
	 * 获取到用户输入的公司名称存入session中
	 * @param companyName
	 * @param httpSession
	 */
	@RequestMapping("/add_company_name")
	public void addCompanyName(String companyName,HttpSession httpSession){
		String rexCompanyName = "^([\u4e00-\u9fa5]+|[a-zA-Z0-9]+)$";
		if(Pattern.compile(rexCompanyName).matcher(companyName).matches()){
			httpSession.setAttribute("companyName",companyName);
		}
		
	}
	
	/**
	 * 获取到用户输入的联系人存入session中
	 * @param contacts
	 * @param httpSession
	 */
	@RequestMapping("/add_contacts")
	public void addContacts(String contacts,HttpSession httpSession){
		String rexContacts = "^([\u4e00-\u9fa5]{2,4}|[a-zA-Z\\.\\s]{2,20})$";
		if(Pattern.compile(rexContacts).matcher(contacts).matches()){
			httpSession.setAttribute("contacts",contacts);
		}
	}
	
	/**
	 * 获取到用户输入的联系电话存入session中
	 * @param phoneNumber
	 * @param httpSession
	 */
	@RequestMapping("/add_phone_number")
	public void addPhoneNumber(String phoneNumber,HttpSession httpSession){
		String rexPhoneNumber = "(^(\\d{2,4}[-_－—])?\\d{7,8}$)|(^0?1[358]\\d{9}$)";
		if(Pattern.compile(rexPhoneNumber).matcher(phoneNumber).matches()){
			httpSession.setAttribute("phoneNumber",phoneNumber);
		}
	}
	
	/**
	 * 将选择的技能标签存入集合对象再将集合存入session中
	 * @param model
	 * @return jsp页面的名称
	 * @throws Exception
	 */
	@RequestMapping("/add_skill")
	@ResponseBody
	public String addSkill(String str,HttpSession httpSession){
		String[] strList= str.split(",");
		List<String> skillList = new ArrayList<String>();
		for (int i = 0; i < strList.length; i++) {
			skillList.add(strList[i]);
		}
		httpSession.setAttribute("skillList",skillList);
		return "success";
	}
	
	/**
	 * 将选择的知识标签存入集合对象再将集合存入session中
	 * 将选择的岗位存入session中
	 * @param model
	 * @return jsp页面的名称
	 * @throws Exception
	 */
	@RequestMapping("/add_knowledge")
	@ResponseBody
	public String addKnowledge(String str,String positionName,HttpSession httpSession){
		String[] strList= str.split(",");
		List<String> knowledgeList = new ArrayList<String>();
		for (int i = 0; i < strList.length; i++) {
			knowledgeList.add(strList[i]);
		}
		httpSession.setAttribute("positionName",positionName);
		httpSession.setAttribute("knowledgeList",knowledgeList);
		return "success";
	}
	
	/**
	 * 将用户输入的最低薪资和最高薪资存入session中
	 * @param minsal
	 * @param maxsal
	 */
	@RequestMapping("/add_sal")
	@ResponseBody
	public String addSal(Integer minsal,Integer maxsal,HttpSession httpSession){
		String rexSal = "^[0-9]+(\\.[0-9]{1})?$";
		if(Pattern.compile(rexSal).matcher(minsal.toString()).matches()){
			httpSession.setAttribute("minsal",minsal);
		}
		if(Pattern.compile(rexSal).matcher(maxsal.toString()).matches()){
			httpSession.setAttribute("maxsal",maxsal);
		}
		return minsal+"--"+maxsal;
	}
	
	/**
	 * 将用户输入的职位描述存入session中
	 * @param introduce
	 */
	@RequestMapping("/add_introduce")
	@ResponseBody
	public String addSal(String introduce,HttpSession httpSession){
		if(introduce.length()<250&&introduce.length()>0){
			httpSession.setAttribute("introduce",introduce);
		}
		return introduce;
	}
	
	/**
	 * 将用户输入的自定义技能名称存入自定义技能集合中并将集合存入session
	 * @param customskillname
	 */
	@RequestMapping("/add_customskill")
	@ResponseBody
	public String addCustomSkill(String customskillname,HttpSession httpSession){
		if(customskillname.length()<7&&customskillname.length()>0){
			List<String> customSkillNameList = new ArrayList<String>();
			if(httpSession.getAttribute("customSkillNameList")==null){
				customSkillNameList.add(customskillname);
				httpSession.setAttribute("customSkillNameList",customSkillNameList);
			}else{
				List<String> customSkillNameListOld = (List<String>)httpSession.getAttribute("customSkillNameList");
				for (String string : customSkillNameListOld) {
					customSkillNameList.add(string);
				}
				customSkillNameList.add(customskillname);
				httpSession.setAttribute("customSkillNameList",customSkillNameList);
			}
			List<String> customSkillNameListNew = (List<String>)httpSession.getAttribute("customSkillNameList");
			return customskillname;
		}
		return "false";
	}
	
	/**
	 * 将用户输入的自定义知识名称存入自定义知识集合中并将集合存入session
	 * @param customknowledgename
	 */
	@RequestMapping("/add_customknowledge")
	@ResponseBody
	public String addCustomKnowledge(String customknowledgename,HttpSession httpSession){
		if(customknowledgename.length()<7&&customknowledgename.length()>0){
			List<String> customKnowledgeNameList = new ArrayList<String>();
			if(httpSession.getAttribute("customKnowledgeNameList")==null){
				customKnowledgeNameList.add(customknowledgename);
				httpSession.setAttribute("customKnowledgeNameList",customKnowledgeNameList);
			}else{
				List<String> customKnowledgeNameListOld = (List<String>)httpSession.getAttribute("customKnowledgeNameList");
				for (String string : customKnowledgeNameListOld) {
					customKnowledgeNameList.add(string);
				}
				customKnowledgeNameList.add(customknowledgename);
				httpSession.setAttribute("customKnowledgeNameList",customKnowledgeNameList);
			}
			List<String> customKnowledgeNameListNew = (List<String>)httpSession.getAttribute("customKnowledgeNameList");
			return customknowledgename;
		}
		return "false";
	}
}
