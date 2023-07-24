package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productoappdistri2.productoappdistri2.entities.Alumno;
import com.productoappdistri2.productoappdistri2.repository.Alumnorepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    
    @Autowired
    private Alumnorepository alumnoRepository;

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void delete(Long id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public void update(Alumno alumno) {
        alumnoRepository.save(alumno);
    }
}
