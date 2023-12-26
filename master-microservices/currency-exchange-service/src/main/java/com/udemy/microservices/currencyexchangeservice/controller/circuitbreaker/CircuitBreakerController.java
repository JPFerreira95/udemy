package com.udemy.microservices.currencyexchangeservice.controller.circuitbreaker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    // @Retry(name = "default", fallbackMethod = "hardcodedResponse") // This annotation does not work, don't know why and there's no responses on the internet
    // @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse") // This annotation does not work, don't know why and there's no responses on the internet
    public String sampleApi() {
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);

        return forEntity.getBody();
    }

    /*
     * This method works like an exception handler for the retry annotation
     */
    private String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }
}
