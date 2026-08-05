package com.fatmamuge.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "producer")
public class Producer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 125)
	private String address;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddess() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
	       return user;
	}
	public void setUser(User user) {
	this.user = user;
	}	
}
