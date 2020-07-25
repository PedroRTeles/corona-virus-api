package dev.pedroteles.covid.webclient.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import dev.pedroteles.covid.webclient.entity.in.CountryResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoronaVirusCountryWebClientMapper {
    public static CountryResponse dtoToCore(CountryResponseDTO[] body) throws CountryNotFoundException {
        if(body.length == 0)
            throw new CountryNotFoundException();

        CountryResponseDTO countryResponseDTO = body[body.length - 1];

        return CountryResponse.builder()
                .countryName(countryResponseDTO.getCountryName())
                .active(countryResponseDTO.getActive())
                .confirmed(countryResponseDTO.getConfirmed())
                .cured(countryResponseDTO.getCured())
                .death(countryResponseDTO.getDeath())
                .build();
    }
}
