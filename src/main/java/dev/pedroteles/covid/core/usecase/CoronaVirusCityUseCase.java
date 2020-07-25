package dev.pedroteles.covid.core.usecase;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.domain.gateway.CoronaVirusCityWebClientGateway;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusCityUseCaseGateway;
import dev.pedroteles.covid.exception.CityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoronaVirusCityUseCase implements CoronaVirusCityUseCaseGateway {

    private CoronaVirusCityWebClientGateway webClient;

    @Autowired
    public CoronaVirusCityUseCase(CoronaVirusCityWebClientGateway webClient) {
        this.webClient = webClient;
    }

    @Override
    public CityResponse getCityStatus(String city) throws CityNotFoundException {
        return webClient.getCityStatus(city);
    }
}
