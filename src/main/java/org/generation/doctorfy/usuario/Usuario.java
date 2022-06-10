package org.generation.doctorfy.usuario;

public class Usuario {
	private int id;
	private static int total = 0;
	private String name;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String contra;
	private String telefono;
	private String fechaNacimiento;
	private String fotoPerfil;
	private String domicilio;
	private String colonia;
	private String ciudad;
	private String estado;
	private String codigoPostal;
	private int idtipo_usuario;
	public Usuario(String name, String apellidoPaterno, String apellidoMaterno, String correo, String contra,
			String telefono, String fechaNacimiento, String fotoPerfil, String domicilio, String colonia, String ciudad,
			String estado, String codigoPostal, int idtipo_usuario) {
		super();
		total++;
		this.id=total;
		this.name = name;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correo = correo;
		this.contra = contra;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.fotoPerfil = fotoPerfil;
		this.domicilio = domicilio;
		this.colonia = colonia;
		this.ciudad = ciudad;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
		this.idtipo_usuario = idtipo_usuario;
	}
	
	
	
	public Usuario() {
		super();
		total++;
		this.id=total;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getFotoPerfil() {
		return fotoPerfil;
	}
	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
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
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public int getIdtipo_usuario() {
		return idtipo_usuario;
	}
	public void setIdtipo_usuario(int idtipo_usuario) {
		this.idtipo_usuario = idtipo_usuario;
	}
	

	
}
