package com.imarce.webadmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.entity.Position;
import com.imarce.webadmin.entity.User;
import com.imarce.webadmin.service.UserService;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;
import com.imarce.webadmin.util.Result;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/queryUser")
	@ResponseBody
	public DataGridData queryUser(Pager page){
		DataGridData dataGridData=userService.queryUser(page);
		
		return dataGridData;
	}
	@RequestMapping("/delete_user")
	@ResponseBody
	public Result deleteuser(int userid) {	
		Result result = new Result();		
		if (!userService.deleteuser(userid)) {
			result.setInfo("10002", "用户删除失败!");
		}
		return result;
	}
	@RequestMapping("/add_user")
	@ResponseBody
	public Result addUser(User user){
		System.out.println("\n\n\n\n\n\n\n"+user.toString());
		Result result = new Result();
		if(!userService.addUser(user)){
			result.setInfo("10002","用户添加失败!");
		}
		return result;
	}
	@RequestMapping("/ShowUserById")
	public String  ShowUserById(Model model ,int userid){
		 User user= userService.ShowUserById(userid);
		model.addAttribute("user", user);
		return "fragment/user_editor";
	}
	@RequestMapping("/editUser")
	@ResponseBody
	public Result editPosition(User user){		
			Result result = new Result();
			if(!userService.editUser(user)){
				result.setInfo("10002","操作失败!");
			}
			return result;
	}
	
}
