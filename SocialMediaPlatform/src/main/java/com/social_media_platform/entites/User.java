package com.social_media_platform.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@Size(max=10,min=5,message="Username length in between 5-10 characters")
	private String username;
	
	@Email
	private String email;
	
	@Min(value = 13, message = "Age must be above 12 years")
	private Integer age; 
	
	private String gender;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,12}$",message = "password length must contain atleast 6-12 characters of atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
	private String password; 
	
	private String profileImage;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Post> posts;
}
