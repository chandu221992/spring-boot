package com.chandan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.model.Job;
import com.chandan.service.JobService;

@RestController
public class JobController {

	@Autowired
	JobService jobService;

	@PostMapping("job")
	public ResponseEntity<Job> postJob(@RequestBody Job job) {
		Job postedJob = jobService.postJob(job);
		return new ResponseEntity<Job>(postedJob, HttpStatus.OK);
	}

	@GetMapping("job/{id}")
	public ResponseEntity<Job> getJob(@PathVariable("id") int id) {
		Job job = jobService.getJobById(id); 
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}

	
	@GetMapping("jobs")
	public ResponseEntity<List<Job>> getJobs() {
		List<Job> jobs = jobService.getJobs();
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}
}
