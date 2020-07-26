package dev.pedroteles.covid.domain.gateway.webclient;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.exception.CountryNotFoundException;

public interface CoronaVirusCountryWebClientGateway {
    CountryResponse getCountryStatus(String countryCode) throws CountryNotFoundException;
}
