package dev.pedroteles.covid.core.usecase;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import dev.pedroteles.covid.domain.gateway.webclient.CoronaVirusCountryWebClientGateway;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import dev.pedroteles.covid.factory.CountryFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class CoronaVirusCountryUseCaseTest {

    @Mock
    CoronaVirusCountryWebClientGateway webClient;

    CoronaVirusCountryUseCase useCase;

    @Before
    public void setup() {
        useCase = new CoronaVirusCountryUseCase(webClient);
    }

    @Test
    public void givenListOfDataShouldReturnCore() throws CountryNotFoundException {
        //given
        List<CountryResponse> countryResponseList = CountryFactory.validCountryResponseList();

        Mockito.when(webClient.getCountryStatus(anyString())).thenReturn(countryResponseList);

        //when
        CountryStatus status = useCase.getCountryStatus(anyString());

        //then
        assertEquals(10, status.getConfirmed());
        assertEquals(2, status.getDeaths());
        assertEquals(5, status.getCured());
        assertEquals(3, status.getActive());
    }
}
