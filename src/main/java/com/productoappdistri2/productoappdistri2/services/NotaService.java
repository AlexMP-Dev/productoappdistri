package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import com.productoappdistri2.productoappdistri2.entities.Nota;


public interface NotaService {
	
    public List<Nota> findAll();
    public Nota findById(Long id);
    public Nota save(Nota nota);
    public void delete(Long id);
    public void update(Nota nota);
    
}