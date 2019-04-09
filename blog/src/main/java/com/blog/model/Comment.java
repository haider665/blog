package com.blog.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Comment {
	
	
	private int commentId;
	
	private String comment;
	
	private String commentMaker;
	
	private String commentMakerId;
	
	private int Rating;
	
	@ManyToOne(fetch= FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}  )
	@JoinColumn(name="postId")
	private Post post;
	
	public Comment() {
		
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentMaker() {
		return commentMaker;
	}

	public void setCommentMaker(String commentMaker) {
		this.commentMaker = commentMaker;
	}

	public String getCommentMakerId() {
		return commentMakerId;
	}

	public void setCommentMakerId(String commentMakerId) {
		this.commentMakerId = commentMakerId;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", commentMaker=" + commentMaker
				+ ", commentMakerId=" + commentMakerId + ", Rating=" + Rating + ", post=" + post + "]";
	}
	
	
	
	

}
