package com.udemy.microservices.currencyexchangeservice.dto;

import java.math.BigDecimal;

import com.udemy.microservices.currencyexchangeservice.entity.CurrencyExchange;

public class CurrencyExchangeDTO {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;

    public CurrencyExchangeDTO() {
    }

    public CurrencyExchangeDTO(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public CurrencyExchangeDTO(CurrencyExchange currencyExchange) {
        this.id = currencyExchange.getId();
        this.from = currencyExchange.getFrom();
        this.to = currencyExchange.getTo();
        this.conversionMultiple = currencyExchange.getConversionMultiple();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

}
