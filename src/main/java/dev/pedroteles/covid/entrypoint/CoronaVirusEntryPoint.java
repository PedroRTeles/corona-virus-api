package dev.pedroteles.covid.entrypoint;

import dev.pedroteles.covid.domain.entity.usecase.CityResponse;
import dev.pedroteles.covid.domain.entity.usecase.CountryResponse;
import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusCityUseCaseGateway;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusCountryUseCaseGateway;
import dev.pedroteles.covid.domain.gateway.usecase.CoronaVirusStateUseCaseGateway;
import dev.pedroteles.covid.entrypoint.entity.in.CityStatusBodyDTO;
import dev.pedroteles.covid.entrypoint.entity.out.CityStatusDTO;
import dev.pedroteles.covid.entrypoint.entity.out.CountryStatusDTO;
import dev.pedroteles.covid.entrypoint.entity.out.StateStatusDTO;
import dev.pedroteles.covid.entrypoint.mapper.CoronaVirusEntryPointMapper;
import dev.pedroteles.covid.exception.CityNotFoundException;
import dev.pedroteles.covid.exception.CountryNotFoundException;
import dev.pedroteles.covid.exception.StateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoronaVirusEntryPoint {

    private final CoronaVirusCountryUseCaseGateway countryUseCase;
    private final CoronaVirusStateUseCaseGateway stateUseCase;
    private final CoronaVirusCityUseCaseGateway cityUseCase;

    @Autowired
    public CoronaVirusEntryPoint(CoronaVirusCountryUseCaseGateway countryUseCase,
                                 CoronaVirusStateUseCaseGateway stateUseCase,
                                 CoronaVirusCityUseCaseGateway cityUseCase) {
        this.countryUseCase = countryUseCase;
        this.stateUseCase = stateUseCase;
        this.cityUseCase = cityUseCase;
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<CountryStatusDTO> getCountryStatus(@PathVariable("country") String country) {
        try {
            CountryResponse status = countryUseCase.getCountryStatus(country);

            return ResponseEntity.ok(CoronaVirusEntryPointMapper.coreToDto(status));
        } catch (CountryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<StateStatusDTO> getStateStats(@PathVariable("state") String state) {
        try {
            StateResponse core = stateUseCase.getStateStatus(state);

            return ResponseEntity.ok(CoronaVirusEntryPointMapper.stateCoreToDto(core));
        } catch (StateNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/city")
    public ResponseEntity<CityStatusDTO> getCityStatus(@RequestBody CityStatusBodyDTO bodyDTO) {
        try {
            CityResponse core = cityUseCase.getCityStatus(CoronaVirusEntryPointMapper.cityDtoToCore(bodyDTO));

            return ResponseEntity.ok(CoronaVirusEntryPointMapper.cityCoreToDto(core));
        } catch (CityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
