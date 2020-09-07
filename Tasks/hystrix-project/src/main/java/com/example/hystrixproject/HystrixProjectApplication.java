package com.example.hystrixproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class HystrixProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixProjectApplication.class, args);
	}

}
