package com.chandan.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "job")
public class Job {
	
	private int id;
	private String title;
	private String description;
	private String[] technologies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String[] technologies) {
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", technologies="
				+ Arrays.toString(technologies) + "]";
	}

}
