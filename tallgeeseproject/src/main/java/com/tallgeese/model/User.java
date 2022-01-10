package com.tallgeese.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="gachaUser")
public class User {

	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	@Id
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	//need to encrypt password later on????
	@Column(name="password", nullable=false)
	private String password;
	

	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Collectable> collectable;

	public User() {
		super();
	}
	
	public User(String email, String username, String password, List<Collectable> collectable) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.collectable = collectable;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Collectable> getCollectable() {
		return collectable;
	}

	public void setCollectable(List<Collectable> collectable) {
		this.collectable = collectable;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + ", collectable="
				+ collectable + "]";
	}
}
