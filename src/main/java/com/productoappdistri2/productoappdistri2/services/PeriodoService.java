package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import com.productoappdistri2.productoappdistri2.entities.Periodo;

public interface PeriodoService {
    public List<Periodo> findAll();
    public Periodo findById(Long id);
    public Periodo save(Periodo periodo);
    public void delete(Long id);
    public void update(Periodo periodo);

}
