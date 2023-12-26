package com.udemy.microservices.currencyexchangeservice.service;

import com.udemy.microservices.currencyexchangeservice.dto.CurrencyExchangeDTO;

public interface CurrencyExchangeService {

    public CurrencyExchangeDTO findByFromAndTo(String from, String to);

}
