package dev.pedroteles.covid.domain.gateway.webclient;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.exception.StateNotFoundException;

public interface CoronaVirusStateWebClientGateway {
    StateResponse getStateStatus(String state) throws StateNotFoundException;
}
