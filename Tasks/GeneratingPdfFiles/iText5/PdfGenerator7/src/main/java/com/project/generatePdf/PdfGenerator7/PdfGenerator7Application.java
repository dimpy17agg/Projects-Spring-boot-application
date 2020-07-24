package com.project.generatePdf.PdfGenerator7;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.generatePdf.PdfGenerator7.model.Employee;
import com.project.generatePdf.PdfGenerator7.repository.EmployeeRepository;

@SpringBootApplication
public class PdfGenerator7Application implements CommandLineRunner{

	@Autowired
	EmployeeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(PdfGenerator7Application.class, args);
	}
	 public void run(String... args) throws Exception {
	      
	      if(repository.count() == 0) {
	        // save a list of Customers
	        repository.saveAll(Arrays.asList(new Employee((long)1,"naman", "software develope"), 
	                        new Employee((long)2,"Aman", "business consultant"), 
	                        new Employee((long)3,"Kapil", "senior software engineer"),
	                        new Employee((long)4,"David", "QA consultant"), 
	                        new Employee((long)5,"jim","manager")));
	      }
	 }
	
	
}
