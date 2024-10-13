package com.example.Mutantes.domain.entity;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="persona")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="MUTANTE")
    private boolean esMutante;

    @Column(name="ADN-COMPLETO", columnDefinition = "TEXT")
    private String fullAdn;

    @Transient
    private List<String> adn;


}