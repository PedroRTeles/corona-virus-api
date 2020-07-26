package dev.pedroteles.covid.core.usecase;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusCountryUseCaseGateway;
import dev.pedroteles.covid.domain.gateway.webclient.CoronaVirusCountryWebClientGateway;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoronaVirusCountryUseCase implements CoronaVirusCountryUseCaseGateway {

    private CoronaVirusCountryWebClientGateway webClient;

    @Autowired
    public CoronaVirusCountryUseCase(CoronaVirusCountryWebClientGateway webClient) {
        this.webClient = webClient;
    }

    @Override
    public CountryResponse getCountryStatus(String countryCode) throws CountryNotFoundException {
        return webClient.getCountryStatus(countryCode);
    }
}
