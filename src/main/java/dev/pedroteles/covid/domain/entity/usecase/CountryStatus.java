package dev.pedroteles.covid.domain.entity.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryStatus {
    private String countryName;
    private int total;
    private int deaths;
    private int cured;
    private int confirmed;
}
