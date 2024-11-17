package com.food.ordering.system.order.service.domain.valueobject;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class StreetAddress {
    private final UUID id;
    private final String city;
    private final String street;
    private final String postalCode;

    public StreetAddress(UUID id, String city, String street, String postalCode) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetAddress that = (StreetAddress) o;
        return Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(postalCode, that.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street, postalCode);
    }
}
