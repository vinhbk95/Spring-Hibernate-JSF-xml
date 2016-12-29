package com.ugurcanlacin.simple.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.ugurcanlacin.simple.model.User;
import com.ugurcanlacin.simple.service.UserService;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<User> userlist;
	private String name;
	private String surname;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public UserService getUserService() {
		return userService;
	}

	@ManagedProperty(value = "#{userService}")
	UserService userService;

	@PostConstruct
	public void init() {
		this.userlist = userService.getListUser();
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void add() {
		User user = new User();
		user.setName(getName());
		user.setSurname(getSurname());
		userService.addUser(user);
		this.userlist = userService.getListUser();
	}
	
	public void searchid(){
		userlist.clear();
		User user = new User();
		user = userService.findUserById(Integer.parseInt(id));
		userlist.add(user);
	}
	
	public void update(){
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setSurname(surname);
		userService.updateUser(user);
		this.userlist = userService.getListUser();
	}
	
	public void delete(){
		userService.deleteUser(Integer.parseInt(id));
		this.userlist = userService.getListUser();
	}

}
