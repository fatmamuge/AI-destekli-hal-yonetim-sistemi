package com.fatmamuge.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "commission_agent")
public class CommissionAgent 

	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
	
	@Column(name = "campany_name", nullable = false, length = 50)
        private String campanyName;

	@Column(name = "tax_number", nullable = false, length = 20)
        private String taxNumber;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
        private User user;

	public Integer getID() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
