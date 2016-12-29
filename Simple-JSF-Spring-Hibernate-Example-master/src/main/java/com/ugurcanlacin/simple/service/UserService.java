package com.ugurcanlacin.simple.service;

import java.util.List;

import com.ugurcanlacin.simple.model.User;

public interface UserService {
	public List<User> getListUser();
	public void addUser(User user);
	public User findUserById(int id);
	public void updateUser(User user);
	public void deleteUser(int id);
}
