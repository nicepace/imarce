package com.imarce.webadmin.dao;



import com.imarce.webadmin.entity.User;

public interface LoginDao {
	
	public User queryUserForLogin(User user) throws Exception;
	
}
