package com.andy.shopery.vn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
public class VnApplication {

	public static void main(String[] args) {
		SpringApplication.run(VnApplication.class, args);
	}

}
