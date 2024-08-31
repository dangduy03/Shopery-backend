package com.andy.shopery.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.andy.shopery.vn.dto.UserDTO;
import com.andy.shopery.vn.model.UserModel;
import com.andy.shopery.vn.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
    public void registerUser(UserDTO userDTO) {
        String password = passwordEncoder.encode(userDTO.getPassword());
        UserModel user = new UserModel(
        		userDTO.getFullName(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getPhoneNumber(),
                userDTO.getGender(),
                password
                
        );
        userRepository.save(user);
    }

    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

	public UserModel createUser(UserModel user) {
		return userRepository.save(user);
	}

	public List<UserModel> getAllUsers() {
		return userRepository.findAll();
	}

	public UserModel getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public UserModel updateUser(Long id, UserModel user) {
		user.setId(id);
		return userRepository.save(user);
	}

	public UserModel deleteUser(Long id) {
		userRepository.deleteById(id);
		return userRepository.findById(id).orElse(null);
	}
}
