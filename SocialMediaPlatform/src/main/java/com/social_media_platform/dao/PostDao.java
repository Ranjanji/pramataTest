package com.social_media_platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social_media_platform.entites.Post;
@Repository
public interface PostDao extends JpaRepository<Post, Integer>{

}
