package dev.pedroteles.covid.domain.entity.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryResponse {
    private String countryName;
    private int active;
    private int confirmed;
    private int death;
    private int cured;
}
