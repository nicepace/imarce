package com.imarce.webadmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.entity.Opinions;
import com.imarce.webadmin.service.impl.OpinionsServiceImpl;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;
import com.imarce.webadmin.util.Result;

/**
 * 
 * 2016年7月5日 下午7:15:57
 * @author shadow
 * 说明：意见反馈表
 *
 */
@Controller
@RequestMapping
public class OpinionsController {
		//opinions业务逻辑层实现类对象
		@Autowired
		OpinionsServiceImpl opinionsServiceImpl;
		
		/**
		 * 查询意见表
		 * @param page
		 * @return DataGridData
		 */
		@RequestMapping("/opinions")
		@ResponseBody
		public DataGridData queryOpinions(Pager page){
			DataGridData dataGridData = opinionsServiceImpl.queryOpinions(page);

			return dataGridData;			
		}
		
		/**
		 * 根据id查询单条opinion
		 * @param opinionId
		 * @return Opinions
		 */
		@RequestMapping("/view_opinion")
		public String queryOpinionById(Model  model,int opinionId){
			Opinions opinion = opinionsServiceImpl.queryOpinionById(opinionId);
			model.addAttribute("opinion",opinion);
			return "fragment/opinion";			
		}
		
		@RequestMapping("/delete_opinion")
		@ResponseBody
		public Result deleteOpinion(int opinionId) {	
			Result result = new Result();		
			if (!opinionsServiceImpl.deleteOpinion(opinionId)) {
				result.setInfo("10002", "信息删除失败!");
			}
			return result;
		}
}
