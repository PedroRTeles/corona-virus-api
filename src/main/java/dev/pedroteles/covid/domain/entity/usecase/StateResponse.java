package dev.pedroteles.covid.domain.entity.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StateResponse {
    private String stateName;
    private int totalCases;
    private int totalDeaths;
}
