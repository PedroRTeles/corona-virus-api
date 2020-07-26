package dev.pedroteles.covid.webclient;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.exception.CityNotFoundException;
import dev.pedroteles.covid.factory.CityFactory;
import dev.pedroteles.covid.webclient.entity.in.CityResponseDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoronaVirusCityWebClientTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    CoronaVirusCityWebClient webClient;

    @Before
    public void setup() {
        webClient = new CoronaVirusCityWebClient(restTemplate);
    }

    @Test
    public void givenValidCityNameShouldReturnMockedCore() throws CityNotFoundException {
        //given
        String city = "são paulo";
        String url = "https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/PortalMunicipio";
        CityResponseDTO[] dto = CityFactory.validDto();

        when(restTemplate.getForEntity(url, CityResponseDTO[].class)).thenReturn(ResponseEntity.ok(dto));

        //when
        CityResponse core = webClient.getCityStatus(city);

        CityResponseDTO saoPauloDto = dto[0];

        //then
        assertEquals(core.getCityName(), saoPauloDto.getName());
        assertEquals(core.getTotalCases(), saoPauloDto.getTotalSuspects());
        assertEquals(core.getTotalDeaths(), saoPauloDto.getTotalDeaths());
    }
}
