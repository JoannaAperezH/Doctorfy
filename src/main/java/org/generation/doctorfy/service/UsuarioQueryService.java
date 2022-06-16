package org.generation.doctorfy.service;

import java.util.List;
import java.util.Optional;

import org.generation.doctorfy.model.UsuarioQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioQueryService {

	private final UsuarioQueryRepository usuarioQueryRepository;

	@Autowired
	public UsuarioQueryService(UsuarioQueryRepository usuarioQueryRepository) {
		this.usuarioQueryRepository = usuarioQueryRepository;
	}

	public List<UsuarioQuery> getDoctores() {
		return usuarioQueryRepository.findAll();
	}

	public UsuarioQuery getDoctor(Long id) {
		return usuarioQueryRepository.findById(id).get();
	}
/*
	public Optional<UsuarioQuery> getDoctoresByQuery(String ciudad, String query) {
		return usuarioQueryRepository.findByQuery(ciudad, query);
	}*/

	// Get productos 
	public List<UsuarioQuery> getDoctoresByQuery(String ciudad, String query) { 
		return	usuarioQueryRepository.findByQuery(ciudad, query); // Utilizar funciones de nuestro Repository 
	}
}
