package dev.pedroteles.covid.webclient.entity.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StateResponseDTO {
    @JsonProperty("state")
    private String stateName;
    @JsonProperty("cases")
    private int totalCases;
    @JsonProperty("deaths")
    private int totalDeaths;
    @JsonProperty("suspects")
    private int totalSuspects;
}
