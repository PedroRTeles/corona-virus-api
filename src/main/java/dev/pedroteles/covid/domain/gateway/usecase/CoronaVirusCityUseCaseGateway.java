package dev.pedroteles.covid.domain.gateway.usecase;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.exception.CityNotFoundException;

public interface CoronaVirusCityUseCaseGateway {
    CityResponse getCityStatus(String city) throws CityNotFoundException;
}
