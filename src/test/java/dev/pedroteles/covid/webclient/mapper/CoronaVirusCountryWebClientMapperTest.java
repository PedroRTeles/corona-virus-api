package dev.pedroteles.covid.webclient.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import dev.pedroteles.covid.factory.CountryFactory;
import dev.pedroteles.covid.webclient.entity.in.CountryResponseDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CoronaVirusCountryWebClientMapperTest {

    @Test
    public void testArrayDtoToCore() throws CountryNotFoundException {
        //given
        CountryResponseDTO[] dtoArray = CountryFactory.validDtoArray();

        //when
        CountryResponse core = CoronaVirusCountryWebClientMapper.dtoToCore(dtoArray);

        //then
        CountryResponseDTO lastDto = dtoArray[dtoArray.length - 1];

        assertEquals(core.getActive(), lastDto.getActive());
        assertEquals(core.getConfirmed(), lastDto.getConfirmed());
        assertEquals(core.getCountryName(), lastDto.getCountryName());
        assertEquals(core.getCured(), lastDto.getCured());
        assertEquals(core.getDeath(), lastDto.getDeath());
    }


    @Test(expected = CountryNotFoundException.class)
    public void testDtoToCoreInvalidCountry() throws CountryNotFoundException {
        //given
        CountryResponseDTO[] dto = CountryFactory.invalidCountryDto();

        //when
        CoronaVirusCountryWebClientMapper.dtoToCore(dto);

        //then
        fail();
    }
}
