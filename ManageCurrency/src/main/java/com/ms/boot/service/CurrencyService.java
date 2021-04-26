package com.ms.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.boot.model.Currency;
import com.ms.boot.model.CurrencyConRequest;
import com.ms.boot.model.CurrencyConResponse;
import com.ms.boot.model.CurrencyDTO;
import com.ms.boot.repository.CurrencyRepo;

@Service
public class CurrencyService {
	
	@Autowired
	CurrencyRepo repo;
	
	@Autowired
	ConversionServiceProxyInterface conversionServiceProxyInterface;
	
	public List<Currency> getAllCurrencies() {
		return repo.findAll();
	}

	public Currency getCurrencyById(Long countryCode) {
		Optional<Currency> op = repo.findById(countryCode);
		if (op.isPresent())
			return op.get();
		else
			return null;
	}
	
	public Currency createCurrency(Currency currency) {
		
		repo.save(currency);
		return currency;
	}
	
	public CurrencyDTO convertedAmt(Currency c, Double amount) {
		CurrencyConRequest currencyConRequest = createCurrencyConRequest(c,amount);
		return ceatecurrencyResponseDTO(conversionServiceProxyInterface.calculateAmount(currencyConRequest),c,amount);
	}

	
	private CurrencyConRequest createCurrencyConRequest(Currency c, Double amount) {
		return new CurrencyConRequest(c.getConversionFactor(),amount);
	}

	
	public CurrencyDTO ceatecurrencyResponseDTO(CurrencyConResponse currencyConResponse, Currency c,Double amount) {
		CurrencyDTO cdto = new CurrencyDTO();
		
		cdto.setCountryCode(c.getCountryCode());
		cdto.setConversionFactor(c.getConversionFactor());
		cdto.setAmount(amount);
		cdto.setConvertedAmount(currencyConResponse.getConvertedAmount());
		return cdto;
		
}


}
