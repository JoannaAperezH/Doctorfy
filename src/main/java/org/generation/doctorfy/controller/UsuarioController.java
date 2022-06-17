package org.generation.doctorfy.controller;

import java.util.List;

import org.generation.doctorfy.model.EnfermedadEspecialidad;
import org.generation.doctorfy.model.Usuario;
import org.generation.doctorfy.service.EnfermedadEspecialidadService;
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
public final EnfermedadEspecialidadService enfermedadEspecialidadService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService, EnfermedadEspecialidadService enfermedadEspecialidadService) {
		this.usuarioService = usuarioService;
		this.enfermedadEspecialidadService = enfermedadEspecialidadService;
	}
	
	
	@GetMapping
	public List<Usuario> getUsuarios() {
		return this.usuarioService.getUsuarios();
	}
	
	
	@PostMapping(path = "signIn")
	public String signIn(@RequestBody Usuario us) {
		String result = "{"
				+ "\"StatusCode\": \"Error\","
				+ "\"message\": \"El usuario ya existe\" }";

		Usuario usuario = new Usuario();
		usuario.setNombre(us.getNombre());
		usuario.setApellidoPaterno(us.getApellidoPaterno());
		usuario.setApellidoMaterno(us.getApellidoMaterno());
		usuario.setCorreo(us.getCorreo());
		usuario.setPassword(us.getPassword());
		if(us.getEspecialidad() != null) usuario.setEspecialidad(us.getEspecialidad());
		
		if(this.usuarioService.signIn(usuario)) {
			result = "{\"StatusCode\": \"Ok\" }";
		}
		return result;
	}
	
	@PutMapping(path = "{id}")
	public String updateUsuario(@PathVariable("id") Long id,
			@RequestParam(required = false) String currentPassword,
			@RequestParam(required = false) String newPasword) {
		
		String result = "{"
				+ "\"StatusCode\": \"Error\","
				+ "\"message\": \"Hubo un error al guardar la información\" }";
		
		boolean isOk = usuarioService.updateUsuario(id, currentPassword, newPasword);
		
		if(isOk) {
			result =  "{\"StatusCode\": \"Ok\" }";
		}
		
		return result;
	}
	
	
	@PutMapping(path = "completarPerfil/{id}")
	public String completarPerfil( @PathVariable("id") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellidoPaterno,
			@RequestParam(required = false) String apellidoMaterno,
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
			@RequestParam(required = false) Long contador,
			@RequestParam(required = false) Double promedio,
			@RequestParam(required = false) String whatsapp,
			@RequestParam(required = false) String universidad,
			@RequestParam(required = false) String universidadEspecialidad,
			@RequestParam(required = false) String cedulaEspecial,
			@RequestParam(required = false) String especialidad,
			@RequestParam(required = false) String enfermedad1,
			@RequestParam(required = false) String enfermedad2,
			@RequestParam(required = false) String enfermedad3,
			@RequestParam(required = false) String enfermedad4
			) {
		
		String result = "{"
				+ "\"StatusCode\": \"Error\","
				+ "\"message\": \"Hubo un error al guardar la información\" }";
		
		Usuario us = usuarioService.getUsuario(id);
		EnfermedadEspecialidad enfermedadEspecialidad = null;
		
		if(us.getEnfermedadEspecialidad() == null) {
			enfermedadEspecialidad = new EnfermedadEspecialidad();
			
			if(enfermedad1 != null) enfermedadEspecialidad.setEnfermedad1(enfermedad1);
			if(enfermedad2 != null) enfermedadEspecialidad.setEnfermedad2(enfermedad2);
			if(enfermedad3 != null) enfermedadEspecialidad.setEnfermedad3(enfermedad3);
			if(enfermedad4 != null) enfermedadEspecialidad.setEnfermedad4(enfermedad4);
			
			Long enfermedadEspecialidadId = enfermedadEspecialidadService.addEnfermedadEspecialidad(enfermedadEspecialidad);
			
			enfermedadEspecialidad = enfermedadEspecialidadService.getEnfermedadEspecialidad(enfermedadEspecialidadId);
		}else {
			enfermedadEspecialidad = us.getEnfermedadEspecialidad();
			if(enfermedad1 != null) enfermedadEspecialidad.setEnfermedad1(enfermedad1);
			if(enfermedad2 != null) enfermedadEspecialidad.setEnfermedad2(enfermedad2);
			if(enfermedad3 != null) enfermedadEspecialidad.setEnfermedad3(enfermedad3);
			if(enfermedad4 != null) enfermedadEspecialidad.setEnfermedad4(enfermedad4);
		}
		
		
		
		boolean isOk = usuarioService.completarPerfil(id, nombre, apellidoPaterno,apellidoMaterno,correo,calle,colonia,ciudad,estado,telefono,fotoPerfil,cedula,descripcionCorta,biografia, contador,promedio,whatsapp,universidad,universidadEspecialidad,cedulaEspecial,especialidad, enfermedadEspecialidad);
		
		if(isOk) {
			result =  "{\"StatusCode\": \"Ok\" }";
		}
		return result;
	}
}
