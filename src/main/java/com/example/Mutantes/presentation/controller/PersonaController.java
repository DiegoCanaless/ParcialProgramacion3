package com.example.Mutantes.presentation.controller;

import com.example.Mutantes.domain.dto.PersonaDTO;
import com.example.Mutantes.business.service.MutantesService;
import com.example.Mutantes.business.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path = "/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping("/mutant")
    public ResponseEntity<?> registro(@RequestBody PersonaDTO persona) {
        try {
            if (!MutantesService.adnValidacion(persona.getAdn())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El ADN es invalido");
            }
            personaService.ResgistrarHumano(persona);
            if(MutantesService.isMutant(persona.getAdn())){
                return ResponseEntity.status(HttpStatus.OK).body("Se encontro el Mutante");
            }else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No se ha encontrado el mutante");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrados");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
        }
    }





}
