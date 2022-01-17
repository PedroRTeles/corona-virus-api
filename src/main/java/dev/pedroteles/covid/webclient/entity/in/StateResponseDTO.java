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
    @JsonProperty("nome")
    private String name;
    @JsonProperty("obitosAcumulado")
    private int totalDeaths;
    @JsonProperty("casosAcumulado")
    private int totalSuspects;
}
