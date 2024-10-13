package com.example.Mutantes;

import com.example.Mutantes.business.service.MutantesService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {
    //test mutante coincidencias hotizontales
    @org.junit.jupiter.api.Test
    public void testEsMutanteHorizontal() {
        List<String> adnMutante = Arrays.asList(
                "GGGGGG",
                "TTTTTT",
                "ACACCA",
                "TGTGTG",
                "ACACAC",
                "TGTGTG"
        );
        try {
            boolean resultado = MutantesService.isMutant(adnMutante);
            assertTrue(resultado, "Mutante");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    // test mutante coincidencias verticales
    @org.junit.jupiter.api.Test
    public void testEsMutanteVertical() {
        List<String> adnMutante = Arrays.asList(
                "AGTTGC",
                "ACAACC",
                "AGTGTC",
                "AACACC",
                "AGTGTC",
                "AACACC"
        );
        try {
            boolean resultado = MutantesService.isMutant(adnMutante);
            assertTrue(resultado, "Mutante");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //mutante coincidencia diagonal descendente
    @org.junit.jupiter.api.Test
    public void testEsMutanteDaigonalDescendente() {
        List<String> adnMutante = Arrays.asList(
                "GCTAGC",
                "AGCGTT",
                "ACGCGA",
                "TGAGCA",
                "CATGGC",
                "CTAGCG"
        );
        try {
            boolean resultado = MutantesService.isMutant(adnMutante);
            assertTrue(resultado, "Mutante");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //mutante coincidencia diagonal ascendente
    @org.junit.jupiter.api.Test
    public void testEsMutanteDaigonalAscendente() {
        List<String> adnMutante = Arrays.asList(
                "GCTAGC",
                "AGCGTT",
                "ACGCGA",
                "TGAGCA",
                "CATGGC",
                "CTAGCG"
        );
        try {
            boolean resultado = MutantesService.isMutant(adnMutante);
            assertTrue(resultado, "Mutante");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //no mutante
    @org.junit.jupiter.api.Test
    public void testNoMutante() {
        List<String> adnMutante = Arrays.asList(
                "GTGTGT",
                "ACACAC",
                "GTGTGT",
                "ACACAC",
                "GTGTGT",
                "ACACAC"
        );
        try {
            boolean resultado = MutantesService.isMutant(adnMutante);
            assertFalse(resultado, "No Mutante");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //prueba por lista vacio
    @org.junit.jupiter.api.Test
    public void testListaVacia() {
        List<String> adnMutante = Arrays.asList(
                "   "
        );
        boolean resultado = MutantesService.adnValidacion(adnMutante);
        assertFalse(resultado, "adn no valido");
    }

    //lista nula
    @org.junit.jupiter.api.Test
    public void testListaNull() {
        List<String> adnMutante = null;

        boolean resultado = MutantesService.adnValidacion(adnMutante);
        assertFalse(resultado, "adn no valido");
    }

    //Lista NxM
    @org.junit.jupiter.api.Test
    public void testListaNXM() {
        List<String> adnMutante = Arrays.asList(
                "ACAAAAAC",
                "TGTGTGTG",
                "ACAAAAAC",
                "TGTGTGTG",
                "ACAAAAAC",
                "TGTGTGTG",
                "ACAAAAAC" //Lista 8x7

        );
        boolean resultado = MutantesService.adnValidacion(adnMutante);
        assertFalse(resultado, "adn no valido");
    }

    //Lista letras incorrectas
    @org.junit.jupiter.api.Test
    public void testListaLetrasMal() {
        List<String> adnMutante = Arrays.asList(
                "GTGTGT",
                "ACACAC",
                "NBNBNB",//letras mal
                "ACACAC",
                "GTGTGT",
                "ACACAC"
        );
        boolean resultado = MutantesService.adnValidacion(adnMutante);
        assertFalse(resultado, "adn no valido");
    }

    //Lista con numeros
    @org.junit.jupiter.api.Test
    public void testListaConNumeros() {
        List<String> adnMutante = Arrays.asList(
                "123456",
                "654321",
                "123456",
                "654321",
                "123456",
                "654321"
        );
        boolean resultado = MutantesService.adnValidacion(adnMutante);
        assertFalse(resultado, "adn no valido");
    }

    @org.junit.jupiter.api.Test
    void contextLoads() {
    }
}
