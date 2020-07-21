package dev.pedroteles.covid.domain.gateway.usecase;

import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;

public interface CoronaVirusCountryUseCaseGateway {
    CountryStatus getCountryStatus(String countryCode);
}
