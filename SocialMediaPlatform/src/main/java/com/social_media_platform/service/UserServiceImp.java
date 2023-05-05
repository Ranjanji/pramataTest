package com.social_media_platform.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social_media_platform.dao.CommentDao;
import com.social_media_platform.dao.CurrentSessionDao;
import com.social_media_platform.dao.FollowDao;
import com.social_media_platform.dao.PostDao;
import com.social_media_platform.dao.UserDao;
import com.social_media_platform.entites.CurrentSession;
import com.social_media_platform.entites.Post;
import com.social_media_platform.entites.User;
import com.social_media_platform.exception.PostException;
import com.social_media_platform.exception.UserException;
import com.social_media_platform.non_entities.LoginDto;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao udao;
	
	@Autowired
	private PostDao pdao;
	
	@Autowired
	private CommentDao cdao;
	
	@Autowired
	private FollowDao fdao;
	
	@Autowired
	private CurrentSessionDao csdao;
	
	@Override
	public User registerUser(User u) throws UserException {
		Optional<User> op=udao.findById(u.getUserId());
		if(op.isPresent()) throw new UserException("User Already Exist!!!");
		User user=udao.save(u);
		if(user==null) throw new UserException("Provide valid Credentials!!!");
		return u;
	}

	@Override
	public User loginUser(LoginDto udto) throws UserException {
		User u=udao.findByUsername(udto.getUsername());
		if(u==null) throw new UserException("UserName Doesn't exist!!!");
		Optional<CurrentSession> userSession =   csdao.findById(u.getUserId());
		
		if(userSession.isPresent()) {
			throw new UserException("User already Logged In with this userId");	
		}
		
		  if(u.getPassword().equals(udto.getPassword())) {
				String key=RandomString.make(6);
				CurrentSession csUser = new CurrentSession(u.getUserId(),key,LocalDateTime.now());
				csdao.save(csUser);
			}
			else throw new UserException("Please Enter a valid password");
			return u;
	}

	@Override
	public List<Post> getAllPost(Integer userId) throws UserException, PostException {
		Optional<User> op=udao.findById(userId);
		if(!op.isPresent()) throw new UserException("User Doesn't Exist!!!");
		List<Post> list=op.get().getPosts();
		if(list.isEmpty()) throw new PostException("No Post Exists in user profile!!!"); 
		return list;
	}

	@Override
	public List<User> findFriends(String name) throws UserException {
		List<User> usersList=udao.findAll();
		if(usersList.isEmpty()) throw new UserException("Users Doesn't Exist in the Platform!!!");
		List<User> list=new ArrayList<>();
		for(User u:usersList) {
			if(u.getUsername().contains(name)) list.add(u);
		}
		if(list.isEmpty()) throw new UserException("Users Doesn't Exist with this name!!!");
		return list;
	}
  
}
