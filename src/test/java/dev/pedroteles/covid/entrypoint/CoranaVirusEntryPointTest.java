package dev.pedroteles.covid.entrypoint;

import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusCountryUseCaseGateway;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import dev.pedroteles.covid.factory.CountryFactory;
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
    CoronaVirusCountryUseCaseGateway useCase;

    CoronaVirusEntryPoint entryPoint;

    @Before
    public void setup() {
        this.entryPoint = new CoronaVirusEntryPoint(useCase);
    }

    @Test
    public void testParameterPassToCountry() throws CountryNotFoundException {
        //given
        String countryCode = "BR";
        CountryStatus core = CountryFactory.validCore();

        Mockito.when(useCase.getCountryStatus(countryCodeCaptor.capture())).thenReturn(core);

        //when
        entryPoint.getCountryStatus(countryCode);

        //then
        assertEquals(countryCode, countryCodeCaptor.getValue());
        Mockito.verify(useCase, Mockito.times(1)).getCountryStatus(anyString());
    }
}
