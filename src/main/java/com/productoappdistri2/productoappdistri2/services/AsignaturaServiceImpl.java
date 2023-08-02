package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productoappdistri2.productoappdistri2.entities.Asignatura;
import com.productoappdistri2.productoappdistri2.repository.AsignaturaRepository;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	
	@Override
	public List<Asignatura> findAll() {
		return asignaturaRepository.findAll();
	}
	
	@Override
	public Asignatura findById(Long id) {
		return asignaturaRepository.findById(id).orElse(null);
	}
	
	@Override
	public Asignatura save(Asignatura asignatura) {
		return asignaturaRepository.save(asignatura);
	}
	
	@Override
	public void delete(Long id) {
		asignaturaRepository.deleteById(id);
	}
	
	@Override
	public void update(Asignatura asignatura) {
		asignaturaRepository.save(asignatura);
	}
}
