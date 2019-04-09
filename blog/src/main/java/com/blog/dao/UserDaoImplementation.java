package com.blog.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.model.User;

public class UserDaoImplementation implements UserDao{
	
	
    private SessionFactory factory;

	@Override
	public void addUser(User user) {
		openFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
		
		closeFactory();
	}

	@Override
	public User getUser(String email, String password) {
		openFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
        
		User user=session.get(User.class, email);
		
        session.getTransaction().commit();
		
//		closeFactory();
		if (user.getPassword().equals(password)) return user;
		else return null;
		
	}
	@Override
	public User getUser(String email) {
		System.out.println("------------"+email+"---------------");
		openFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
        
		User user=session.get(User.class, email);
		
        session.getTransaction().commit();
		user.getEmail();
		closeFactory();
		return user;
		
	}
	
	public void openFactory() {
		factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
	}
	public void closeFactory() {
		factory.close();
	}

}
