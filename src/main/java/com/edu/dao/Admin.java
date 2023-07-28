package com.edu.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminid;
	
	@Column(length = 40, nullable = false)
	@NotBlank(message = "Username cannot be blank")
	@NotEmpty(message = "Username cannot be empty")
	@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
	private String username ;
	
	@Column(length = 40, nullable = false)
	@NotBlank(message = "Password cannot be blank")
	@NotEmpty(message = "Password cannot be empty")
	@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&].{8,}")
	private String password;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return adminid;
	}

	public void setId(Integer id) {
		this.adminid = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + adminid + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
