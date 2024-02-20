package com.chandan.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.chandan.model.Job;

public interface JobRepository extends MongoRepository<Job, Integer>{

}
