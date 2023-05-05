package com.social_media_platform.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.social_media_platform.entites.Comment;
import com.social_media_platform.entites.Post;
import com.social_media_platform.entites.User;
import com.social_media_platform.non_entities.LoginDto;
import com.social_media_platform.service.CommentService;
import com.social_media_platform.service.PostService;
import com.social_media_platform.service.UserService;



@Controller
@RequestMapping("/socials")
public class UserController {
	@Autowired
    private UserService uService;
	
	@Autowired
    private CommentService cService;
	
	@Autowired
    private PostService pService;
	
	@PostMapping("/user/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User u){
		return new ResponseEntity<User>(uService.registerUser(u), HttpStatus.CREATED);
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<User> loginUser(@Valid @RequestBody LoginDto uLoginDto){
		return new ResponseEntity<User>(uService.loginUser(uLoginDto),HttpStatus.OK);
	}
	
	@GetMapping("/user/posts")
	public ResponseEntity<List<Post>> getAllBlog(@RequestParam("userId") Integer userId){
		return new ResponseEntity<List<Post>>(uService.getAllPost(userId),HttpStatus.OK);
	}
	
	@GetMapping("/user/search/{username}")
	public ResponseEntity<List<User>> findFriends(@PathVariable("username") String username){
		return new ResponseEntity<List<User>>(uService.findFriends(username),HttpStatus.OK);
	}
	
	
	@PostMapping("/user/comment")
	public ResponseEntity<Comment> registerComment(@Valid @RequestBody Comment comment){
		return new ResponseEntity<Comment>(cService.createComment(comment), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/delete/{commentId}")
	public ResponseEntity<Comment> deleteUserComment(@PathVariable("commentId") Integer commentId){
		return new ResponseEntity<Comment>(cService.deleteComment(commentId),HttpStatus.OK);
	}
	
	@PostMapping("/user/post")
	public ResponseEntity<Comment> registerUser(@Valid @RequestBody Comment comment){
		return new ResponseEntity<Comment>(cService.createComment(comment), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/delete/{postId}")
	public ResponseEntity<Post> deleteUserPost(@PathVariable("postId") Integer postId){
		return new ResponseEntity<Post>(pService.deletePost(postId),HttpStatus.OK);
	}
	
}

