package dev.pedroteles.covid.entrypoint;

import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusCountryUseCaseGateway;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusStateUseCaseGateway;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import dev.pedroteles.covid.exception.StateNotFoundException;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class CoranaVirusEntryPointTest {

    @Captor
    ArgumentCaptor<String> countryCodeCaptor;

    @Mock
    CoronaVirusCountryUseCaseGateway countryUseCase;

    @Mock
    CoronaVirusStateUseCaseGateway stateUseCase;

    CoronaVirusEntryPoint entryPoint;

    @Before
    public void setup() {
        this.entryPoint = new CoronaVirusEntryPoint(countryUseCase, stateUseCase);
    }

    @Test
    public void testParameterPassToCountry() throws CountryNotFoundException {
        //given
        String countryCode = "BR";
        CountryStatus core = CountryFactory.validCore();

        Mockito.when(countryUseCase.getCountryStatus(countryCodeCaptor.capture())).thenReturn(core);

        //when
        entryPoint.getCountryStatus(countryCode);

        //then
        assertEquals(countryCode, countryCodeCaptor.getValue());
        Mockito.verify(countryUseCase, Mockito.times(1)).getCountryStatus(anyString());
    }

    @Test
    public void testParameterPassToState() throws StateNotFoundException {
        //given
        String state = "sp";
        StateResponse core = StateFactory.validCore();

        Mockito.when(stateUseCase.getStateStatus(countryCodeCaptor.capture())).thenReturn(core);

        //when
        entryPoint.getStateStats(state);

        //then
        assertEquals(state, countryCodeCaptor.getValue());
        Mockito.verify(stateUseCase, Mockito.times(1)).getStateStatus(anyString());
    }
}
