package com.ms.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.boot.CurrencyConRequest;
import com.ms.boot.CurrencyConResponse;


@RestController
public class CurrencyController {
	
	private static Logger log = LoggerFactory.getLogger(CurrencyController.class);

	@PostMapping( "/convertedcurrency")
	public CurrencyConResponse calculateAmount(@RequestBody(required = false) CurrencyConRequest request) {
		
		Double ConvertedAmount = request.getConversionFactor() * request.getAmount();
		CurrencyConResponse response = new CurrencyConResponse(request.getConversionFactor(), request.getAmount(),ConvertedAmount);
		return response;
	}
	

}
