package dev.pedroteles.covid.webclient.mapper;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.exception.StateNotFoundException;
import dev.pedroteles.covid.factory.StateFactory;
import dev.pedroteles.covid.webclient.entity.in.StateResponseDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CoronaVirusStateWebClientMapperTest {

    @Test
    public void testDtoToCore() throws StateNotFoundException {
        //given
        StateResponseDTO[] dto = StateFactory.validDto();
        String state = "sp";
        String expectedStateName = "São Paulo";

        //when
        StateResponse core = CoronaVirusStateWebClientMapper.dtoToCore(dto, state);

        //then
        assertEquals(expectedStateName, core.getStateName());
        assertEquals(core.getTotalCases(), dto[0].getTotalSuspects());
        assertEquals(core.getTotalDeaths(), dto[0].getTotalDeaths());
    }

    @Test(expected = StateNotFoundException.class)
    public void testDtoToCoreInvalidState() throws StateNotFoundException {
        //given
        StateResponseDTO[] dto = StateFactory.validDto();
        String state = "gg";

        //when
        CoronaVirusStateWebClientMapper.dtoToCore(dto, state);

        //then
        fail();
    }
}
