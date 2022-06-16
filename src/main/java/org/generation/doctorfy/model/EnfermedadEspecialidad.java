package org.generation.doctorfy.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "EnfermedadEspecialidad")
public class EnfermedadEspecialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false) 
	private Long id;
	
	private String enfermedad1;
	private String enfermedad2;
	private String enfermedad3;
	private String enfermedad4;
	
	
	@OneToMany(mappedBy = "enfermedadEspecialidad")
	@JsonBackReference
	private List<Usuario> usuarios;

	public EnfermedadEspecialidad(Long id, String enfermedad1, String enfermedad2, String enfermedad3,
			String enfermedad4, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.enfermedad1 = enfermedad1;
		this.enfermedad2 = enfermedad2;
		this.enfermedad3 = enfermedad3;
		this.enfermedad4 = enfermedad4;
		this.usuarios = usuarios;
	}

	public EnfermedadEspecialidad() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnfermedad1() {
		return enfermedad1;
	}

	public void setEnfermedad1(String enfermedad1) {
		this.enfermedad1 = enfermedad1;
	}

	public String getEnfermedad2() {
		return enfermedad2;
	}

	public void setEnfermedad2(String enfermedad2) {
		this.enfermedad2 = enfermedad2;
	}

	public String getEnfermedad3() {
		return enfermedad3;
	}

	public void setEnfermedad3(String enfermedad3) {
		this.enfermedad3 = enfermedad3;
	}

	public String getEnfermedad4() {
		return enfermedad4;
	}

	public void setEnfermedad4(String enfermedad4) {
		this.enfermedad4 = enfermedad4;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
	
	
}
