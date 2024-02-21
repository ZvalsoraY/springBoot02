package org.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@Service
@RestController
public class WeatherService {
    public static final String HTTPS_API_TOMORROW = "https://api.tomorrow.io/v4/weather/forecast?location=42.3478,-71.0466&apikey=pNUtOp0ykI06tOU6W7ReCNFx8PlWQ39i";
    public static final String LOCATION = "";
    public static final String  API_KEY = "";

    @GetMapping("/weather")
    public String weatherResponse() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForEntity(HTTPS_API_TOMORROW, String.class).getBody();
        return response;
    }
}