package com.productoappdistri2.productoappdistri2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.productoappdistri2.productoappdistri2.entities.Usuario;
import com.productoappdistri2.productoappdistri2.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		PasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
		String pass = passwordEncoder2.encode("123456");
		System.err.println(pass);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		usuario.setClave(passwordEncoder.encode(usuario.getClave()));
		return usuarioRepository.save(usuario);
	}

	@Override
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public void update(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

}
