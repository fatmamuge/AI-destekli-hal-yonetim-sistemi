package com.fatmamuge.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
@Table(name = "role")
public class Role {

	@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
    	private Integer id;

       	@Column(nullable = false, unique = true, length = 30)
    	private String name;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
