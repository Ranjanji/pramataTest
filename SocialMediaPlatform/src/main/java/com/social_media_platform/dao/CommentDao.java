package com.social_media_platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social_media_platform.entites.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer>{

}
