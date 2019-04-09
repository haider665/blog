package com.blog.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Scope;
import org.springframework.web.multipart.MultipartFile;

@Transactional
@Entity
@Table(name = "post")
@Scope("prototype")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="postId")
	private int postId;
	@NotNull(message="is Required")
	@Column(name="postTitle")
	private String title;
	@NotNull(message="is Required")
	@Column(name="postCategory")
	private String category;
	@NotNull(message="is Required")
	@Column(name="post")
	private String post;
	@Column(name="author")
	private String author;
	
	@Column(name="date")
	private String date;
	
	@Fetch(FetchMode.SELECT)
	@ManyToOne(fetch= FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}  )
	@JoinColumn(name="userId")
	private User user;
	
//	@Fetch(FetchMode.SELECT)
//	@OneToMany (mappedBy="post" ,fetch = FetchType.EAGER, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//	private List<Comment> comments;
	
	@Transient
    @NotNull(message="is Required")
    private MultipartFile postImage;

	
	public Post() {
		
	}

	public Post(String title, String category, String post) {
		super();
		this.title = title;
		this.category = category;
		this.post = post;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public MultipartFile getPostImage() {
		return postImage;
	}

	public void setPostImage(MultipartFile postImage) {
		this.postImage = postImage;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + ", category=" + category + ", post=" + post + "]";
	}
	

}
