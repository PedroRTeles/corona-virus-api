package dev.pedroteles.covid.webclient;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.domain.gateway.webclient.CoronaVirusStateWebClientGateway;
import dev.pedroteles.covid.webclient.entity.in.StateResponseDTO;
import dev.pedroteles.covid.webclient.mapper.CoronaVirusStateWebClientMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoronaVirusStateWebClient implements CoronaVirusStateWebClientGateway {

    @Override
    public StateResponse getStateStatus(String state) {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/";
        baseUrl = baseUrl.concat(state);

        ResponseEntity<StateResponseDTO> response = restTemplate.getForEntity(baseUrl, StateResponseDTO.class);

        return CoronaVirusStateWebClientMapper.dtoToCore(response.getBody());
    }
}
