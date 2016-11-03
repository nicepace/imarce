package com.imarce.webadmin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.entity.User;
import com.imarce.webadmin.service.LoginService;
import com.imarce.webadmin.util.Result;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login_user")
	@ResponseBody
	public Result queryUser(User user,HttpServletRequest request){
		
		Result result = new Result();
		if (!loginService.queryUser(user,request)) {
			result.setInfo("10002", "用户登录失败!");
		}
		return result;
	}
	@RequestMapping("/exit_login")
	@ResponseBody
	public Result exitLogin(HttpSession session){
		Result result=new Result();
		if(session.getAttribute("user")==null){
			result.setInfo("10002","用户未登录!");
		}else{
			session.removeAttribute("user");
			result.setInfo("10001","退出成功!");
		}
		return result;
	}
}
