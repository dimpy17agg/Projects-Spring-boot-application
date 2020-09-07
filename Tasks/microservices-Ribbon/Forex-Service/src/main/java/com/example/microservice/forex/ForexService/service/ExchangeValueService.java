package com.example.microservice.forex.ForexService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice.forex.ForexService.model.ExchangeValue;
import com.example.microservice.forex.ForexService.repository.ExchangeValueRepository;

@Service
public class ExchangeValueService {
   
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

    public ExchangeValue findByAndFromTo(String from,String to){
    	   
    	//ExchangeValue exchangeValue=(ExchangeValue) exchangeValueRepository.findAll();
    	ExchangeValue l=null;
    	List<ExchangeValue> exchangeValue=(List<ExchangeValue>) exchangeValueRepository.findAll();
    	for(int i=0;i<exchangeValue.size();i++){		
    		 l=exchangeValue.get(i);
    		if(l.getFrom().equals(from) && l.getTo().equals(to)){
    		   return l;
    		}
    	}
    	return l;
    	
    }
    
      	
}
