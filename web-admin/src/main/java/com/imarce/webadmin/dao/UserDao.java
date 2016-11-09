package com.imarce.webadmin.dao;

import java.util.List;

import com.imarce.webadmin.entity.User;
import com.imarce.webadmin.util.Pager;

public interface UserDao {

	public List<User> queryUser(Pager page) throws Exception;
	
	
	public int countUser() throws Exception;


	public int deleteUser(int userid)  throws Exception;


	public int addUser(User user)  throws Exception ;

	public User queryUserById(int userid);


	public int editUser(User user);

}
