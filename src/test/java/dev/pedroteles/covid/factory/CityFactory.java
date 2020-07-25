package dev.pedroteles.covid.factory;

import dev.pedroteles.covid.webclient.entity.in.CityResponseDTO;

public class CityFactory {
    public static CityResponseDTO[] validDto() {
        CityResponseDTO[] responses = {
                new CityResponseDTO("São Paulo", 1200, 2000),
                new CityResponseDTO("Rio de Janeiro", 2500, 4000),
                new CityResponseDTO("Uberlândia", 100, 3000)
        };

        return responses;
    }
}
