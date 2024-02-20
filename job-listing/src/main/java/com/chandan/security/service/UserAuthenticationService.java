package com.chandan.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chandan.security.dao.UserAuthenticationDao;
import com.chandan.security.model.User;
import com.chandan.security.model.UseraData;

@Service
public class UserAuthenticationService implements UserDetailsService {

	@Autowired
	UserAuthenticationDao userAuthenticationDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userAuthenticationDao.findByUserName(username);
		return new UseraData(user);
	}

}
