package com.example.microservice.currency.CurrencyConversion.resources;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import model.CurrencyConversionBean;

@FeignClient(name="forex-service", url="localhost:8000")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	  public CurrencyConversionBean retrieveExchangeValue
	    (@PathVariable("from") String from, @PathVariable("to") String to);
	
}
