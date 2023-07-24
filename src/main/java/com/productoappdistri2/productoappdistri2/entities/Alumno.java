package com.productoappdistri2.productoappdistri2.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "alumnos")
@Data
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Los nombres son requeridos")
    private String nombres;

    @NotBlank(message = "Los apellidos son requeridos")
    private String apellidos;

    @NotBlank(message = "El DNI es requerido")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 caracteres")
    private String dni;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    @NotBlank(message = "La fecha de nacimiento es requerida")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fechaNacimiento;

    @NotBlank(message = "El celular es requerido")
    @Size(min = 9, max = 9, message = "El celular debe tener 9 caracteres")
    private String celular;

    @NotBlank(message = "El email es requerido")
    @Email(message = "El email no es valido")
    private String eMail;

    @NotBlank(message = "La direccion es requerida")
    private String direccion;

}
