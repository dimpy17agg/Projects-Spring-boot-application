package com.example.courseapi.courseExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courseapi.courseExample.repository.CourseRepository;
import com.example.courseapi.courseExample.model.*;
@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> findCourses(){
	   List<Course> list=(List<Course>)courseRepository.findAll();
	  return list;
	}
	
}
