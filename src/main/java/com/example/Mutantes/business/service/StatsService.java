package com.example.Mutantes.business.service;

import com.example.Mutantes.domain.dto.StatsDTO;
import com.example.Mutantes.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    @Autowired
    PersonaRepository personaRepository;
    public StatsDTO getStats() throws Exception{
        // Contador de mutantes
        long countMutantes = personaRepository.countByEsMutante(true);

        // Contador de humanos en general
        long totalHumanos = personaRepository.count();

        // Calculo del porcentaje de mutantes en la sociedad
        double porcentajeMutantes = totalHumanos > 0 ? ((double) countMutantes / totalHumanos) * 100 : 0;

        StatsDTO statsDTO = StatsDTO.builder()
                .contadorMutanteDna(countMutantes)
                .contadorHumanoDna(totalHumanos)
                .ratio(porcentajeMutantes)
                .build();

        return (statsDTO);

    }

}
