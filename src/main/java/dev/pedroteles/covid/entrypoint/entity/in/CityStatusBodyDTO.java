package dev.pedroteles.covid.entrypoint.entity.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityStatusBodyDTO {
    @JsonProperty("city_name")
    private String cityName;
}
