package ro.itschool.project.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseDTO {

    private String city;
    private String setDescription;
    private LocalDateTime setLastUpdate;
}