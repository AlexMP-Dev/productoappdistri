package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productoappdistri2.productoappdistri2.entities.Pago;
import com.productoappdistri2.productoappdistri2.repository.PagoRepository;

@Service
public class PagoServiceImpl implements PagoService{

	@Autowired
	private PagoRepository pagoRepository;

	@Override
	public List<Pago> findAll() {
		return pagoRepository.findAll();
	}

	@Override
	public Pago findById(Long id) {
		return pagoRepository.findById(id).orElse(null);
	}

	@Override
	public Pago save(Pago pago) {
		return pagoRepository.save(pago);
	}
	
	@Override
	public void delete(Long id) {
		pagoRepository.deleteById(id);
	}
	
	@Override
	public void update(Pago pago) {
		pagoRepository.save(pago);
	}

}
