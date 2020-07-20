package dev.pedroteles.covid.factory;

import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import org.jeasy.random.EasyRandom;

public class CountryFactory {
    public static CountryStatus validCore() {
        return new EasyRandom().nextObject(CountryStatus.class);
    }
}
