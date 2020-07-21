package dev.pedroteles.covid.entrypoint;

import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusCountryUseCaseGateway;
import dev.pedroteles.covid.entrypoint.entity.out.CountryStatusDTO;
import dev.pedroteles.covid.entrypoint.mapper.CoronaVirusEntryPointMapper;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoronaVirusEntryPoint {

    private final CoronaVirusCountryUseCaseGateway useCase;

    @Autowired
    public CoronaVirusEntryPoint(CoronaVirusCountryUseCaseGateway useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<CountryStatusDTO> getCountryStatus(@PathVariable("country") String country) {
        try {
            CountryStatus status = useCase.getCountryStatus(country);

            return ResponseEntity.ok(CoronaVirusEntryPointMapper.coreToDto(status));
        } catch (CountryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
