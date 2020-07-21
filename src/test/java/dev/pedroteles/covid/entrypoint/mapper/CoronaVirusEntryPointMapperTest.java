package dev.pedroteles.covid.entrypoint.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import dev.pedroteles.covid.entrypoint.entity.out.CountryStatusDTO;
import dev.pedroteles.covid.factory.CountryFactory;
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
}
