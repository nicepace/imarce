package com.imarce.webadmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.webadmin.entity.User;
import com.imarce.webadmin.service.RegisterService;
import com.imarce.webadmin.util.Result;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/register_user")
	@ResponseBody
	public Result registerUser(User user){
		Result result = new Result();
		if(!registerService.registerUser(user)){
			result.setInfo("10002","注册失败!");
		}else{
			result.setInfo("10001","注册成功!");
		}
		
		return result;
	}
}
