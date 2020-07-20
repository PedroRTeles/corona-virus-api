package dev.pedroteles.covid.entrypoint;

import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusUseCaseGateway;
import dev.pedroteles.covid.entrypoint.entity.out.CountryStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoronaVirusEntryPoint {

    private CoronaVirusUseCaseGateway useCase;

    @Autowired
    public CoronaVirusEntryPoint(CoronaVirusUseCaseGateway useCase) {
        this.useCase = useCase;
    }

    public ResponseEntity<CountryStatusDTO> getCountryStatus(String country) {
        useCase.getCountryStatus(country);
        return ResponseEntity.ok(new CountryStatusDTO());
    }
}
