package com.chandan.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

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
	 * return http.authorizeRequests().requestMatchers("/job").hasAnyRole("admin").
	 * requestMatchers(HttpMethod.POST).permitAll().bu;
	 * 
	 * }
	 */

}
