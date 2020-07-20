package dev.pedroteles.covid.entrypoint.entity.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryStatusDTO {
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("total")
    private int total;
    @JsonProperty("deaths")
    private int deaths;
    @JsonProperty("cured")
    private int cured;
    @JsonProperty("confirmed")
    private int confirmed;
}
