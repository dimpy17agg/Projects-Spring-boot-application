package com.example.microservice.forex.ForexService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.forex.ForexService.model.ExchangeValue;
import com.example.microservice.forex.ForexService.repository.ExchangeValueRepository;
import com.example.microservice.forex.ForexService.service.ExchangeValueService;

@RestController
public class ForexController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueService exchangeValueService;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from,@PathVariable String to){
ExchangeValue exchangeValue=exchangeValueService.findByAndFromTo(from,to);
		
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
	
		return exchangeValue;
	}
	
}
