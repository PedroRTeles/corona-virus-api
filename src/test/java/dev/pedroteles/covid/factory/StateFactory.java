package dev.pedroteles.covid.factory;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.webclient.entity.in.StateResponseDTO;
import org.jeasy.random.EasyRandom;

public class StateFactory {
    public static StateResponse validCore() {
        return new EasyRandom().nextObject(StateResponse.class);
    }

    public static StateResponseDTO[] validDto() {
        StateResponseDTO[] responses = {
                new StateResponseDTO("SP", 1200, 2000),
                new StateResponseDTO("RJ", 2500, 4000),
                new StateResponseDTO("MG", 100, 3000)
        };

        return responses;
    }

}
