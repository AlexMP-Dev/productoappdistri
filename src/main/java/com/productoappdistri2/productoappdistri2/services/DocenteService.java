package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import com.productoappdistri2.productoappdistri2.entities.Docente;

public interface DocenteService {
    public List<Docente> findAll();
    public Docente findById(Long id);
    public Docente save(Docente docente);
    public void delete(Long id);
    public void update(Docente docente);
}



