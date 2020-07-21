package dev.pedroteles.covid.webclient;

import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.gateway.webclient.CoronaVirusCountryWebClientGateway;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import dev.pedroteles.covid.webclient.entity.in.CountryResponseDTO;
import dev.pedroteles.covid.webclient.mapper.CoronaVirusCountryWebClientMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CoronaVirusCountryWebClient implements CoronaVirusCountryWebClientGateway {

    @Override
    public List<CountryResponse> getCountryStatus(String countryCode) throws CountryNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "https://api.covid19api.com/total/country/";
        baseUrl = baseUrl.concat(countryCode);

        ResponseEntity<CountryResponseDTO[]> response = restTemplate.getForEntity(baseUrl, CountryResponseDTO[].class);

        if(response.getBody() != null && response.getBody().length == 0)
            throw new CountryNotFoundException();

        return CoronaVirusCountryWebClientMapper.dtoToCore(response.getBody());
    }
}
