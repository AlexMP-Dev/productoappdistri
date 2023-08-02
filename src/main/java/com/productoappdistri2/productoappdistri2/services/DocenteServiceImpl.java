package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productoappdistri2.productoappdistri2.entities.Docente;
import com.productoappdistri2.productoappdistri2.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService {
	
	@Autowired
	private DocenteRepository docenteRepository; 
	

	@Override
	public List<Docente> findAll() {
		return docenteRepository.findAll();
	}

	@Override
	public Docente findById(Long id) {
		return docenteRepository.findById(id).orElse(null);
	}

	@Override
	public Docente save(Docente docente) {
		return docenteRepository.save(docente);
	}
	

	@Override
	public void delete(Long id) {
		docenteRepository.deleteById(id);
	}

	@Override
	public void update(Docente docente) {
		docenteRepository.save(docente);
	}
	
}


