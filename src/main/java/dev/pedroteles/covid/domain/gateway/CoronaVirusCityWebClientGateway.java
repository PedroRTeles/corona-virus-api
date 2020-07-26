package dev.pedroteles.covid.domain.gateway;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.exception.CityNotFoundException;

public interface CoronaVirusCityWebClientGateway {
    CityResponse getCityStatus(String city) throws CityNotFoundException;
}
