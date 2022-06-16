package org.generation.doctorfy.controller;

import java.util.List;
import java.util.Optional;

import org.generation.doctorfy.model.UsuarioQuery;
import org.generation.doctorfy.service.UsuarioQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/doctores/")
@CrossOrigin(origins = "*")
public class UsuarioQueryController {
	public final UsuarioQueryService usuarioQueryService;
	
	@Autowired
	public UsuarioQueryController(UsuarioQueryService usuarioQueryService) {
		this.usuarioQueryService = usuarioQueryService;
	}
	
	@GetMapping
	public List<UsuarioQuery> getDoctores(){
		return usuarioQueryService.getDoctores();
	}
	
	@GetMapping(path = "{id}")
	public UsuarioQuery getDoctor(Long id) {
		return usuarioQueryService.getDoctor(id);
	}
	
	
	@GetMapping(path="query")
	public List<UsuarioQuery> getDoctoresByQuery(
			@RequestParam(required = false) String ciudad,
			@RequestParam(required = false) String query
			){
		
		return usuarioQueryService.getDoctoresByQuery(ciudad, query);
	}
	
}
