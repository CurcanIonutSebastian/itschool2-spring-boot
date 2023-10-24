package ro.itschool.project.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import ro.itschool.project.models.dtos.WeatherResponseDTO;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Override
    public WeatherResponseDTO getCityWeather(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://api.weatherapi.com/v1/current.json?key=ec8face8cc00456babd144815230510&q=" + city + "&aqi=no").build();
        Response response = client.newCall(request).execute();

        ObjectMapper objectMapper = new ObjectMapper();
        String responseBody = response.body().string();

        JsonNode jsonNode = objectMapper.readTree(responseBody);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(jsonNode.get("current").get("last_updated").asText(), formatter);

        WeatherResponseDTO weatherResponseDTO = new WeatherResponseDTO();
        weatherResponseDTO.setCity(jsonNode.get("location").get("name").toString());
        weatherResponseDTO.setSetLastUpdate(localDateTime);
        weatherResponseDTO.setSetDescription(jsonNode.get("current").get("condition").get("text").toString());

        return weatherResponseDTO;
    }
}
