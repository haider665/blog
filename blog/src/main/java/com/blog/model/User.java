package com.blog.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Scope;

@Transactional
@Entity
@Table(name = "user")
@Scope("prototype")
public class User {
			
	@Id
	@Column(name = "email")
	private String email;
	@Column(name="userName")
	private String userName;
	@Column(name="password")
	private String password;
	
	@OneToMany (mappedBy="user" ,fetch = FetchType.EAGER, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Post> post;
	
	public User() {
		
	}
	

	public User(String email, String userName, String password) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void add(Post tempPost) {
		System.out.println("1-------------------1");
		if(post==null) {
			post = new ArrayList();
		}
//		System.out.println("use---add---post arraylist  "+post);
		post.add(tempPost);
		tempPost.setUser(this);
	}


	public List<Post> getPost() {
		return post;
	}


	public void setPost(List<Post> post) {
		this.post = post;
	}


	@Override
	public String toString() {
		return "User [email=" + email + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
