package com.guilhermefgl.currencyexchangeservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermefgl.currencyexchangeservice.models.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	Optional<ExchangeValue> findByFromAndTo(String from, String to);

}
