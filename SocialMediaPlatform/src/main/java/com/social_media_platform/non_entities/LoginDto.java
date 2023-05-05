package com.social_media_platform.non_entities;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
public class LoginDto {
	
	@Size(max=10,min=5,message="Username length in between 5-10 characters")
	private String username;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,12}$",message = "password length must contain atleast 6-12 characters of atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
	private String password;
}
