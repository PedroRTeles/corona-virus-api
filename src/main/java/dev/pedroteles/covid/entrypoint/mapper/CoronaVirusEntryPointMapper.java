package dev.pedroteles.covid.entrypoint.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import dev.pedroteles.covid.entrypoint.entity.out.CountryStatusDTO;

public class CoronaVirusEntryPointMapper {
    public static CountryStatusDTO coreToDto(CountryStatus countryStatus) {
        return CountryStatusDTO.builder()
                .confirmed(countryStatus.getConfirmed())
                .countryName(countryStatus.getCountryName())
                .cured(countryStatus.getCured())
                .deaths(countryStatus.getDeaths())
                .total(countryStatus.getTotal())
                .build();
    }
}
