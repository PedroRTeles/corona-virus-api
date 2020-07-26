package dev.pedroteles.covid.webclient;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.exception.StateNotFoundException;
import dev.pedroteles.covid.factory.StateFactory;
import dev.pedroteles.covid.webclient.entity.in.StateResponseDTO;
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
public class CoronaVirusStateWebClientTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    CoronaVirusStateWebClient webClient;

    @Before
    public void setup() {
        webClient = new CoronaVirusStateWebClient(restTemplate);
    }

    @Test
    public void givenValiStateCodeShouldReturnMockedCore() throws StateNotFoundException {
        //given
        String state = "mg";
        String expectedName = "Minas Gerais";
        String url = "https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/PortalEstado";
        StateResponseDTO[] dto = StateFactory.validDto();

        when(restTemplate.getForEntity(url, StateResponseDTO[].class)).thenReturn(ResponseEntity.ok(dto));

        //when
        StateResponse core = webClient.getStateStatus(state);

        StateResponseDTO minasGeraisDto = dto[2];

        //then
        assertEquals(expectedName, core.getStateName());
        assertEquals(core.getTotalCases(), minasGeraisDto.getTotalSuspects());
        assertEquals(core.getTotalDeaths(), minasGeraisDto.getTotalDeaths());
    }
}
