package com.ugurcanlacin.simple.dao;

import java.util.List;

import com.ugurcanlacin.simple.model.User;

public interface UserDao {
	
	public List<User> getListStudent();
	public void addUser(User user);
	public User findUserById(int id);
	public void updateUser(User user);
	public void deleteUser(int id);
}
