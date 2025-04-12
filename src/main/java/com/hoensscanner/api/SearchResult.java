package com.hoensscanner.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {
    private String city;
    private String kind;
    private String title;

    @JsonProperty
    public String getCity() {
        return city;
    }

    @JsonProperty
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty
    public String getKind() {
        return kind;
    }

    @JsonProperty
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public void setTitle(String title) {
        this.title = title;
    }
}
