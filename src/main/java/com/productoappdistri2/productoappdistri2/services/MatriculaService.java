package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import com.productoappdistri2.productoappdistri2.entities.Matricula;

public interface MatriculaService {
    public List<Matricula> findAll();
    public Matricula findById(Long id);
    public Matricula save(Matricula matricula);
    public void delete(Long id);
    public void update(Matricula matricula);
}