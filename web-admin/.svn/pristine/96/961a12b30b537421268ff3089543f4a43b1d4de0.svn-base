package com.imarce.webadmin.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.RegisterDao;
import com.imarce.webadmin.entity.User;
import com.imarce.webadmin.util.Md5;

@Service
public class RegisterService {

	Log log=LogFactory.getLog(RegisterDao.class);
	
	@Autowired
	private RegisterDao registerDao;
	
	public boolean registerUser(User user){
		
		
		try {
			if(registerDao.registerUserCompare(user)>0){
				return false;
			}else{
				Md5 md5=new Md5();
				user.setUserPwd(md5.md5s(user.getUserPwd()));
				registerDao.registerUser(user);
				return true;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return false;
	}
}
