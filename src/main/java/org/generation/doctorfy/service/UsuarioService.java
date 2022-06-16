package org.generation.doctorfy.service;

import java.util.List;

import org.generation.doctorfy.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

}
