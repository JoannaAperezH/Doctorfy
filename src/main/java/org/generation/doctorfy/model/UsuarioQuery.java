package org.generation.doctorfy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioQuery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false) 
	private Long id;
	private String nombre;
	@Column(name = "apellido_paterno")
	private String apellidoPaterno;
	@Column(name = "apellido_materno")
	private String apellidoMaterno;
	private String correo;
	private String calle;
	private String colonia;
	private String ciudad;
	private String estado;
	private String telefono;
	@Column(name = "foto_perfil")
	private String fotoPerfil;
	private String cedula;
	@Column(name = "descripcion_corta")
	private String descripcionCorta;
	private String biografia;
	private Long contador;
	private Double promedio;
	private String whatsapp;
	private String universidad;
	@Column(name = "universidad_especialidad")
	private String universidadEspecialidad;
	@Column(name = "cedula_especial")
	private String cedulaEspecial;
	private String especialidad;
	
	
	@ManyToOne
	@JoinColumn(name = "especialidad_fk_usuario")
	//@Column(name = "especialidad_fk_usuario")
	private EnfermedadEspecialidad enfermedadEspecialidad;


	public UsuarioQuery(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String correo,
			String calle, String colonia, String ciudad, String estado, String telefono, String fotoPerfil,
			String cedula, String descripcionCorta, String biografia, Long contador, Double promedio, String whatsapp,
			String universidad, String universidadEspecialidad, String cedulaEspecial, String especialidad,
			EnfermedadEspecialidad enfermedadEspecialidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correo = correo;
		this.calle = calle;
		this.colonia = colonia;
		this.ciudad = ciudad;
		this.estado = estado;
		this.telefono = telefono;
		this.fotoPerfil = fotoPerfil;
		this.cedula = cedula;
		this.descripcionCorta = descripcionCorta;
		this.biografia = biografia;
		this.contador = contador;
		this.promedio = promedio;
		this.whatsapp = whatsapp;
		this.universidad = universidad;
		this.universidadEspecialidad = universidadEspecialidad;
		this.cedulaEspecial = cedulaEspecial;
		this.especialidad = especialidad;
		this.enfermedadEspecialidad = enfermedadEspecialidad;
	}


	public UsuarioQuery() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getColonia() {
		return colonia;
	}


	public void setColonia(String colonia) {
		this.colonia = colonia;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getFotoPerfil() {
		return fotoPerfil;
	}


	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getDescripcionCorta() {
		return descripcionCorta;
	}


	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}


	public String getBiografia() {
		return biografia;
	}


	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}


	public Long getContador() {
		return contador;
	}


	public void setContador(Long contador) {
		this.contador = contador;
	}


	public Double getPromedio() {
		return promedio;
	}


	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}


	public String getWhatsapp() {
		return whatsapp;
	}


	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}


	public String getUniversidad() {
		return universidad;
	}


	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}


	public String getUniversidadEspecialidad() {
		return universidadEspecialidad;
	}


	public void setUniversidadEspecialidad(String universidadEspecialidad) {
		this.universidadEspecialidad = universidadEspecialidad;
	}


	public String getCedulaEspecial() {
		return cedulaEspecial;
	}


	public void setCedulaEspecial(String cedulaEspecial) {
		this.cedulaEspecial = cedulaEspecial;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	public EnfermedadEspecialidad getEnfermedadEspecialidad() {
		return enfermedadEspecialidad;
	}


	public void setEnfermedadEspecialidad(EnfermedadEspecialidad enfermedadEspecialidad) {
		this.enfermedadEspecialidad = enfermedadEspecialidad;
	}
	
	
	
	
	
	
	
	
}
