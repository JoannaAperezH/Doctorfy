package org.generation.doctorfy.controller;

import java.util.List;

import org.generation.doctorfy.model.Usuario;
import org.generation.doctorfy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/usuario/")
@CrossOrigin(origins = "*")
public class UsuarioController {

public final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> getUsuarios() {
		return this.usuarioService.getUsuarios();
	}
}
