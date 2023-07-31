package com.productoappdistri2.productoappdistri2.entities;

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

@Entity
@Data
@Table(name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente", 
    referencedColumnName = "id", 
    nullable = false, 
    foreignKey = @ForeignKey(name = "FK_asignatura_docente"))
    private Docente docente;

    @JoinColumn(name = "id_curso", 
    referencedColumnName = "id", 
    nullable = false, 
    foreignKey = @ForeignKey(name = "FK_asignatura_curso"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Curso curso;
}
