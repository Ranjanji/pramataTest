package com.social_media_platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social_media_platform.entites.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
