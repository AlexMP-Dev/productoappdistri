package com.productoappdistri2.productoappdistri2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @JoinColumn(name = "id_nivel", referencedColumnName = "id", nullable = false, unique = false, foreignKey = @ForeignKey(name = "FK_curso_nivel"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Nivel nivel;
}
