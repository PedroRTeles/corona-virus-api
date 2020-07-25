package dev.pedroteles.covid.core.usecase;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.gateway.webclient.CoronaVirusCountryWebClientGateway;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CoronaVirusCountryUseCaseTest {

    @Captor
    ArgumentCaptor<String> countryCaptor;

    @Mock
    CoronaVirusCountryWebClientGateway webClient;

    CoronaVirusCountryUseCase useCase;

    @Before
    public void setup() {
        useCase = new CoronaVirusCountryUseCase(webClient);
    }

    @Test
    public void givenValidCountryShouldReturnCore() throws CountryNotFoundException {
        //given
        String country = "br";
        CountryResponse core = CountryFactory.validCore();

        Mockito.when(webClient.getCountryStatus(countryCaptor.capture())).thenReturn(core);

        //when
        CountryResponse status = useCase.getCountryStatus(country);

        //then
        assertEquals(country, countryCaptor.getValue());
        verify(webClient, times(1)).getCountryStatus(anyString());
    }
}
