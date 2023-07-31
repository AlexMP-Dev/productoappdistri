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
import jakarta.validation.constraints.Past;
import lombok.Data;

@Table(name = "pagos")
@Data
@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_pago")
    @Past(message = "La fecha de pago debe ser anterior a la actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPago;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "codigo_pago")
    private String codigoPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_pago_alumno"))
    private Alumno alumno;
}
