package com.StudentManagement.dto;

import com.StudentManagement.entity.validators.EmailValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@EmailValidator(message = "{user.invalid.email}")
//	private String email;

	private String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	public LoginDto() {
	}

	/**
	 * @return the email
	 */
//	public String getEmail() {
//		return email;
//	}

	/**
	 * @param email the email to set
	 */
//	public void setEmail(String email) {
//		this.email = email;
//	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
