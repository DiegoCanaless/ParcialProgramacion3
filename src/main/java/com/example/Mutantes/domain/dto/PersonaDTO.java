package com.example.Mutantes.domain.dto;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PersonaDTO {

    @NotNull
    private List<String> adn;

    private boolean esMutante;

}