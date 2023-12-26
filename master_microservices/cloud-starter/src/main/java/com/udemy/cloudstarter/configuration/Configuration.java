package com.udemy.cloudstarter.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Class that maps the properties configured in application.properties.
 * <p>
 * In this case by having @ConfigurationProperties("limits-service"), which this does is to map the properties that have
 * the prefix "limits-service" and than the variables created in this class will be mapped as long as there is a '.'
 * that separates them from the prefix. Ex. limits-service.minimum=2
 */
@Component
@ConfigurationProperties("limits-service")
public class Configuration {

    private int minimum;
    private int maximum;

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
