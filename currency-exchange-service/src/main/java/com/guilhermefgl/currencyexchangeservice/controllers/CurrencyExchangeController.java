package com.guilhermefgl.currencyexchangeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilhermefgl.currencyexchangeservice.models.ExchangeValue;
import com.guilhermefgl.currencyexchangeservice.services.ExchangeValueService;
import com.guilhermefgl.currencyexchangeservice.utils.exceptions.ExchangeValueNotFoundException;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

	private static final String PROPERTY_PORT = "local.server.port";

	@Autowired
	Environment environment;
	
	@Autowired
	ExchangeValueService service;

	@GetMapping("/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) throws ExchangeValueNotFoundException {
		ExchangeValue exchangeValue = service.findExchangeValue(from, to);
		exchangeValue.setPort(Integer.valueOf(environment.getProperty(PROPERTY_PORT)));
		return exchangeValue;
	}

}
