package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import com.productoappdistri2.productoappdistri2.entities.Usuario;

public interface UsuarioService {   
	
	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario save(Usuario usuario);
	public void delete(Long id);
	public void update(Usuario usuario);

}



