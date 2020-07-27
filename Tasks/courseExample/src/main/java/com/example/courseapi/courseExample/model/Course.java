package com.example.courseapi.courseExample.model;

import javax.persistence.*;

@Entity
@Table
public class Course {

	@Id
	@Column
	private String courseId;
	@Column
	private String name;
	@Column
	private String description;
	
	Course(){
		
	}

	public Course(String courseId, String name, String description) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.description = description;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		return courseId+""+name+""+description;
	}
	
	
}
