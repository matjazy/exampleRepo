package com.Project3.Server.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Model representing user.
 * @author MJazy
 *
 */
@Entity
@Table(name ="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String email;

	// Password should be supplied after encryption.
	private String password;
	
	
	//To do: roles column.

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
			
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		String string = String.format("id: '%s', username: '%s', email: '%s', password: '%s'", this.getId(), this.getUsername(), this.getEmail(), this.getPassword());
		return string;
	}
	
}