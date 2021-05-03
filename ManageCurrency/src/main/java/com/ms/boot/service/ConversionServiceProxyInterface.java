package com.ms.boot.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.boot.model.CurrencyConRequest;
import com.ms.boot.model.CurrencyConResponse;

@FeignClient(name ="CURRENCYCONVERT", url = "http://currencyconvert:8091")
public interface ConversionServiceProxyInterface {
	
	
		@RequestMapping(value = "/convertedcurrency", method = RequestMethod.POST)
		public CurrencyConResponse calculateAmount(CurrencyConRequest request);
			
	}



