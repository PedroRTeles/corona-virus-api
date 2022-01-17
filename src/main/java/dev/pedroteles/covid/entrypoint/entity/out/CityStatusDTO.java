package dev.pedroteles.covid.entrypoint.entity.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityStatusDTO {
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("total")
    private int total;
    @JsonProperty("deaths")
    private int deaths;
}
