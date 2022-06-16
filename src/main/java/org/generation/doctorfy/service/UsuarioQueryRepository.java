package org.generation.doctorfy.service;

import java.util.List;
import java.util.Optional;

import org.generation.doctorfy.model.UsuarioQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioQueryRepository extends JpaRepository<UsuarioQuery, Long>{
	@Query("SELECT u FROM Usuario u WHERE u.correo = ?1")
	Optional<UsuarioQuery> findByEmail(String correo);
	
	@Query("SELECT u FROM UsuarioQuery u WHERE ciudad LIKE ?1 AND (especialidad Like ?2  OR nombre LIKE ?2 OR apellidoPaterno LIKE ?2 OR apellidoMaterno LIKE ?2)")
	List<UsuarioQuery> findByQuery(String ciudad, String query);
}
