package com.imarce.webadmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.service.RecommendService;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;
import com.imarce.webadmin.util.Result;

@Controller
public class RecommendController {

	@Autowired
	private RecommendService recommendService;
	
	@RequestMapping("/queryRecommend")
	@ResponseBody
	public DataGridData queryRecommend(Pager page){
		DataGridData dataGridData=recommendService.queryRecommend(page);
		return dataGridData;
	}
	
	@RequestMapping("/delete_recommend")
	@ResponseBody
	public Result deleteRecommend(int recommendId) {	
		Result result = new Result();		
		if (!recommendService.deleteRecommend(recommendId)) {
			result.setInfo("10002", "信息删除失败!");
		}
		return result;
	}
}
