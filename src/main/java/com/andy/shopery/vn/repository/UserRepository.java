package com.andy.shopery.vn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andy.shopery.vn.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
	Optional<UserModel>  findByUsername(String username);

}