package com.productoappdistri2.productoappdistri2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matricula", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_nota_matricula"))
    private Matricula matricula;

    @Column(name = "nota_speaking")
    private Integer notaSpeaking;

    @Column(name = "nota_earing")
    private Integer notaEaring;

    @Column(name = "nota_writing")
    private Integer notaWriting;

    public Nota() {
    }

    public Nota(Matricula matricula) {
        this.matricula = matricula;
    }
}
