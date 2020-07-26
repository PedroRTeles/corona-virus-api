package dev.pedroteles.covid.entrypoint.mapper;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.entrypoint.entity.in.CityStatusBodyDTO;
import dev.pedroteles.covid.entrypoint.entity.out.CityStatusDTO;
import dev.pedroteles.covid.entrypoint.entity.out.CountryStatusDTO;
import dev.pedroteles.covid.entrypoint.entity.out.StateStatusDTO;
import dev.pedroteles.covid.factory.CityFactory;
import dev.pedroteles.covid.factory.CountryFactory;
import dev.pedroteles.covid.factory.StateFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoronaVirusEntryPointMapperTest {

    @Test
    public void testCountryCoreToDto() {
        //given
        CountryResponse core = CountryFactory.validCore();

        //when
        CountryStatusDTO dto = CoronaVirusEntryPointMapper.coreToDto(core);

        //then
        assertEquals(dto.getConfirmed(), core.getConfirmed());
        assertEquals(dto.getCountryName(), core.getCountryName());
        assertEquals(dto.getCured(), core.getCured());
        assertEquals(dto.getDeaths(), core.getDeath());
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
        assertEquals(dto.getTotal(), core.getTotalCases());
    }

    @Test
    public void testCityDtoToCore() {
        //given
        CityStatusBodyDTO dto = CityFactory.validRequestDto();

        //when
        String city = CoronaVirusEntryPointMapper.cityDtoToCore(dto);

        //then
        assertEquals(city, dto.getCityName());
    }

    @Test
    public void testCityCoreToDto() {
        //given
        CityResponse core = CityFactory.validCore();

        //when
        CityStatusDTO dto = CoronaVirusEntryPointMapper.cityCoreToDto(core);

        //then
        assertEquals(dto.getDeaths(), core.getTotalDeaths());
        assertEquals(dto.getCityName(), core.getCityName());
        assertEquals(dto.getTotal(), core.getTotalCases());
    }
}
