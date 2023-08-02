package com.productoappdistri2.productoappdistri2.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.productoappdistri2.productoappdistri2.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
