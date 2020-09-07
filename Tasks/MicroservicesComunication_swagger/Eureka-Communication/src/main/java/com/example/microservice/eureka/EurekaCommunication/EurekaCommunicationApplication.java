package com.example.microservice.eureka.EurekaCommunication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaCommunicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCommunicationApplication.class, args);
	}

}
