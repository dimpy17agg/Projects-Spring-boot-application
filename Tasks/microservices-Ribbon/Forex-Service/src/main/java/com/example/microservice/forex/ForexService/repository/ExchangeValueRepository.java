package com.example.microservice.forex.ForexService.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice.forex.ForexService.model.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends CrudRepository<ExchangeValue,Long>{

	//ExchangeValue findByFromAndTo(String from,String to);
	
}
