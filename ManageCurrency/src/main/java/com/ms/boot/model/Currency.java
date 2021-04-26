package com.ms.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name ="currency")
public class Currency {
	
	@Id
	private Long countryCode;
	private Double conversionFactor;
	
	public Currency(Long countryCode, Double conversionFactor) {
		super();
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}

	public Currency() {
		
	}
	
	
	
	
}
