package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import com.productoappdistri2.productoappdistri2.entities.Pago;

public interface PagoService{
    public List<Pago> findAll();
    public Pago findById(Long id);
    public Pago save(Pago pago);
    public void delete(Long id);
    public void update(Pago pago);

}


