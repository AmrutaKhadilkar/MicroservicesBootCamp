package com.ms.boot.model;

public class CurrencyDTO {
	
	private Long countryCode;
	private Double conversionFactor;
	private Double amount;
	private Double ConvertedAmount;
	public Long getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(Long countryCode) {
		this.countryCode = countryCode;
	}
	public Double getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getConvertedAmount() {
		return ConvertedAmount;
	}
	public void setConvertedAmount(Double convertedAmount) {
		ConvertedAmount = convertedAmount;
	}
	public CurrencyDTO(Long countryCode, Double conversionFactor, Double amount, Double convertedAmount) {
		super();
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
		this.amount = amount;
		ConvertedAmount = convertedAmount;
	}
	public CurrencyDTO() {
		
	}
	
	

}
