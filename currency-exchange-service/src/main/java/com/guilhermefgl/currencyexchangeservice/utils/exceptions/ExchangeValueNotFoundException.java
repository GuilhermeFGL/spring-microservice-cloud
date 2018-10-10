package com.guilhermefgl.currencyexchangeservice.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExchangeValueNotFoundException extends Exception {
	
	private static final long serialVersionUID = -5717648149647990246L;
	
	private static final String MESSAGE = "Conversion from %s to %s not found";

	public ExchangeValueNotFoundException(String from, String to) {
		super(String.format(MESSAGE, from, to));
	}

}
