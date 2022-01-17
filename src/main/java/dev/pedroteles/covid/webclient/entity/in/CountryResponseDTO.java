package dev.pedroteles.covid.webclient.entity.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryResponseDTO {
    @JsonProperty("Country")
    private String countryName;
    @JsonProperty("Active")
    private int active;
    @JsonProperty("Confirmed")
    private int confirmed;
    @JsonProperty("Deaths")
    private int death;
    @JsonProperty("Recovered")
    private int cured;
}
