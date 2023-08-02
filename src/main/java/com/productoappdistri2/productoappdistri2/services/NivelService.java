package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import com.productoappdistri2.productoappdistri2.entities.Nivel;

public interface NivelService {
    public List<Nivel> findAll();
    public Nivel findById(Long id);
    public Nivel save(Nivel nivel);
    public void delete(Long id);
    public void update(Nivel nivel);
}
