package dev.pedroteles.covid.core.usecase;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusCountryUseCaseGateway;
import dev.pedroteles.covid.domain.gateway.webclient.CoronaVirusCountryWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoronaVirusCountryUseCase implements CoronaVirusCountryUseCaseGateway {

    private CoronaVirusCountryWebClient webClient;

    @Autowired
    public CoronaVirusCountryUseCase(CoronaVirusCountryWebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public CountryStatus getCountryStatus(String countryCode) {
        List<CountryResponse> responseList = webClient.getCountryStatus(countryCode);

        return CoronaVirusCountryUseCaseMapper.listToCore(responseList);
    }
}
