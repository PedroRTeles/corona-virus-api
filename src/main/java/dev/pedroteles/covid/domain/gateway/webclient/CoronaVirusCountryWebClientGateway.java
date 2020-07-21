package dev.pedroteles.covid.domain.gateway.webclient;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.exception.CountryNotFoundException;

import java.util.List;

public interface CoronaVirusCountryWebClientGateway {
    List<CountryResponse> getCountryStatus(String countryCode) throws CountryNotFoundException;
}
