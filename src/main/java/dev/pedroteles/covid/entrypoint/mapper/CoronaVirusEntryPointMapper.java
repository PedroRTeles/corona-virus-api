package dev.pedroteles.covid.entrypoint.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.entrypoint.entity.out.CountryStatusDTO;
import dev.pedroteles.covid.entrypoint.entity.out.StateStatusDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoronaVirusEntryPointMapper {
    public static CountryStatusDTO coreToDto(CountryStatus countryStatus) {
        return CountryStatusDTO.builder()
                .confirmed(countryStatus.getConfirmed())
                .countryName(countryStatus.getCountryName())
                .cured(countryStatus.getCured())
                .deaths(countryStatus.getDeaths())
                .total(countryStatus.getActive())
                .build();
    }

    public static StateStatusDTO stateCoreToDto(StateResponse stateStatus) {
        return StateStatusDTO.builder()
                .deaths(stateStatus.getTotalDeaths())
                .stateName(stateStatus.getStateName())
                .total(stateStatus.getTotalCases())
                .build();
    }
}
