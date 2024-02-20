package com.chandan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

import jakarta.servlet.Filter;

@Configuration
public class ApiSecurityConfig {

	@Autowired
	UserDetailsService userDeatilsService;

	@Bean
	AuthenticationProvider auth() {
		DaoAuthenticationProvider manager = new DaoAuthenticationProvider();
		manager.setUserDetailsService(userDeatilsService);
		manager.setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
		return manager;
	}

	/*
	 * @Bean SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 * return http.addFilter(Filter) }
	 */

}
