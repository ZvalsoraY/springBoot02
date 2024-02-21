package org.example.dto;

import com.fasterxml.jackson.databind.ObjectMapper;


public class WeatherResponse {
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String location;
}