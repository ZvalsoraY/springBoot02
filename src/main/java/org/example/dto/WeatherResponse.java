package org.example.dto;

import com.fasterxml.jackson.databind.ObjectMapper;


public class WeatherResponse {

    private Location location;
    private double avgMinutely;
    private double avgHourly;
    private double avgDaily;

    public WeatherResponse(Location location, double avgTemperatures, double avgTemperatures1, double avgTemperatures2) {
    }
}