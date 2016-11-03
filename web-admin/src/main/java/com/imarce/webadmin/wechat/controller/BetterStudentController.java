package com.imarce.webadmin.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.core.web.BaseController;
import com.imarce.core.service.Page;
import com.imarce.core.service.Result;
import com.imarce.core.utils.Validation;
import com.imarce.webadmin.dao.ReleaseRequirementDao;
import com.imarce.wechat.entity.EmployTend;
import com.imarce.wechat.entity.Level;
import com.imarce.wechat.entity.Position;
import com.imarce.wechat.entity.Student;
import com.imarce.webadmin.service.impl.BetterStudentService;
import com.imarce.wechat.vo.StudentInfo;

@Controller
@RequestMapping(value = "/better_student")
public class BetterStudentController extends BaseController{

	@Autowired
	private BetterStudentService  betterStudentService;
	/**
	 * 返回未入职学员的总记录数
	 * @ return String
	 * @ param
	 */
	@RequestMapping("/getStudentTotal")
	@ResponseBody
	public Result getStudentTotal(Model model,Student student){
		Result result = betterStudentService.getStudentTotal(student);
		if(result.getCode()==1){
			model.addAttribute("total", result.getObjResult());
			return result;
		}else {
			model.addAttribute("result",result.getMsg());
			return result;
		}
	}
	/**
	 * 得到所有的优秀学员
	 * @ param 学生个人信息StudentInfo对象
	 * @ return 学生对象Student
	 */
	@RequestMapping("/go_students")
	public String goStudents(Model model,Student student,String currentPage){
		/**
		 * 1.是查询未入职的优秀学员 
		 * 2.根据岗位查询未入职的优秀学员 
		 * 3.根据i码士等级查询优秀学员 
		 * 4.根据i码士和岗位查询学员的详细信息
		 */
		Result result;
		Page page = new Page();
		page.setCurrentPage(Integer.valueOf(currentPage));
		
		result = betterStudentService.getStudents(student, page);
		if(result.getCode()==1){
			@SuppressWarnings("unchecked")
			List<Student> stu = (List<Student>) result.getObjResult();
			model.addAttribute("betterStu",stu);
			return "fragment/betterstudent";
		}else {
			model.addAttribute("result",result.getMsg());
			return "error";
		}
	}
	@RequestMapping("/go_studentInfo")
	public String gostudentInfo(Model model,Student student){
		Result result;
		result = betterStudentService.getStudentInfo(student);
		if(result.getCode()==1){
			StudentInfo stu = (StudentInfo) result.getObjResult();
			model.addAttribute("betterStu",stu);
			return "resume";
		}else {
			model.addAttribute("result",result.getMsg());
			return "error";
		}
	}
	
	/**
	 * 查询所有的i码士等级集合
	 * @ return 码士等级集合
	 */
	@ResponseBody
	@RequestMapping("/get_levels")
	public Result getLevels(Page page){
		page.setPageStart();
		Result result = betterStudentService.getLevels(page);
		return result;
	}
	@RequestMapping("/go_levels")
	public String goLevels(Model model){
		Page page = new Page(10);
		Result result = betterStudentService.getLevels(page);
		if(result.getCode()==1){
			@SuppressWarnings("unchecked")
			List<Level> levels = (List<Level>) result.getObjResult();
			model.addAttribute("levels", levels);
			return "fragment/levellist";
		}else
		
		return "error";
	}
	
	/**
	 * @ return String
	 * @ param
	 */
	@RequestMapping("/go_positions")
	public String goPositions(Model model){
		Page page = new Page();
		page.setPageStart();
		Result result = getPositions(page);
		if(result.getCode()==1){
			@SuppressWarnings("unchecked")
			List<Position> positions = (List<Position>) result.getObjResult();
			model.addAttribute("positions", positions);
			return "fragment/positionlist";
		}else
		
		return "error";
	}
	@ResponseBody
	@RequestMapping("/get_positions")
	public Result getPositions(Page page){
		Result result;
		result = betterStudentService.getPositions();
		return result; 
	}
	
	/**
	 * 招募勇士，像EmployTend添加信息
	 *  @ param 录取意向对象
	 * @ return 是否添加成功
	 */
	@RequestMapping("/insert_employ_tend")
	@ResponseBody
	public Result insertEmployTend(String RegName,String RegQQ,String RegPhone,String RegCompany,String studentId){
		EmployTend employTend = new EmployTend(RegCompany,RegName,RegQQ,RegPhone);
		employTend.setStudentId(Integer.valueOf(studentId));
		Result result = new Result();
		if(Validation.isPhone(RegPhone)&&Validation.isSpecialChar(RegName)&&Validation.isQQ(RegQQ)){
			result = betterStudentService.insertEmployTend(employTend);
			result.setMsg("验证通过！");
		}else if(!Validation.isPhone(RegPhone)){
			result.setMsg("电话号码不正确或座机不对！");
		}else if(!Validation.isSpecialChar(RegName)){
			result.setMsg("姓名包含了特殊字符");
		}else if(!Validation.isQQ(RegQQ)){
			result.setMsg("提示：qq号码是5-10位数字！");
		};
		
		return result;
	}
	
}