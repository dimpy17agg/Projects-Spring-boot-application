package com.example.courseapi.courseExample.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.courseapi.courseExample.model.Course;

public interface CourseRepository extends CrudRepository<Course,String>{

}
