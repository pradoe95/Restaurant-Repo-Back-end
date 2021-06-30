package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Admin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 569341728137871279L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long admin_id;

	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "password")
	private String password;

	
	
	public Admin() {
		this(-1L, "n/a", "n/a");
		// TODO Auto-generated constructor stub
	}

	public Admin(Long admin_id, @NotNull String username, @NotNull String password) {
		super();
		this.admin_id = admin_id;
		this.username = username;
		this.password = password;
	}

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
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

	

	
	
	
}
