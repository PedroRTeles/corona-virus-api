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
public class StateStatusDTO {
    @JsonProperty("state_name")
    private String stateName;
    @JsonProperty("total")
    private int total;
    @JsonProperty("deaths")
    private int deaths;
}
