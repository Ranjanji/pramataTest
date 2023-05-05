package com.social_media_platform.service;

import java.util.List;

import com.social_media_platform.entites.Post;
import com.social_media_platform.entites.User;
import com.social_media_platform.exception.PostException;
import com.social_media_platform.exception.UserException;
import com.social_media_platform.non_entities.LoginDto;


public interface UserService {
	public User registerUser(User u) throws UserException;
	public User loginUser(LoginDto udto) throws UserException;
	public List<Post> getAllPost(Integer userId) throws UserException,PostException;
	public List<User> findFriends(String name) throws UserException;
	
	
	
}
