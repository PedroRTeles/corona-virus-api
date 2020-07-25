package dev.pedroteles.covid.domain.gateway.webclient;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;

public interface CoronaVirusStateWebClientGateway {
    StateResponse getStateStatus(String state);
}
