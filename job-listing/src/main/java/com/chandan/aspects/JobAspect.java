package com.chandan.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JobAspect {

	private final Logger LOGGER = LoggerFactory.getLogger(JobAspect.class);

	@Before("execution(public org.springframework.http.ResponseEntity<java.util.List<com.chandan.model.Job>> com.chandan.controller.JobController.getJobs())")
	public void getBeforeLog() {

		LOGGER.info("execution started for methods");

	}
	
	
	@After("execution(public org.springframework.http.ResponseEntity<java.util.List<com.chandan.model.Job>> com.chandan.controller.JobController.getJobs())")
	public void getAfterLog() {

		LOGGER.info("execution finished for methods");

	}
	
	@AfterReturning("execution(public org.springframework.http.ResponseEntity<java.util.List<com.chandan.model.Job>> com.chandan.controller.JobController.getJobs())")
	public void getAfterSuccessLog() {

		LOGGER.info("execution successfully finished for methods");

	}
	
	@AfterThrowing("execution(public org.springframework.http.ResponseEntity<java.util.List<com.chandan.model.Job>> com.chandan.controller.JobController.getJobs())")
	public void getAfterErrorLog() {

		LOGGER.info("execution failed for methods");

	}

}
