package com.imarce.webadmin.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarce.webadmin.dao.UserDao;
import com.imarce.webadmin.entity.User;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.Pager;

@Service
public class UserService {

	Log  log  = LogFactory.getLog(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	public DataGridData queryUser(Pager page){
		DataGridData result=new DataGridData();
		try {
			List<User> ls=userDao.queryUser(page);
			System.out.println(ls.toString());
			result.setRows(ls);
			int count=userDao.countUser();
			result.setTotal(count);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result;
	}

	public boolean deleteuser(int userid) {
		int result = 0;
		try {
			result = userDao.deleteUser(userid);			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ? true : false;
	}

	public boolean addUser(User user) {
		int result = 0 ;
		try {	
			result = userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result > 0 ?true:false;
	}
	
	
}
