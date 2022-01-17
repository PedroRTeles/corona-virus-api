package dev.pedroteles.covid.webclient.mapper;

import dev.pedroteles.covid.domain.entity.usecase.StateResponse;
import dev.pedroteles.covid.exception.StateNotFoundException;
import dev.pedroteles.covid.webclient.entity.in.StateResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoronaVirusStateWebClientMapper {
    public static StateResponse dtoToCore(StateResponseDTO[] body, String state) throws StateNotFoundException {
        StateResponseDTO dto = getStateData(body, state);

        if(dto == null)
            throw new StateNotFoundException();

        return StateResponse.builder()
                .stateName(getStateFullName(dto.getName()))
                .totalCases(dto.getTotalSuspects())
                .totalDeaths(dto.getTotalDeaths())
                .build();
    }

    private static String getStateFullName(String name) {
        switch (name) {
            case "SP": return "São Paulo";
            case "CE": return "Ceará";
            case "RJ": return "Rio de Janeiro";
            case "PA": return "Pará";
            case "BA": return "Bahia";
            case "MA": return "Maranhão";
            case "MG": return "Minas Gerais";
            case "AM": return "Amazonas";
            case "DF": return "Distrito Federal";
            case "PE": return "Pernambuco";
            case "ES": return "Espírito Santo";
            case "PB": return "Paraíba";
            case "SC": return "Santa Catarina";
            case "PR": return "Paraná";
            case "RS": return "Rio Grande do Sul";
            case "AL": return "Alagoas";
            case "GO": return "Goiás";
            case "SE": return "Sergipe";
            case "RN": return "Rio Grande do Norte";
            case "PI": return "Piauí";
            case "MT": return "Mato Grosso";
            case "AP": return "Amapá";
            case "RO": return "Rondônia";
            case "RR": return "Roraima";
            case "MS": return "Mato Grosso do SUl";
            case "TO": return "Tocantins";
            default: return "Acre";
        }
    }

    private static StateResponseDTO getStateData(StateResponseDTO[] body, String state) {
        for (StateResponseDTO stateResponseDTO : body) {
            if (stateResponseDTO.getName() != null && stateResponseDTO.getName().endsWith(state.toUpperCase()))
                return stateResponseDTO;
        }

        return null;
    }
}
