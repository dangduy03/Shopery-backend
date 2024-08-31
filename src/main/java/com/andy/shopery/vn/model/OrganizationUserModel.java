package com.andy.shopery.vn.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "organization_users")
public class OrganizationUserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private OrganizationModel organization;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserModel user;
}
