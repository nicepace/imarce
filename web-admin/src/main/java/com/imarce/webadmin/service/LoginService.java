package com.imarce.webadmin.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.LoginDao;
import com.imarce.webadmin.util.Md5;
import com.imarce.webadmin.entity.User;

@Service
public class LoginService {

	Log log=LogFactory.getLog(LoginService.class);
	@Autowired
	private LoginDao loginDao;
	
	public boolean queryUser(User user,HttpServletRequest request){
		try {
			Md5 md5=new Md5();
			user.setUserPwd(md5.md5s(user.getUserPwd()));
			User currentUser = loginDao.queryUserForLogin(user);
			if (currentUser!=null){
				request.getSession().setAttribute("user", user);
				return true;
			}else{
				request.getSession().setAttribute("user", null);
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return false;
	}

}