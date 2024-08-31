package com.andy.shopery.vn.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.andy.shopery.vn.enums.Gender;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;;

@Entity
@Table(name = "users")
public class UserModel implements UserDetails  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	@Column(name = "full_name", length = 64)
	private String fullName;

	@Column(nullable = false,length = 64)
	private String username;
	
	@Column(nullable = false, length = 128)
	private String email;	

	@Column(name = "phone_number", length = 16)
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrganizationUserModel> organizationUsers = new HashSet<>();

	public UserModel() {
		super();
	}

	
	public UserModel(String fullName, String username, String email, String phoneNumber, Gender gender, String password) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<OrganizationUserModel> getOrganizationUsers() {
		return organizationUsers;
	}

	public void setOrganizationUsers(Set<OrganizationUserModel> organizationUsers) {
		this.organizationUsers = organizationUsers;
	}


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}



		
}
