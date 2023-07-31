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
    private String nombre;

    @Column(name = "apellidos")
    @NotBlank(message = "Los apellidos son requeridos")
    private String apellido;

    @Column(name = "dni")
    @NotBlank(message = "El DNI es requerido")
    private String dni;

    @Column(name = "telefono")
    @NotBlank(message = "El telefono es requerido")
    private String telefono;

    @Column(name = "email")
    @Email(message = "Email invalido")
    private String email;

    @Column(name = "direccion")
    @NotBlank(message = "La direccion es requerida")
    private String direccion;

    

}
