package com.example.Mutantes.business.service;


import com.example.Mutantes.domain.dto.PersonaDTO;
import com.example.Mutantes.domain.entity.Persona;
import com.example.Mutantes.business.mapper.PersonaMapper;
import com.example.Mutantes.repositories.PersonaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Transactional
    public void ResgistrarHumano(PersonaDTO persona) throws Exception {

        Persona personaPersistida = PersonaMapper.instancia.personaDTOToPersona(persona);

        if (personaRepository.existsByFullAdn(personaPersistida.getFullAdn())) {
            throw new Exception("el ADN ya ha sido ingresado");
        }
        personaRepository.save(personaPersistida);

    }

    @Transactional
    public List<Persona> findAll() throws Exception {
        try {
            List<Persona> personas = personaRepository.findAll();
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Transactional
    public Persona findById(Long id) throws Exception {
        try {
            Optional<Persona> persona = personaRepository.findById(id);
            return persona.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
