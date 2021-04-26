package com.ms.boot;

public class CurrencyConResponse {
	
	private Double conversionFactor;
	private Double amount;
	private Double ConvertedAmount;
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
	public CurrencyConResponse(Double conversionFactor, Double amount, Double convertedAmount) {
		super();
		this.conversionFactor = conversionFactor;
		this.amount = amount;
		ConvertedAmount = convertedAmount;
	}
	public CurrencyConResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CurrencyConResponse [conversionFactor=" + conversionFactor + ", amount=" + amount + ",ConvertedAmount=" + ConvertedAmount + "]";
	}

}
