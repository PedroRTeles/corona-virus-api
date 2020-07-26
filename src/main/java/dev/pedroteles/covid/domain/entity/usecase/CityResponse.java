package dev.pedroteles.covid.domain.entity.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityResponse {
    private String cityName;
    private int totalCases;
    private int totalDeaths;
}
