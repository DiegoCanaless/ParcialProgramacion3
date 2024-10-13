package com.example.Mutantes.repositories;


import com.example.Mutantes.domain.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    boolean existsByFullAdn(String fullAdn);

    long countByEsMutante(boolean esMutante);

}


