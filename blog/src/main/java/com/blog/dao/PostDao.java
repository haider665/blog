package com.blog.dao;

import com.blog.model.Post;
import java.util.List;

public interface PostDao {
	
	public int addPost(Post post);
	
	public Post getPost(int id);
	
	public List<Post> getAllPost();
	
}
