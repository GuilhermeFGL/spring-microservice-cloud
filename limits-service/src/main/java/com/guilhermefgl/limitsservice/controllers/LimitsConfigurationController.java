package com.guilhermefgl.limitsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilhermefgl.limitsservice.Configuration;
import com.guilhermefgl.limitsservice.models.LimitsConfiguration;

@RestController("/limits")
@RequestMapping("/limits")
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping
	public LimitsConfiguration retriveLimitsFromConfiguration() {
		return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}

}
