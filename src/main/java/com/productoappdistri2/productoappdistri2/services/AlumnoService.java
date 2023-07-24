package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import com.productoappdistri2.productoappdistri2.entities.Alumno;

public interface AlumnoService {
    public List<Alumno> findAll();
    public Alumno findById(Long id);
    public Alumno save(Alumno alumno);
    public void delete(Long id);
    public void update(Alumno alumno);
}
