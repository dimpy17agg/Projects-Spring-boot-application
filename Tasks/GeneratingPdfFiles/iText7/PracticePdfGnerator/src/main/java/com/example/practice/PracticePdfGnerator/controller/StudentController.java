package com.example.practice.PracticePdfGnerator.controller;

import java.io.ByteArrayInputStream;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.PracticePdfGnerator.model.Student;
import com.example.practice.PracticePdfGnerator.repository.StudentRepository;
import com.example.practice.PracticePdfGnerator.util.*;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping(value="/students/pdfreport",produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getStudents(){
		List<Student> st=(List<Student>) studentRepository.findAll();
		ByteArrayInputStream bis=PdfGenerate.pdfConvertor(st);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=studentsReport.pdf");
        
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));
       
	}
	
}
