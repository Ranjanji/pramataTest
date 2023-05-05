package com.social_media_platform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social_media_platform.dao.PostDao;
import com.social_media_platform.entites.Post;
import com.social_media_platform.exception.PostException;

@Service
public class PostServiceImp implements PostService{

	@Autowired
	private PostDao pdao;
	
	@Override
	public Post createPost(Post post) throws PostException {
		Optional<Post> op=pdao.findById(post.getPostId());
		if(op.isPresent()) throw new PostException("User's Post Already Exist!!!");
		Post p=pdao.save(post);
		if(p==null) throw new PostException("Provide valid Credentials!!!");
		return p;
	}

	@Override
	public Post deletePost(Integer postId) throws PostException {
		Optional<Post> op=pdao.findById(postId);
		if(!op.isPresent()) throw new PostException("User's Post Doesn't Exist!!!");
		Post p=op.get();
		pdao.delete(p);
		return p;
	}

}
