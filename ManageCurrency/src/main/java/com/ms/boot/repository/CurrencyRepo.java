package com.ms.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ms.boot.model.Currency;

@Component
public interface CurrencyRepo extends JpaRepository<Currency, Long>{

}
