package org.generation.doctorfy.service;

import java.util.Optional;

import org.generation.doctorfy.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u WHERE u.correo = ?1")
	Optional<Usuario> findByEmail(String correo);

}
