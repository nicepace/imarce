package com.imarce.webadmin.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
	@Autowired  
	private  HttpServletRequest request;  

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
	@RequestMapping("/test")
	public void jsonpTest(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("進入test");
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();   
//	    HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	    //根据html指定的jsonp回调函数的参数名，获取回调函数的名称
	    //callbackName的值其实就是：success_jsonpCallback
	    String callbackName = (String)request.getAttribute("jsoncallback");
	    //简单模拟一个json字符串，实际可使用google的gson进行转换，次数通过字符串拼接
	    //{"name":"张三","age":28}
	    //\是对"号进行转义
	    String jsonStr = "{\"name\":\"张三\",\"age\":28}";
	    //最终返回的数据为：success_jsonpCallback({"name":"张三","age":28})
	    String renderStr = callbackName+"("+jsonStr+")";
	    response.setContentType("text/plain;charset=UTF-8");
	    response.getWriter().write(renderStr);

}
}
