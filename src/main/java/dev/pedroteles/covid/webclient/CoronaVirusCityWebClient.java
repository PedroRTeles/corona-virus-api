package dev.pedroteles.covid.webclient;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.domain.gateway.CoronaVirusCityWebClientGateway;
import dev.pedroteles.covid.exception.CityNotFoundException;
import dev.pedroteles.covid.webclient.entity.in.CityResponseDTO;
import dev.pedroteles.covid.webclient.mapper.CoronaVirusCityWebClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoronaVirusCityWebClient implements CoronaVirusCityWebClientGateway {

    private final RestTemplate restTemplate;

    @Autowired
    public CoronaVirusCityWebClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CityResponse getCityStatus(String city) throws CityNotFoundException {
        String baseUrl = "https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/PortalMunicipio";

        ResponseEntity<CityResponseDTO[]> response = restTemplate.getForEntity(baseUrl, CityResponseDTO[].class);

        if(response.getBody() != null) {
            CityResponse core = CoronaVirusCityWebClientMapper.dtoToCore(response.getBody(), city);

            if(core.getCityName() != null)
                return core;
        }

        throw new CityNotFoundException();

    }
}
