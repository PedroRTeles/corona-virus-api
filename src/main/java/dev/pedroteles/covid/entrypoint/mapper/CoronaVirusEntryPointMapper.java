package dev.pedroteles.covid.entrypoint.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.entrypoint.entity.in.CityStatusBodyDTO;
import dev.pedroteles.covid.entrypoint.entity.out.CityStatusDTO;
import dev.pedroteles.covid.entrypoint.entity.out.CountryStatusDTO;
import dev.pedroteles.covid.entrypoint.entity.out.StateStatusDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoronaVirusEntryPointMapper {
    public static CountryStatusDTO coreToDto(CountryResponse countryStatus) {
        return CountryStatusDTO.builder()
                .confirmed(countryStatus.getConfirmed())
                .countryName(countryStatus.getCountryName())
                .cured(countryStatus.getCured())
                .deaths(countryStatus.getDeath())
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

    public static String cityDtoToCore(CityStatusBodyDTO bodyDTO) {
        return bodyDTO.getCityName();
    }

    public static CityStatusDTO cityCoreToDto(CityResponse core) {
        return CityStatusDTO.builder()
                .cityName(core.getCityName())
                .deaths(core.getTotalDeaths())
                .total(core.getTotalCases())
                .build();
    }
}
