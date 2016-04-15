package com.searover.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by searover on 4/5/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
    private Long id;
    private String quote;

    public Value() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public java.lang.String toString() {
        return "Value{ id=" + id + ", quote='" + quote + "'}";
    }
}
