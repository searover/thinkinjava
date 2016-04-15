package com.searover.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by searover on 4/5/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String type;
    private Value value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
