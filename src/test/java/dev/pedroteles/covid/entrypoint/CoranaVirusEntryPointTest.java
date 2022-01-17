package dev.pedroteles.covid.entrypoint;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusCityUseCaseGateway;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusCountryUseCaseGateway;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusStateUseCaseGateway;
import dev.pedroteles.covid.entrypoint.entity.in.CityStatusBodyDTO;
import dev.pedroteles.covid.entrypoint.entity.out.CityStatusDTO;
import dev.pedroteles.covid.entrypoint.entity.out.CountryStatusDTO;
import dev.pedroteles.covid.entrypoint.entity.out.StateStatusDTO;
import dev.pedroteles.covid.exception.CityNotFoundException;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import dev.pedroteles.covid.exception.StateNotFoundException;
import dev.pedroteles.covid.factory.CityFactory;
import dev.pedroteles.covid.factory.CountryFactory;
import dev.pedroteles.covid.factory.StateFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CoranaVirusEntryPointTest {

    @Captor
    ArgumentCaptor<String> countryCodeCaptor;

    @Captor
    ArgumentCaptor<String> stateCaptor;

    @Captor
    ArgumentCaptor<String> cityCaptor;

    @Mock
    CoronaVirusCountryUseCaseGateway countryUseCase;

    @Mock
    CoronaVirusStateUseCaseGateway stateUseCase;

    @Mock
    CoronaVirusCityUseCaseGateway cityUseCase;

    CoronaVirusEntryPoint entryPoint;

    @Before
    public void setup() {
        this.entryPoint = new CoronaVirusEntryPoint(countryUseCase, stateUseCase, cityUseCase);
    }

    @Test
    public void testParameterPassToCountry() throws CountryNotFoundException {
        //given
        String countryCode = "BR";
        CountryResponse core = CountryFactory.validCore();

        when(countryUseCase.getCountryStatus(countryCodeCaptor.capture())).thenReturn(core);

        //when
        entryPoint.getCountryStatus(countryCode);

        //then
        assertEquals(countryCode, countryCodeCaptor.getValue());
        verify(countryUseCase, Mockito.times(1)).getCountryStatus(anyString());
    }

    @Test
    public void testParameterPassToState() throws StateNotFoundException {
        //given
        String state = "sp";
        StateResponse core = StateFactory.validCore();

        when(stateUseCase.getStateStatus(stateCaptor.capture())).thenReturn(core);

        //when
        entryPoint.getStateStats(state);

        //then
        assertEquals(state, stateCaptor.getValue());
        verify(stateUseCase, Mockito.times(1)).getStateStatus(anyString());
    }

    @Test
    public void testParameterPassToCity() throws CityNotFoundException {
        //given
        CityStatusBodyDTO dto = CityFactory.validRequestDto();
        CityResponse core = CityFactory.validCore();

        when(cityUseCase.getCityStatus(cityCaptor.capture())).thenReturn(core);

        //when
        entryPoint.getCityStatus(dto);

        //then
        assertEquals(dto.getCityName(), cityCaptor.getValue());
        verify(cityUseCase, times(1)).getCityStatus(anyString());
    }

    @Test
    public void whenPassInvalidCountryShouldReturnNotFound() throws CountryNotFoundException {
        String countryCode = "GG";

        when(countryUseCase.getCountryStatus(anyString())).thenThrow(CountryNotFoundException.class);

        //when
        ResponseEntity<CountryStatusDTO> response = entryPoint.getCountryStatus(countryCode);

        //then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void whenPassInvalidStateShouldReturnNotFound() throws StateNotFoundException {
        String state = "ZH";

        when(stateUseCase.getStateStatus(anyString())).thenThrow(StateNotFoundException.class);

        //when
        ResponseEntity<StateStatusDTO> response = entryPoint.getStateStats(state);

        //then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void whenPassInvalidCityShouldReturnNotFound() throws CityNotFoundException {
        CityStatusBodyDTO requestDto = CityFactory.validRequestDto();

        when(cityUseCase.getCityStatus(anyString())).thenThrow(CityNotFoundException.class);

        //when
        ResponseEntity<CityStatusDTO> response = entryPoint.getCityStatus(requestDto);

        //then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
