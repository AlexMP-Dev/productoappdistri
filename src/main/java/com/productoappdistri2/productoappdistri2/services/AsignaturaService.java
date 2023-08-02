package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import com.productoappdistri2.productoappdistri2.entities.Asignatura;

public interface AsignaturaService {
	
    public List<Asignatura> findAll();
    public Asignatura findById(Long id);
    public Asignatura save(Asignatura asignatura);
    public void delete(Long id);
    public void update(Asignatura asignatura);

}
