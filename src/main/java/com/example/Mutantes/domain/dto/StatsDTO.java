package com.example.Mutantes.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatsDTO {

    private Long contadorMutanteDna;
    private Long contadorHumanoDna;
    private Double ratio;




}
