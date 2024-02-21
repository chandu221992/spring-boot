package com.chandan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.model.Job;
import com.chandan.service.JobService;

@RestController
@RequestMapping("job")
public class JobController {
	
	@Autowired
	JobService jobService;

	@PostMapping
	public ResponseEntity<Job> postJob(@RequestBody Job job) {
		Job postedJob = jobService.postJob(job);
		return new ResponseEntity<>(postedJob, HttpStatus.CREATED);
	}

	@GetMapping("getJob/{id}")
	public ResponseEntity<Job> getJob(@PathVariable("id") int id) {
		Job job = jobService.getJobById(id); 
		return new ResponseEntity<>(job, HttpStatus.OK);
	}

	
	@GetMapping("getJobs")
	public ResponseEntity<List<Job>> getJobs() {
		List<Job> jobs = jobService.getJobs();
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}
}
