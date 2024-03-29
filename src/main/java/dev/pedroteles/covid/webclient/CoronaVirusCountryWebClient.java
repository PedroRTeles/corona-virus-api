package dev.pedroteles.covid.webclient;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.gateway.webclient.CoronaVirusCountryWebClientGateway;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import dev.pedroteles.covid.webclient.entity.in.CountryResponseDTO;
import dev.pedroteles.covid.webclient.mapper.CoronaVirusCountryWebClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoronaVirusCountryWebClient implements CoronaVirusCountryWebClientGateway {

    private final RestTemplate restTemplate;

    @Autowired
    public CoronaVirusCountryWebClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CountryResponse getCountryStatus(String countryCode) throws CountryNotFoundException {
        String baseUrl = "https://api.covid19api.com/total/country/";
        baseUrl = baseUrl.concat(countryCode);

        ResponseEntity<CountryResponseDTO[]> response = restTemplate.getForEntity(baseUrl, CountryResponseDTO[].class);

        if(response.getBody() != null)
            return CoronaVirusCountryWebClientMapper.dtoToCore(response.getBody());

        throw new CountryNotFoundException();
    }
}
