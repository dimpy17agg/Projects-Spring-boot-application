package com.project.generatePdf.PdfGenerator7.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.generatePdf.PdfGenerator7.model.Employee;
import com.project.generatePdf.PdfGenerator7.repository.EmployeeRepository;
import com.project.generatePdf.PdfGenerator7.util.PdfGenerator;

@RestController
@RequestMapping("/api/pdf")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping(value="/employees",produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeList() throws Exception{
		List<Employee> emp=(List<Employee>) employeeRepository.findAll();
		ByteArrayInputStream b=PdfGenerator.employeePdfReport(emp);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition","inline;filename=employee.pdf");
		 return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(b));
	}
	
	
	
}
