package dev.pedroteles.covid.webclient;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import dev.pedroteles.covid.factory.CountryFactory;
import dev.pedroteles.covid.webclient.CoronaVirusCountryWebClient;
import dev.pedroteles.covid.webclient.entity.in.CountryResponseDTO;
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
public class CoronaVirusCountryWebClientTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    CoronaVirusCountryWebClient webClient;

    @Before
    public void setup() {
        webClient = new CoronaVirusCountryWebClient(restTemplate);
    }

    @Test
    public void givenValidCountryCodeShouldReturnMockedCore() throws CountryNotFoundException {
        //given
        String country = "br";
        String url = "https://api.covid19api.com/total/country/br";
        CountryResponseDTO[] dto = CountryFactory.validDtoArray();

        when(restTemplate.getForEntity(url, CountryResponseDTO[].class)).thenReturn(ResponseEntity.ok(dto));

        //when
        CountryResponse core = webClient.getCountryStatus(country);

        CountryResponseDTO lastDtoInRespose = dto[dto.length - 1];

        //then
        assertEquals(core.getActive(), lastDtoInRespose.getActive());
        assertEquals(core.getConfirmed(), lastDtoInRespose.getConfirmed());
        assertEquals(core.getCountryName(), lastDtoInRespose.getCountryName());
        assertEquals(core.getCured(), lastDtoInRespose.getCured());
        assertEquals(core.getDeath(), lastDtoInRespose.getDeath());
    }
}
