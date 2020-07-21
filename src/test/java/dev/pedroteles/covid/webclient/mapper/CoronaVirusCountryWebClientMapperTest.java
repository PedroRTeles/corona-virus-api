package dev.pedroteles.covid.webclient.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.factory.CountryFactory;
import dev.pedroteles.covid.webclient.entity.in.CountryResponseDTO;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CoronaVirusCountryWebClientMapperTest {

    @Test
    public void testArrayDtoToCore() {
        //given
        CountryResponseDTO[] dtoArray = CountryFactory.validDtoArray();

        //when
        List<CountryResponse> coreList = CoronaVirusCountryWebClientMapper.dtoToCore(dtoArray);

        //then
        CountryResponse firstCore = coreList.get(0);
        CountryResponseDTO firstDto = dtoArray[0];

        assertEquals(coreList.size(), dtoArray.length);
        assertEquals(firstCore.getActive(), firstDto.getActive());
        assertEquals(firstCore.getConfirmed(), firstDto.getConfirmed());
        assertEquals(firstCore.getCountryName(), firstDto.getCountryName());
        assertEquals(firstCore.getCured(), firstDto.getCured());
        assertEquals(firstCore.getDeath(), firstDto.getDeath());
    }
}
