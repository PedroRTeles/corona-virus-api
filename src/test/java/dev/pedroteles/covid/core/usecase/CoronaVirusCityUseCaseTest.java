package dev.pedroteles.covid.core.usecase;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.domain.gateway.CoronaVirusCityWebClientGateway;
import dev.pedroteles.covid.exception.CityNotFoundException;
import dev.pedroteles.covid.factory.CityFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CoronaVirusCityUseCaseTest {

    @Mock
    CoronaVirusCityWebClientGateway webClient;

    @Captor
    ArgumentCaptor<String> cityCaptor;

    CoronaVirusCityUseCase useCase;

    @Before
    public void setup() {
        useCase = new CoronaVirusCityUseCase(webClient);
    }

    @Test
    public void givenValidCityShouldReturnCore() throws CityNotFoundException {
        //given
        CityResponse core = CityFactory.validCore();
        String city = "são paulo";

        Mockito.when(webClient.getCityStatus(cityCaptor.capture())).thenReturn(core);

        //when
        CityResponse status = useCase.getCityStatus(city);

        //then
        assertEquals(status.getTotalDeaths(), core.getTotalDeaths());
        assertEquals(status.getTotalCases(), core.getTotalCases());
        assertEquals(status.getCityName(), core.getCityName());
        assertEquals(cityCaptor.getValue(), city);
    }
}
