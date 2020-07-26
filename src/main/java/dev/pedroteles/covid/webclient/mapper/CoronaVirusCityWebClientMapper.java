package dev.pedroteles.covid.webclient.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.exception.CityNotFoundException;
import dev.pedroteles.covid.webclient.entity.in.CityResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoronaVirusCityWebClientMapper {
    public static CityResponse dtoToCore(CityResponseDTO[] body, String city) throws CityNotFoundException {
        CityResponseDTO dto = getCityData(body, city);

        if(dto == null)
            throw new CityNotFoundException();

        return CityResponse.builder()
                .cityName(dto.getName())
                .totalCases(dto.getTotalSuspects())
                .totalDeaths(dto.getTotalDeaths())
                .build();
    }

    private static CityResponseDTO getCityData(CityResponseDTO[] body, String city) {
        for (CityResponseDTO cityResponseDTO : body) {
            if (cityResponseDTO.getName() != null && cityResponseDTO.getName().equalsIgnoreCase(city))
                return cityResponseDTO;
        }

        return null;
    }
}
