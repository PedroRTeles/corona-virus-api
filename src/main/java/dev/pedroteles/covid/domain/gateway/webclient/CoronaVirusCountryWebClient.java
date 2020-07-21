package dev.pedroteles.covid.domain.gateway.webclient;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;

import java.util.List;

public interface CoronaVirusCountryWebClient {
    List<CountryResponse> getCountryStatus(String countryCode);
}
