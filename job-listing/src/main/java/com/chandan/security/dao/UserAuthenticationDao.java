package com.chandan.security.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chandan.security.model.User;


public interface UserAuthenticationDao extends MongoRepository<User, Integer> {
	
	User findByUserName(String userName);

}
