package dev.pedroteles.covid.domain.gateway.usecase;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.exception.CountryNotFoundException;

public interface CoronaVirusCountryUseCaseGateway {
    CountryResponse getCountryStatus(String countryCode) throws CountryNotFoundException;
}
