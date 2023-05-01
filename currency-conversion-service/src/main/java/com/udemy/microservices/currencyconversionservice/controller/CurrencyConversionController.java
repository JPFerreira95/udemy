package com.udemy.microservices.currencyconversionservice.controller;

import com.udemy.microservices.currencyconversionservice.entity.CurrencyConversion;
import com.udemy.microservices.currencyconversionservice.proxy.currencyexchange.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * This next class will use the previously created currency-exchange service to get data from it
 * and use that data to add even more in this service.
 * <p>
 * Diagram to explain:
 * <p>
 * |----------------------------------|      |--------------------------------|      |----------|
 * | currency conversion microservice | ---> | currency exchange microservice | ---> | database |
 * |----------------------------------|      |--------------------------------|      |----------|
 * <p>
 * In this specific case we will pass the from and to from the currency-exchange, and in addition we will
 * also pass the quantity we want to convert using the data that comes from currency-exchange.
 */
@RestController
//@RequestMapping("currency-conversion")
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity){

        // Create map with uri variables to add it to the rest request
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        // Create a rest request?
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class, uriVariables);

        // Get response body from rest request
        CurrencyConversion currencyConversion = responseEntity.getBody();

        // Fill response with fields came from response
        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
                currencyConversion.getConversionMultiple(),
                currencyConversion.getConversionMultiple().multiply(quantity),
                currencyConversion.getEnvironment());
    }

    @GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity){

        // Get currency conversion from proxy
        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

        // Fill response with fields came from response
        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
                currencyConversion.getConversionMultiple(),
                currencyConversion.getConversionMultiple().multiply(quantity),
                currencyConversion.getEnvironment());
    }

}
