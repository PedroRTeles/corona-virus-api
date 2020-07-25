package dev.pedroteles.covid.entrypoint;

import dev.pedroteles.covid.domain.entity.usecase.CountryStatus;
import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusCountryUseCaseGateway;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusStateUseCaseGateway;
import dev.pedroteles.covid.entrypoint.entity.out.CountryStatusDTO;
import dev.pedroteles.covid.entrypoint.entity.out.StateStatusDTO;
import dev.pedroteles.covid.entrypoint.mapper.CoronaVirusEntryPointMapper;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoronaVirusEntryPoint {

    private final CoronaVirusCountryUseCaseGateway countryUseCase;
    private final CoronaVirusStateUseCaseGateway stateUseCase;

    @Autowired
    public CoronaVirusEntryPoint(CoronaVirusCountryUseCaseGateway countryUseCase,
                                 CoronaVirusStateUseCaseGateway stateUseCase) {
        this.countryUseCase = countryUseCase;
        this.stateUseCase = stateUseCase;
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<CountryStatusDTO> getCountryStatus(@PathVariable("country") String country) {
        try {
            CountryStatus status = countryUseCase.getCountryStatus(country);

            return ResponseEntity.ok(CoronaVirusEntryPointMapper.coreToDto(status));
        } catch (CountryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<StateStatusDTO> getStateStats(@PathVariable("state") String state) {
        StateResponse core = stateUseCase.getStateStatus(state);

        return ResponseEntity.ok(CoronaVirusEntryPointMapper.stateCoreToDto(core));
    }
}
