package com.social_media_platform.service;

import com.social_media_platform.entites.Post;
import com.social_media_platform.exception.PostException;

public interface PostService {
	public Post createPost(Post post) throws PostException;
	public Post deletePost(Integer postId) throws PostException;
	
}
