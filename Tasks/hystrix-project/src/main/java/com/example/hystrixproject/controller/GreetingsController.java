package com.example.hystrixproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController


public class GreetingsController {

	@GetMapping("/user/hello")
	@HystrixCommand(fallbackMethod="fallback_hello", commandProperties={ @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" , value="1000") })
	public String hello() throws InterruptedException{
		
      Thread.sleep(3000);
		return "Welcome Hystrix";
	}
	
	public String fallback_hello(){
		return "Request Fails!! it tooks too long to respond!";
		
	}
	
}
