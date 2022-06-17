package org.generation.doctorfy.service;

import org.generation.doctorfy.model.EnfermedadEspecialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnfermedadEspecialidadService {
	
	private final EnfermedadEspecialidadRepository enfermedadEspecialidadRepository;
	
	@Autowired
	public EnfermedadEspecialidadService(EnfermedadEspecialidadRepository enfermedadEspecialidadRepository) {
		this.enfermedadEspecialidadRepository = enfermedadEspecialidadRepository;
	}
	
	
	public Long addEnfermedadEspecialidad(EnfermedadEspecialidad enfermedadEspecialidad) {
		this.enfermedadEspecialidadRepository.save(enfermedadEspecialidad);
		return enfermedadEspecialidad.getId();
	}


	public EnfermedadEspecialidad getEnfermedadEspecialidad(Long id) {
		// TODO Auto-generated method stub
		return enfermedadEspecialidadRepository.findById(id).get();
	}
	

}
