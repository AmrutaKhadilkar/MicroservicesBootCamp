package com.ms.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.boot.model.Currency;
import com.ms.boot.model.CurrencyConResponse;
import com.ms.boot.model.CurrencyDTO;
import com.ms.boot.repository.CurrencyRepo;
import com.ms.boot.service.CurrencyService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/")
public class CurrencyController {
	
	@Autowired
	CurrencyService currencyService;
	
	@Autowired
	CurrencyRepo repo;
	
	
	@GetMapping("/product")
	public List<Currency> getAllCurrencies() {
		return currencyService.getAllCurrencies();
	}

	@PostMapping("/currency")
	public ResponseEntity createCurrency(@RequestBody  Currency currency)
	{
		Currency c =new Currency();
		c= currencyService.createCurrency(currency);
		if (c != null) {
			return new ResponseEntity<Currency>(c, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Currency>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/currency/{countryCode}")
	public ResponseEntity<Currency> getCurrencyById(@PathVariable Long countryCode) {
		Currency c = currencyService.getCurrencyById(countryCode);
		if (c != null) {
			return new ResponseEntity<Currency>(c, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Currency>(HttpStatus.NOT_FOUND);
		}
	}
	
	

	@PutMapping("/currencyupdate/{countryCode}/{conversionFactor}")
	public ResponseEntity<Object> updateStudent(@RequestBody Currency currency, @PathVariable long countryCode, @PathVariable Double conversionFactor ) {

		Optional<Currency> op = repo.findById(countryCode);
		if (!op.isPresent())
			return ResponseEntity.notFound().build();

		currency.setConversionFactor(conversionFactor);
		
		repo.save(currency);
		return ResponseEntity.ok().build();
	}
	
	@CircuitBreaker(name ="conversioncurrency", fallbackMethod = "convertamout")
	@GetMapping(path = "/Currency/v1/{countryCode}/{amount}")
	public ResponseEntity<CurrencyDTO> getConvertedAmount(@PathVariable Long countryCode, @PathVariable Double amount ) {
		Currency c = currencyService.getCurrencyById(countryCode);
		if (c != null) {
			CurrencyDTO cdto = currencyService.convertedAmt(c,amount);
			return new ResponseEntity<CurrencyDTO>(cdto, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<CurrencyDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	public  ResponseEntity<CurrencyDTO> convertamout(Long countryCode, Double amount , Throwable t)
	{
		Currency c= currencyService.getCurrencyById(countryCode);
		if(c != null) {
			CurrencyDTO cdto =currencyService.ceatecurrencyResponseDTO(new CurrencyConResponse(c.getConversionFactor(),amount,0.0), c, amount);
			return new ResponseEntity<CurrencyDTO>(cdto,HttpStatus.FOUND);
	
		} else {
			
			return new ResponseEntity<CurrencyDTO>(HttpStatus.NOT_FOUND);
		}
	}
}
