package com.example.Mutantes.business.mapper;

import com.example.Mutantes.domain.dto.PersonaDTO;
import com.example.Mutantes.domain.entity.Persona;
import com.example.Mutantes.business.service.MutantesService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PersonaMapper {
    PersonaMapper instancia = Mappers.getMapper(PersonaMapper.class);

    @Mapping(target = "id", ignore = true) // Ignorar
    @Mapping(target = "esMutante", expression = "java(esMutante(personaDTO.getAdn()))")
    @Mapping(target = "fullAdn", expression = "java(mapFullAdn(personaDTO.getAdn()))")
    Persona personaDTOToPersona(PersonaDTO personaDTO);

    default String mapFullAdn(List<String> adn) {
        return adn != null ? adn.stream().collect(Collectors.joining(" , ")) : null;
    }

    default Boolean esMutante(List<String> adn) {
        try {
            return (MutantesService.isMutant(adn));
        }catch (Exception e){
            return false;
        }
    }

}
