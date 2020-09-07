package com.example.microservice.currency.CurrencyConversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients("com.example.microservice.currency.CurrencyConversion")
@EnableSwagger2
public class CurrencyConversionApplication {
		public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}

		@Bean
		@LoadBalanced
		public RestTemplate restTemplate(){
			return new RestTemplate();
		}
		
		@Bean
		   public Docket productApi() {
		      return new Docket(DocumentationType.SWAGGER_2).select()
		         .apis(RequestHandlerSelectors.basePackage("com.example.microservice.currency.CurrencyConversion")).build();
		   }		
}
