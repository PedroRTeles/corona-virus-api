package dev.pedroteles.covid.webclient.mapper;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.factory.StateFactory;
import dev.pedroteles.covid.webclient.entity.in.StateResponseDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoronaVirusStateWebClientMapperTest {

    @Test
    public void testDtoToCore() {
        //given
        StateResponseDTO dto = StateFactory.validDto();

        //when
        StateResponse core = CoronaVirusStateWebClientMapper.dtoToCore(dto);

        //then
        assertEquals(core.getStateName(), dto.getStateName());
        assertEquals(core.getTotalCases(), dto.getTotalCases());
        assertEquals(core.getTotalDeaths(), dto.getTotalDeaths());
        assertEquals(core.getTotalSuspects(), dto.getTotalSuspects());
    }
}
