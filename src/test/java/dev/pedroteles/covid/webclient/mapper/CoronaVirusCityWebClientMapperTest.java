package dev.pedroteles.covid.webclient.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.exception.CityNotFoundException;
import dev.pedroteles.covid.factory.CityFactory;
import dev.pedroteles.covid.webclient.entity.in.CityResponseDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CoronaVirusCityWebClientMapperTest {

    @Test
    public void testDtoToCore() throws CityNotFoundException {
        //given
        CityResponseDTO[] dto = CityFactory.validDto();
        String city = "são paulo";

        //when
        CityResponse core = CoronaVirusCityWebClientMapper.dtoToCore(dto, city);

        //then
        assertEquals(core.getCityName(), dto[0].getName());
        assertEquals(core.getTotalCases(), dto[0].getTotalSuspects());
        assertEquals(core.getTotalDeaths(), dto[0].getTotalDeaths());
    }

    @Test(expected = CityNotFoundException.class)
    public void testDtoToCoreInvalidState() throws CityNotFoundException {
        //given
        CityResponseDTO[] dto = CityFactory.validDto();
        String city = "cidade não existente";

        //when
        CoronaVirusCityWebClientMapper.dtoToCore(dto, city);

        //then
        fail();
    }
}
