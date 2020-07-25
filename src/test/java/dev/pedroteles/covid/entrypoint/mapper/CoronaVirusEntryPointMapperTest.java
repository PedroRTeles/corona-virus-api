package dev.pedroteles.covid.entrypoint.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.entrypoint.entity.out.CountryStatusDTO;
import dev.pedroteles.covid.entrypoint.entity.out.StateStatusDTO;
import dev.pedroteles.covid.factory.CountryFactory;
import dev.pedroteles.covid.factory.StateFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoronaVirusEntryPointMapperTest {

    @Test
    public void testCountryCoreToDto() {
        //given
        CountryStatus core = CountryFactory.validCore();

        //when
        CountryStatusDTO dto = CoronaVirusEntryPointMapper.coreToDto(core);

        //then
        assertEquals(dto.getConfirmed(), core.getConfirmed());
        assertEquals(dto.getCountryName(), core.getCountryName());
        assertEquals(dto.getCured(), core.getCured());
        assertEquals(dto.getDeaths(), core.getDeaths());
        assertEquals(dto.getTotal(), core.getActive());
    }

    @Test
    public void testStateCoreToDto() {
        //given
        StateResponse core = StateFactory.validCore();

        //when
        StateStatusDTO dto = CoronaVirusEntryPointMapper.stateCoreToDto(core);

        //then
        assertEquals(dto.getDeaths(), core.getTotalDeaths());
        assertEquals(dto.getStateName(), core.getStateName());
        assertEquals(dto.getSuspects(), core.getTotalSuspects());
        assertEquals(dto.getTotal(), core.getTotalCases());
    }
}
