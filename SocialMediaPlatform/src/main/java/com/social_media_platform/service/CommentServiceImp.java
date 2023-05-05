package com.social_media_platform.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social_media_platform.dao.CommentDao;
import com.social_media_platform.entites.Comment;
import com.social_media_platform.exception.CommentException;

@Service
public class CommentServiceImp implements CommentService{

	@Autowired
	private CommentDao cdao;
	
	//Create Post
	@Override
	public Comment createComment(Comment comment) throws CommentException {
		Optional<Comment> op=cdao.findById(comment.getCommentId());
		if(op.isPresent()) throw new CommentException("User's Comment Already Exist!!!");
		Comment c=cdao.save(comment);
		if(c==null) throw new CommentException("Provide valid Credentials!!!");
		return c;
	}
	//Delete Post
	@Override
	public Comment deleteComment(Integer commentId) throws CommentException {
		Optional<Comment> op=cdao.findById(commentId);
		if(!op.isPresent()) throw new CommentException("User's Comment Doesn't Exist!!!");
		Comment c=op.get();
		cdao.delete(c);
		return c;
	}

}
