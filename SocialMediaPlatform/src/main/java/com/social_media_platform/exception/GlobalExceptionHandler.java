package com.social_media_platform.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> myHandler2(Exception e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> myHandler3(NoHandlerFoundException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> myHandler1(UserException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FollowException.class)
	public ResponseEntity<ErrorDetails> myHandler4(FollowException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CommentException.class)
	public ResponseEntity<ErrorDetails> myHandler4(CommentException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PostException.class)
	public ResponseEntity<ErrorDetails> myHandler4(PostException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
}

