package com.udemy.microservices.currencyexchangeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.microservices.currencyexchangeservice.dto.CurrencyExchangeDTO;
import com.udemy.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.udemy.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.udemy.microservices.currencyexchangeservice.service.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Override
    public CurrencyExchangeDTO findByFromAndTo(String from, String to) {

        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("Unabled to find data from " + from + " to " + to);
        }

        return new CurrencyExchangeDTO(currencyExchange);
    }

}
