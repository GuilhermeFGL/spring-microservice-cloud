package com.guilhermefgl.currencyconversionservice.controllers;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.guilhermefgl.currencyconversionservice.models.CurrencyConverion;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<Object> CurrencyConverion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		HashMap<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);

		ResponseEntity<CurrencyConverion> responseEntity = null;
		try {
			responseEntity = new RestTemplate().getForEntity(
					"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConverion.class,
					uriVariable);
		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
		}

		CurrencyConverion response = responseEntity.getBody();
		return ResponseEntity.status(HttpStatus.OK)
				.body(new CurrencyConverion(response.getId(), from, to, response.getConversionMultiple(), quantity,
						quantity.multiply(response.getConversionMultiple()), response.getPort()));
	}

}
