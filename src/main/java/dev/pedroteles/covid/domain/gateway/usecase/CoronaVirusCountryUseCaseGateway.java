package dev.pedroteles.covid.domain.gateway.usecase;

import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import dev.pedroteles.covid.exception.CountryNotFoundException;

public interface CoronaVirusCountryUseCaseGateway {
    CountryStatus getCountryStatus(String countryCode) throws CountryNotFoundException;
}
