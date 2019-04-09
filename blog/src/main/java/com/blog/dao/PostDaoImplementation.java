package com.blog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.blog.model.Post;

public class PostDaoImplementation implements PostDao {

	private SessionFactory factory;
	
	@Override
	public int addPost(Post post) {
		openFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
        int id=(int)session.save(post);
        session.getTransaction().commit();
		
		closeFactory();
		return id;
	}

	@Override
	public Post getPost(int id) {
		openFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
        Post post=session.get(Post.class, id);
        session.getTransaction().commit();
		
		closeFactory();
		return post;
	}

	@Override
	public List<Post> getAllPost() {
		
		openFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query<Post> allPost = session.createQuery("from Post", Post.class);
		
		List<Post> users= allPost.getResultList();
		session.getTransaction().commit();
		
		closeFactory();
		return users;
	}
	
	public void openFactory() {
		factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Post.class).buildSessionFactory();
	}
	public void closeFactory() {
		factory.close();
	}

}
