package com.productoappdistri2.productoappdistri2.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_matricula")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaMatricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_matricula_curso"))
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pago", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_matricula_pago"))
    private Pago pago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_periodo", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_matricula_periodo"))
    private Periodo periodo;

}
