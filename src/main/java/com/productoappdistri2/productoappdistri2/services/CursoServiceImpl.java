package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.productoappdistri2.productoappdistri2.entities.Curso;
import com.productoappdistri2.productoappdistri2.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso findById(Long id) {
		return cursoRepository.findById(id).orElse(null);
	}

	@Override
	public Curso save(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@Override
	public void delete(Long id) {
		cursoRepository.deleteById(id);
	}
	
	@Override
	public void update(Curso curso) {
		cursoRepository.save(curso);
	}

}