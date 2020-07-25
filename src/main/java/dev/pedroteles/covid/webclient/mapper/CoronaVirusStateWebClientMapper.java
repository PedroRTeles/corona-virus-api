package dev.pedroteles.covid.webclient.mapper;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.webclient.entity.in.StateResponseDTO;

public class CoronaVirusStateWebClientMapper {
    public static StateResponse dtoToCore(StateResponseDTO body) {
        return StateResponse.builder()
                .stateName(body.getStateName())
                .totalCases(body.getTotalCases())
                .totalDeaths(body.getTotalDeaths())
                .totalSuspects(body.getTotalSuspects())
                .build();
    }
}
