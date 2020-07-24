package com.example.excelSheet.PoiProject.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.excelSheet.PoiProject.model.Customer;
import com.example.excelSheet.PoiProject.repository.CustomerRepository;
import com.example.excelSheet.PoiProject.util.ExcelGenerator;

@RestController
@RequestMapping("/api/customers")
public class CustomerExcelDownloadRestAPI {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping(value="/download/customer.xlsx")
	public ResponseEntity<InputStreamResource> findCustomers() throws Exception{
	    List<Customer> customer=(List<Customer>) customerRepository.findAll();	
	ByteArrayInputStream in=ExcelGenerator.customersToExcel(customer);
	
	HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
    
    return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    
	}
	
	
}
