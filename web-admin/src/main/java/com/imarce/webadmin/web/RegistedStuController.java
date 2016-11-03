/**
 * 2016年7月6日
 */
package com.imarce.webadmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.service.RegistedStuService;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;
import com.imarce.webadmin.util.Result;

/**
 * Author: 		      Qian
 * 
 * Date: 	          2016年7月6日
 * 
 * Description:		
 */
@Controller
public class RegistedStuController {
	/**
	 * 
	 */
	@Autowired
	RegistedStuService  registedStuService;
	
	/**
	 * @return  返回DataGridData类型，类似json数据的格式
	 */
	@RequestMapping("/registed_stu")
	@ResponseBody
	public DataGridData queryRegistedStu(Pager page){
		DataGridData   dataGridData   = registedStuService.queryRegistedStu(page);
	
		return dataGridData;
	}
	
	@RequestMapping("/delete_registed_stu")
	@ResponseBody
	public Result deleteStu(int studentId) {	
		Result result = new Result();		
		if (!registedStuService.delRegistedStu(studentId)) {
			result.setInfo("10002", "信息删除失败!");
		}
		return result;
	}
}
