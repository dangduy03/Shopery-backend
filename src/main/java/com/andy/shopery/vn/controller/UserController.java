package com.andy.shopery.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andy.shopery.vn.model.UserModel;
import com.andy.shopery.vn.service.UserService;



@RestController
//@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping
	public List<UserModel> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public UserModel getUserById(@PathVariable Long id) {
		return this.userService.getUserById(id);
	}
	
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
//        this.userService.registerUser(userDTO);
//        return ResponseEntity.ok("User registered successfully!");
//    }
//    
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody UserDTO loginRequest) {
//    	String username = loginRequest.getUsername();
//        String password = loginRequest.getPassword();
//    	   	
//        UserModel user = userService.findByUsername(username);
//        if (user != null && new BCryptPasswordEncoder().matches(password, user.getPassword())) {
//            return ResponseEntity.ok("Login successful!");
//        } else {
//            return ResponseEntity.status(401).body("Invalid username or password");
//        }
//    }
    
	@PostMapping("/{}")
	public UserModel creaUser(@RequestBody UserModel user) {
		return userService.createUser(user);
	}

	@PutMapping("/{id}")
	public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel user) {
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}


}
