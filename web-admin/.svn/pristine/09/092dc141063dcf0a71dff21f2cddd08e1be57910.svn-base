/**
 * 
 */
package com.imarce.webadmin.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.entity.Position;
import com.imarce.webadmin.entity.Student;
import com.imarce.webadmin.entity.vo.ComboTreeVO;
import com.imarce.webadmin.service.PositionService;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;
import com.imarce.webadmin.util.Result;

/**
 * @author JianqMQ
 * 2016年7月6日 下午2:20:51
 */

@Controller
@RequestMapping
public class PositionController {

	@Autowired
	private PositionService positionService;
	
	@RequestMapping("/position")
	@ResponseBody
	public DataGridData queryPosition(Pager page){
		DataGridData   dataGridData   = positionService.queryPosition(page);
		return dataGridData;
	}
	
	@RequestMapping("/position_for_select")
	@ResponseBody
	public List positionForSelect(){
		List ls = positionService.queryPositionForSelect();
		return ls;
	}
	
	@RequestMapping("/view_position")
	public String queryPosition(Model  model ,int pid){
		 Position  position  = positionService.queryPositionById(pid);
		model.addAttribute("position", position);
		return "fragment/position_editor";
	}

	@RequestMapping("/add_position_basic")
	@ResponseBody
	public Result addPositionBasic(Position position){
		
		Result result = new Result();
		if(!positionService.addPositionBasic(position)){
			result.setInfo("10002","用户保存失败!");
		}
		return result;
	}
	@RequestMapping("/edit_position_basic")
	@ResponseBody
	public Result editPosition(Position position){		
			Result result = new Result();
			if(!positionService.editPosition(position)){
				result.setInfo("10002","操作失败!");
			}
			return result;
	}
	
	@RequestMapping("/delete_position_basic")
	@ResponseBody
	public Result deletePosition(int positionId){		
			Result result = new Result();
			if(!positionService.deletePosition(positionId)){
				result.setInfo("10002","操作失败!");
			}
			return result;
	}
	
	

	/**
	 * 查询岗位名称
	 * @author shadow
	 * @return List
	 */
	@RequestMapping("/view_position_name")
	@ResponseBody
	public List queryPositionName(){
		List list = positionService.queryPositionName();
		return list;
	}
	/**
	 * @return the positionService
	 */
	public PositionService getPositionService() {
		return positionService;
	}

	/**
	 * @param positionService the positionService to set
	 */
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

}
