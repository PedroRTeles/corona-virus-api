package dev.pedroteles.covid.factory;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import org.jeasy.random.EasyRandom;

import java.util.Arrays;
import java.util.List;

public class CountryFactory {
    public static CountryStatus validCore() {
        return new EasyRandom().nextObject(CountryStatus.class);
    }

    public static List<CountryResponse> validCountryResponseList() {
        CountryResponse response1 = CountryResponse.builder()
                .confirmed(3)
                .cured(0)
                .countryName("Brazil")
                .active(3)
                .death(0)
                .build();

        CountryResponse response2 = CountryResponse.builder()
                .confirmed(6)
                .cured(1)
                .countryName("Brazil")
                .active(4)
                .death(1)
                .build();

        CountryResponse response3 = CountryResponse.builder()
                .confirmed(10)
                .cured(5)
                .countryName("Brazil")
                .active(3)
                .death(2).build();

        return Arrays.asList(response1, response2, response3);
    }
}