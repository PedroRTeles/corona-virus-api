package dev.pedroteles.covid.factory;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.webclient.entity.in.StateResponseDTO;
import org.jeasy.random.EasyRandom;

public class StateFactory {
    public static StateResponse validCore() {
        return new EasyRandom().nextObject(StateResponse.class);
    }

    public static StateResponseDTO validDto() {
        return new EasyRandom().nextObject(StateResponseDTO.class);
    }
}
