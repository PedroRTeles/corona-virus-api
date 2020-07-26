package dev.pedroteles.covid.domain.gateway.usecase;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.exception.StateNotFoundException;

public interface CoronaVirusStateUseCaseGateway {
    StateResponse getStateStatus(String state) throws StateNotFoundException;
}
