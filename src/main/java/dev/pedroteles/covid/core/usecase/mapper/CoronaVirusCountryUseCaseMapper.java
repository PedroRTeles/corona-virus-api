package dev.pedroteles.covid.core.usecase.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;

import java.util.List;

public class CoronaVirusCountryUseCaseMapper {
    public static CountryStatus listToCore(List<CountryResponse> responseList) {
        CountryResponse lastRecord = responseList.get(responseList.size() - 1);

        return CountryStatus.builder()
                .active(lastRecord.getActive())
                .confirmed(lastRecord.getConfirmed())
                .countryName(lastRecord.getCountryName())
                .cured(lastRecord.getCured())
                .deaths(lastRecord.getDeath())
                .build();
    }
}