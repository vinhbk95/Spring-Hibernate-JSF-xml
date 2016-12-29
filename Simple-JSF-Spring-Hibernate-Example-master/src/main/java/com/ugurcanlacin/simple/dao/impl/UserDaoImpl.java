package com.ugurcanlacin.simple.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ugurcanlacin.simple.dao.UserDao;
import com.ugurcanlacin.simple.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	public User findUserById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		
	}

	public void deleteUser(int id) {
		User user = new User();
		user = this.findUserById(id);
		sessionFactory.getCurrentSession().delete(user);
		
	}

	@SuppressWarnings("unchecked")
	public List<User> getListStudent() {
		List<User> list = new ArrayList<User>();
		list = sessionFactory.getCurrentSession().createQuery("from User").list();
		return list;
	}

}
