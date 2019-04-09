package com.blog.dao;

import com.blog.model.User;

public interface UserDao {
	
	public void addUser(User user) ;
	public User getUser(String email, String password);
	public User getUser(String email);

}
