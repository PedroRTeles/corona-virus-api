package dev.pedroteles.covid.core.usecase;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusStateUseCaseGateway;
import dev.pedroteles.covid.domain.gateway.webclient.CoronaVirusStateWebClientGateway;
import dev.pedroteles.covid.exception.StateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoronaVirusStateUseCase implements CoronaVirusStateUseCaseGateway {

    private CoronaVirusStateWebClientGateway webClient;

    @Autowired
    public CoronaVirusStateUseCase(CoronaVirusStateWebClientGateway webClient) {
        this.webClient = webClient;
    }

    @Override
    public StateResponse getStateStatus(String state) throws StateNotFoundException {
        return webClient.getStateStatus(state);
    }
}
