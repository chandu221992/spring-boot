package com.chandan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandan.dao.JobRepository;
import com.chandan.model.Job;

@Service
public class JobService {

	@Autowired
	private JobRepository jobRepository;

	public Job postJob(Job job) {
		return jobRepository.save(job);
	}

	public Job getJobById(int id) {
         return jobRepository.findById(id).get();
	}

	public List<Job> getJobs() {
	     return jobRepository.findAll();
	}

}
