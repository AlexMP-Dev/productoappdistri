package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import com.productoappdistri2.productoappdistri2.entities.Curso;

public interface CursoService {

	
    public List<Curso> findAll();
    public Curso findById(Long id);
    public Curso save(Curso curso);
    public void delete(Long id);
    public void update(Curso curso);

}


