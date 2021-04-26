package com.ms.boot;

import java.io.Serializable;

public class CurrencyConRequest implements Serializable {
	
	private static final long serialVersionUID = 5093689614568882151L;
	private Double conversionFactor;
	private Double amount;
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
	
	public CurrencyConRequest(Double conversionFactor, Double amount) {
		super();
		this.conversionFactor = conversionFactor;
		this.amount = amount;
	}
	public CurrencyConRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "CurrencyConRequest [conversionFactor=" + conversionFactor + ", amount=" + amount + "]";
	}

}
