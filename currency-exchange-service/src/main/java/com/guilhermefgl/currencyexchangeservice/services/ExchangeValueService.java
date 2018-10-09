package com.guilhermefgl.currencyexchangeservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermefgl.currencyexchangeservice.models.ExchangeValue;
import com.guilhermefgl.currencyexchangeservice.repositories.ExchangeValueRepository;
import com.guilhermefgl.currencyexchangeservice.utils.exceptions.ExchangeValueNotFoundException;

@Service
public class ExchangeValueService {
	
	@Autowired
	ExchangeValueRepository repository;
	
	public ExchangeValue findExchangeValue(String from, String to) throws ExchangeValueNotFoundException {
		Optional<ExchangeValue> exchangeValue = repository.findByFromAndTo(from, to);
		if (!exchangeValue.isPresent()) {
			throw new ExchangeValueNotFoundException(from, to);
		}
		return exchangeValue.get();
	}

}
