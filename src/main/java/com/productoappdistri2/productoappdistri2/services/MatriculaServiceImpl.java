package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.productoappdistri2.productoappdistri2.entities.Matricula;
import com.productoappdistri2.productoappdistri2.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService{
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Override
	public List<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

	@Override
	public Matricula findById(Long id) {
		return matriculaRepository.findById(id).orElse(null);
	}
	
	@Override
	public Matricula save(Matricula matricula) {
		return matriculaRepository.save(matricula);
	}

	@Override
	public void delete(Long id) {
		matriculaRepository.deleteById(id);
	}
	@Override
	public void update(Matricula matricula) {
		matriculaRepository.save(matricula);
	}


	

}
