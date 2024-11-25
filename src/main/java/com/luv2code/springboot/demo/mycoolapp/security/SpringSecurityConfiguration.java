package com.luv2code.springboot.demo.mycoolapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SpringSecurityConfiguration {
	// From LDAP or Database
	// or In Memory
	
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = User
		.withDefaultPasswordEncoder() // for test only, use a PasswordEncoder
		.username("user")
		.password("testuserpassword")
		.roles("USER")
		.build();

		UserDetails userDetails2 = User
		.withDefaultPasswordEncoder() // for test only, use a PasswordEncoder
		.username("admin")
		.password("testadminpassword")
		.roles("USER","ADMIN")
		.build();
		
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}
}
