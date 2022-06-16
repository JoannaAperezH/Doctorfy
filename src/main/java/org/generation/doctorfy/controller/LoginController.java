package org.generation.doctorfy.controller;

import org.generation.doctorfy.model.Usuario;
import org.generation.doctorfy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/login/")
@CrossOrigin(origins = "*")
public class LoginController {
	
	private final UsuarioService usuarioService;
	
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
	public String login (@RequestBody Usuario usuario) {
		String result = "{"
				+ "\"StatusCode\": \"Error\","
				+ "\"message\": \"Password o usuario incorrecto\" }";
		
		if(usuarioService.login( usuario.getCorreo(), usuario.getPassword() )) {
			result = "{\"StatusCode\": \"Ok\" }";
		}
		
		return result;
	}
	
	
}










