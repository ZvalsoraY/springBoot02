package org.example.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.example.dto.WeatherResponse;

public class WeatherResponseMapper {
    private final ObjectMapper jsonParser = new ObjectMapper();

    @SneakyThrows
    public WeatherResponse mapWeatherResponse(String str) {
        JsonNode jsonNode = jsonParser.readTree(str);
        return new WeatherResponse(
                getLocation(jsonNode)
                ,getAVGTemperatures(jsonNode, "minutely","temperature")
                ,getAVGTemperatures(jsonNode, "hourly","temperature")
                ,getAVGTemperatures(jsonNode, "daily","temperature")
        );
    }

    private double getAVGTemperatures(JsonNode jsonNode, String range, String nodeName) {
        return jsonNode.get("timelines").get(range).findValues(nodeName)
                .stream()
                .mapToDouble(x -> Double.parseDouble(x.asText())).average().getAsDouble();
    }
}