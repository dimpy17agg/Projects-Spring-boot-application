package com.example.practice.PracticePdfGnerator.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table
public class Student {

	@Id
	@Column
	private Long id;
	 private String name ;
	 Student(){
		 
	 }
	public Student(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 
	
	
}
