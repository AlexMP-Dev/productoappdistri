package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productoappdistri2.productoappdistri2.entities.Nivel;
import com.productoappdistri2.productoappdistri2.repository.NivelRepository;

@Service
public class NivelServiceImpl implements NivelService{

	@Autowired
	private NivelRepository nivelRepository;
	
	@Override
	public List<Nivel> findAll() {
		return nivelRepository.findAll();
	}

	@Override
	public Nivel findById(Long id) {
		return nivelRepository.findById(id).orElse(null);
	}
	
	@Override
	public Nivel save(Nivel nivel) {
		return nivelRepository.save(nivel);
	}

	@Override
	public void delete(Long id) {
		nivelRepository.deleteById(id);
	}
	
	@Override
	public void update(Nivel nivel) {
		nivelRepository.save(nivel);
	}
	
}
