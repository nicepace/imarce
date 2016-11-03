package com.imarce.webadmin.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.entity.Level;
import com.imarce.webadmin.service.LevelService;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;
import com.imarce.webadmin.util.Result;

@Controller
public class LevelController {

	@Autowired
	private LevelService levelService;
	
	@RequestMapping("/queryLevel")
	@ResponseBody
	public DataGridData queryLevel(Pager page){
		page.setIsQueryAll(true);
		DataGridData data=levelService.queryLevel(page);
		return data;
	}
	
	@RequestMapping("/level_for_select")
	@ResponseBody
	public List<Level> levelForSelect(){
		List<Level> ls=levelService.levelForSelect();
		return ls;
	}
	
	
	@RequestMapping("/view_level")
	public String queryLevelById(Model  model ,int lid){
		Level   level  = levelService.queryLevelById(lid);
		model.addAttribute("level", level);
		return "fragment/level_editor";
	}
	
	@RequestMapping("/view_level_update")
	@ResponseBody
	public Result updateLevel(Level level){		
			Result result = new Result();
			if(!levelService.updateLevel(level)){
				result.setInfo("10002","操作失败!");
			}
			return result;
	}
	@RequestMapping("/view_level_add")
	@ResponseBody
	public Result insertLevel(Level level){		
		Result result = new Result();
		if(!levelService.insertLevel(level)){
			result.setInfo("10002","操作失败!");
		}
		return result;
	}
	
	@RequestMapping("/view_level_delete")
	@ResponseBody
	public Result deleteLevel(int levelId){		
		Result result = new Result();
		if(!levelService.deleteLevel(levelId)){
			result.setInfo("10002","操作失败!");
		}
		return result;
	}
	
	
	
	
}
