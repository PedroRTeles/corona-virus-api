package dev.pedroteles.covid.domain.gateway.usecase;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;

public interface CoronaVirusStateUseCaseGateway {
    StateResponse getStateStatus(String state);
}
