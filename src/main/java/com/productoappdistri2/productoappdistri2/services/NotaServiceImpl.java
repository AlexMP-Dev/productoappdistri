package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productoappdistri2.productoappdistri2.entities.Nota;
import com.productoappdistri2.productoappdistri2.repository.NotaRepository;

@Service
public class NotaServiceImpl implements NotaService {

	@Autowired
	private NotaRepository notaRepository;

	@Override
	public List<Nota> findAll() {
		return notaRepository.findAll();
	}

	@Override
	public Nota findById(Long id) {
		return notaRepository.findById(id).orElse(null);
	}
	
	@Override
	public Nota save(Nota nota) {
		return notaRepository.save(nota);
	}

	@Override
	public void delete(Long id) {
		notaRepository.deleteById(id);
	}	

	@Override
	public void update(Nota nota) {
		notaRepository.save(nota);
	}

}




