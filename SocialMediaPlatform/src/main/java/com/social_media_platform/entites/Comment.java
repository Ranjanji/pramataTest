package com.social_media_platform.entites;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentId;
	private Integer postId;
	private Integer user_id;
	private String content;
	private LocalDateTime created_at;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Post posts;
}
