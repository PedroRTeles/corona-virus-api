package dev.pedroteles.covid.core.usecase;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.domain.gateway.webclient.CoronaVirusStateWebClientGateway;
import dev.pedroteles.covid.exception.StateNotFoundException;
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

@RunWith(MockitoJUnitRunner.class)
public class CoronaVirusStateUseCaseTest {

    @Mock
    CoronaVirusStateWebClientGateway webClient;

    @Captor
    ArgumentCaptor<String> stateCaptor;

    CoronaVirusStateUseCase useCase;

    @Before
    public void setup() {
        useCase = new CoronaVirusStateUseCase(webClient);
    }

    @Test
    public void givenValidStateShouldReturnCore() throws StateNotFoundException {
        //given
        StateResponse core = StateFactory.validCore();
        String state = "sp";

        Mockito.when(webClient.getStateStatus(stateCaptor.capture())).thenReturn(core);

        //when
        StateResponse status = useCase.getStateStatus(state);

        //then
        assertEquals(status.getTotalDeaths(), core.getTotalDeaths());
        assertEquals(status.getTotalCases(), core.getTotalCases());
        assertEquals(status.getStateName(), core.getStateName());
        assertEquals(stateCaptor.getValue(), state);
    }
}
