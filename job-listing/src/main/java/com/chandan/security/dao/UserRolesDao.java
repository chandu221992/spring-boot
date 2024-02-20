package com.chandan.security.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chandan.security.model.UserRoles;

@Repository
public interface UserRolesDao extends MongoRepository<UserRoles, Integer> {

	List<String> findByUserId(int id);

}
