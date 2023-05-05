package com.social_media_platform.service;

import com.social_media_platform.entites.Comment;
import com.social_media_platform.exception.CommentException;

public interface CommentService {
	public Comment createComment(Comment comment) throws CommentException;
	public Comment deleteComment(Integer commentId) throws CommentException;
}
