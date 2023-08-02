package com.productoappdistri2.productoappdistri2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres")
    @NotBlank(message = "Los nombres son requeridos")
    private String nombres;

    @Column(name = "apellidos")
    @NotBlank(message = "Los apellidos son requeridos")
    private String apellidos;

    @Column(name = "dni")
    @NotBlank(message = "El DNI es requerido")
    private String dni;

    @Column(name = "telefono")
    @NotBlank(message = "El telefono es requerido")
    private String celular;

    @Column(name = "email")
    @Email(message = "Email invalido")
    private String eMail;

    @Column(name = "direccion")
    @NotBlank(message = "La direccion es requerida")
    private String direccion;

}
