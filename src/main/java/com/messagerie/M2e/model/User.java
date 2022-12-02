package com.messagerie.M2e.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "username")
	private String username;

	public User(String username) {
		this.username = username;
	}

	public User() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}

	public void patch(User dataToUpdate) {
		if (dataToUpdate.getUsername() != null) {
			this.username = dataToUpdate.getUsername();
		}
	}
}
