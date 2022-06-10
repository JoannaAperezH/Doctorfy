package org.generation.doctorfy.usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	public final ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioService() {
		usuarios.add(new Usuario("Diego",
				"Briones", 
				"Martinez", 
				"d@mail.com", 
				"password", 
				"8183123456", 
				"1995-01-04", 
				"diego-picture.png", 
				"Baker Street 221", 
				"Surrey", 
				"Londres", 
				"Londres", 
				"12438", 
				1));
		usuarios.add(new Usuario("Joanna",
				"Perez", 
				"Martinez", 
				"j@mail.com", 
				"password", 
				"8183123456", 
				"1995-01-04", 
				"diego-picture.png", 
				"Baker Street 221", 
				"Surrey", 
				"Londres", 
				"Londres", 
				"12438", 
				1));
		usuarios.add(new Usuario("Hiram",
				"Sanchez", 
				"Martinez", 
				"j@mail.com", 
				"password", 
				"8183123456", 
				"1995-01-04", 
				"diego-picture.png", 
				"Baker Street 221", 
				"Surrey", 
				"Londres", 
				"Londres", 
				"12438", 
				1));
		usuarios.add(new Usuario("Saira",
				"Arteaga", 
				"Martinez", 
				"j@mail.com", 
				"password", 
				"8183123456", 
				"1995-01-04", 
				"diego-picture.png", 
				"Baker Street 221", 
				"Surrey", 
				"Londres", 
				"Londres", 
				"12438", 
				1));
		usuarios.add(new Usuario("Danna",
				"Zavala", 
				"Martinez", 
				"j@mail.com", 
				"password", 
				"8183123456", 
				"1995-01-04", 
				"diego-picture.png", 
				"Baker Street 221", 
				"Surrey", 
				"Londres", 
				"Londres", 
				"12438", 
				1));
		
	}

	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return this.usuarios;
	}

	public Usuario getUsuario(Long id) {
		// TODO Auto-generated method stub
		Usuario usuario = null;
		for (Usuario us : usuarios) {
			if(us.getId()==id) {
				usuario = us;
			}
		}
		return usuario;
	}

	public void addUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarios.add(usuario);
	}

	public void updateUsuario(Long id, String name, String apellidoPaterno, String apellidoMaterno, String correo,
			String contra, String telefono, String fechaNacimiento, String fotoPerfil, String domicilio, String colonia,
			String ciudad, String estado, String codigoPostal, Integer idtipo_usuario) {
		// TODO Auto-generated method stub
		for (Usuario us : usuarios) {
			if(us.getId()==id) {
				if(name != null) us.setName(name);
				if(apellidoPaterno != null) us.setApellidoPaterno(apellidoPaterno);
				if(apellidoMaterno != null) us.setApellidoMaterno(apellidoMaterno);
				if(correo != null) us.setCorreo(correo);
				if(contra != null) us.setContra(contra);
				if(telefono != null)us.setTelefono(telefono);
				if(fechaNacimiento != null) us.setFechaNacimiento(fechaNacimiento);
				if(fotoPerfil !=null)us.setFotoPerfil(fotoPerfil);
				if(domicilio != null) us.setDomicilio(domicilio);
				if(colonia != null)us.setColonia(colonia);
				if(ciudad!=null)us.setCiudad(ciudad);
				if(estado!= null)us.setEstado(estado);
				if(codigoPostal!=null)us.setCodigoPostal(codigoPostal);
				if(idtipo_usuario != null)us.setIdtipo_usuario(idtipo_usuario);
			}
		}
	}

	public void deleteUsuario(Long id) {
		// TODO Auto-generated method stub
		for (Usuario us : usuarios) {
			if(us.getId()==id) {
				usuarios.remove(us);
				break;
			}
		}
	}
	
	
}
