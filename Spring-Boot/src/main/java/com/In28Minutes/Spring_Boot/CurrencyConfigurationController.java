package com.In28Minutes.Spring_Boot;

import java.lang.module.Configuration;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
	
	@Autowired
	private CurrencyServiceConfiguration currencyServiceConfiguration;
	
	@RequestMapping("/currency-configuartion")
	public CurrencyServiceConfiguration retreiveAllCourse() {
		
		return currencyServiceConfiguration;
				
	}
	
	
}
