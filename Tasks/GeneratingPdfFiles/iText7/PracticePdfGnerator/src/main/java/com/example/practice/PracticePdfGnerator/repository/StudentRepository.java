package com.example.practice.PracticePdfGnerator.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.practice.PracticePdfGnerator.model.Student;

public interface StudentRepository extends CrudRepository<Student,Long>{
	
}
