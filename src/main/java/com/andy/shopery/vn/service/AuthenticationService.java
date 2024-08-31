package com.andy.shopery.vn.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.andy.shopery.vn.dto.LoginUserDto;
import com.andy.shopery.vn.dto.UserDTO;
import com.andy.shopery.vn.model.UserModel;
import com.andy.shopery.vn.repository.UserRepository;

@Service
public class AuthenticationService {
private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel signup(UserDTO input) {
    	UserModel user = new UserModel(); 
    	user.setFullName(input.getFullName());
    	user.setUsername(input.getUsername());
    	user.setGender(input.getGender());
    	user.setPhoneNumber(input.getPhoneNumber());
    	user.setEmail(input.getEmail());
    	user.setPassword(passwordEncoder.encode(input.getPassword()));
    	
    	
        return userRepository.save(user);
    }

    public UserModel authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }

}
