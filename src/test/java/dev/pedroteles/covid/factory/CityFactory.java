package dev.pedroteles.covid.factory;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.webclient.entity.in.CityResponseDTO;
import org.jeasy.random.EasyRandom;

public class CityFactory {
    public static CityResponseDTO[] validDto() {
        CityResponseDTO[] responses = {
                new CityResponseDTO("São Paulo", 1200, 2000),
                new CityResponseDTO("Rio de Janeiro", 2500, 4000),
                new CityResponseDTO("Uberlândia", 100, 3000)
        };

        return responses;
    }

    public static CityResponse validCore() {
        return new EasyRandom().nextObject(CityResponse.class);
    }
}
