package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productoappdistri2.productoappdistri2.entities.Periodo;
import com.productoappdistri2.productoappdistri2.repository.PeriodoRepository;

@Service
public class PeriodoServiceImpl implements PeriodoService{

	@Autowired
	private PeriodoRepository periodoRepository;

	@Override
	public List<Periodo> findAll() {
		return periodoRepository.findAll();
	}

	@Override
	public Periodo findById(Long id) {
		return periodoRepository.findById(id).orElse(null);
	}
	
	@Override
	public Periodo save(Periodo periodo) {
		return periodoRepository.save(periodo);
	}

	@Override
	public void delete(Long id) {
		periodoRepository.deleteById(id);
	}
	
	@Override
	public void update(Periodo periodo) {
		periodoRepository.save(periodo);
	}

}
