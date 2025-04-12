package com.hoensscanner.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {
    private String city;

    @JsonProperty
    public String getCity() {
        return city;
    }

    @JsonProperty
    public void setCity(String city) {
        this.city = city;
    }
}
