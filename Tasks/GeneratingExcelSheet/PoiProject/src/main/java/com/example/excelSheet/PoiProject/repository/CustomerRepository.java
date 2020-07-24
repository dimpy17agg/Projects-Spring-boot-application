package com.example.excelSheet.PoiProject.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.excelSheet.PoiProject.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
