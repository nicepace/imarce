/**
 * 
 */
package com.imarce.webadmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.service.EmployTendService;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;
import com.imarce.webadmin.util.Result;

@Controller
@RequestMapping
public class EmployTendController {

	@Autowired
	EmployTendService employTendService;
	
	@RequestMapping("/employTend")
	@ResponseBody
	public DataGridData queryEmployTend(Pager page){
		DataGridData   dataGridData   = employTendService.queryEmployTend(page);
	
		return dataGridData;
	}
	 
	
	@RequestMapping("/delete_employTend")
	@ResponseBody
	public Result deleteEmployTend(int employTendId) {	
		Result result = new Result();		
		if (!employTendService.deleteEmployTend(employTendId)) {
			result.setInfo("10002", "信息删除失败!");
		}
		return result;
	}
}
