package dev.pedroteles.covid.webclient.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.webclient.entity.in.CountryResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoronaVirusCountryWebClientMapper {
    public static List<CountryResponse> dtoToCore(CountryResponseDTO[] body) {
        List<CountryResponse> countryResponseList = new ArrayList<>();

        for (CountryResponseDTO countryResponseDTO : body) {
            CountryResponse country = CountryResponse.builder()
                    .countryName(countryResponseDTO.getCountryName())
                    .active(countryResponseDTO.getActive())
                    .confirmed(countryResponseDTO.getConfirmed())
                    .cured(countryResponseDTO.getCured())
                    .death(countryResponseDTO.getDeath())
                    .build();

            countryResponseList.add(country);
        }

        return countryResponseList;
    }
}
