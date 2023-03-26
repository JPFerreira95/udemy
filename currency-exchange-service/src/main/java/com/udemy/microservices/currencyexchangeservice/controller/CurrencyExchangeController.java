package com.udemy.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.microservices.currencyexchangeservice.constants.Constants;
import com.udemy.microservices.currencyexchangeservice.dto.CurrencyExchangeDTO;
import com.udemy.microservices.currencyexchangeservice.service.CurrencyExchangeService;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchangeDTO retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to) {

        CurrencyExchangeDTO currencyExchangeDTO = currencyExchangeService.findByFromAndTo(from, to);

        String port = environment.getProperty(Constants.PROPERTY_LOCAL_SERVER_PORT);
        currencyExchangeDTO.setEnvironment(port);
        return currencyExchangeDTO;
    }

}
