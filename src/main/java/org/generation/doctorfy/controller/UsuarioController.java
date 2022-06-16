package org.generation.doctorfy.controller;

import java.util.List;

import org.generation.doctorfy.model.Usuario;
import org.generation.doctorfy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@PostMapping(path = "signIn")
	public void signIn(@RequestBody Usuario usuario) {
		this.usuarioService.signIn(usuario);
	}
	
	@PutMapping(path = "{id}")
	public void updateUsuario(@PathVariable("id") Long id,
			@RequestParam(required = false) String currentPassword,
			@RequestParam(required = false) String newPasword) {
		usuarioService.updateUsuario(id, currentPassword, newPasword);
	}
	/*
	@PutMapping(path = "completarPerfil/{id}")
	public void completarPerfil( @PathVariable("id") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellidoPaterno,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String calle,
			@RequestParam(required = false) String colonia,
			@RequestParam(required = false) String ciudad,
			@RequestParam(required = false) String estado,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String fotoPerfil,
			@RequestParam(required = false) String cedula,
			@RequestParam(required = false) String descripcionCorta,
			@RequestParam(required = false) String biografia,
			@RequestParam(required = false) String contador,
			@RequestParam(required = false) String promedio,
			@RequestParam(required = false) String whatsapp,
			@RequestParam(required = false) String universidad,
			@RequestParam(required = false) String universidadEspecialidad,
			@RequestParam(required = false) String cedulaEspecial,
			@RequestParam(required = false) String especialidad,
			@RequestParam(required = false) String EnfermedadEspecialidad enfermedadEspecialidad
			) {
		usuarioService.completarPerfil(id, currentPassword, newPasword);
	}*/
}
