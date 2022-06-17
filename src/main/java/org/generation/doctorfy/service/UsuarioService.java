package org.generation.doctorfy.service;

import java.util.List;
import java.util.Optional;

import org.generation.doctorfy.model.EnfermedadEspecialidad;
import org.generation.doctorfy.model.Usuario;
import org.generation.doctorfy.utils.SHAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	public boolean signIn(Usuario us) {
		// TODO Auto-generated method stub
		boolean result = false;
		Optional<Usuario> u = usuarioRepository.findByEmail(us.getCorreo());
		if(u.isPresent()) {
			throw new IllegalStateException("El usuario ya existe");
		}else {
			/*Usuario usuario = new Usuario();
			usuario.setNombre(us.getNombre());
			usuario.setApellidoPaterno(us.getApellidoPaterno());
			usuario.setApellidoMaterno(us.getApellidoMaterno());
			usuario.setCorreo(us.getCorreo());
			if(us.getEspecialidad() != null) usuario.setEspecialidad(us.getEspecialidad());*/
			String passHash = SHAUtil.createHash(us.getPassword());
			us.setPassword(passHash);
			usuarioRepository.save(us);
			result = true;
		}
		return result;
	}

	public boolean login(String correo, String password) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		Optional<Usuario> u = usuarioRepository.findByEmail(correo);
		
		if(u.isPresent()) {
			//verificar el password
			result = SHAUtil.verifyHash(password, u.get().getPassword());
		}
		
		
		return result;
	}

	public void updateUsuario(Long id, String currentPassword, String newPassword) {
		// TODO Auto-generated method stub
		
		//Usuario user = usuarioRepository.findById(id).get();
		/*System.out.println(SHAUtil.verifyHash(currentPassword, user.getPassword()));
		System.out.println(! SHAUtil.verifyHash(newPassword, user.getPassword()));*/
		
		//String hash = SHAUtil.createHash(user.getPassword());
		
		if (usuarioRepository.findById(id) != null) { //si el usuario existe...
			Usuario user = usuarioRepository.findById(id).get(); //traemos al usuario por id
			
			if ((newPassword !=null) && (currentPassword !=null)) { //si las dos contrasenias son diferentes de null...
				//si el usuario existe, y las contrasenias son distintas de nullo, entonces encriptamos
				
				if ( (SHAUtil.verifyHash(currentPassword, user.getPassword() ) ) &&  //contrasenia actual (viene BD)
					(! SHAUtil.verifyHash(newPassword, user.getPassword()) ) ) { //nueva contrasenia (input del formulario)
					user.setPassword(SHAUtil.createHash(newPassword));	
					usuarioRepository.save(user); //guardo la nueva contrasenia
				} else {
					throw new IllegalStateException("Contraseña incorrecta");	
				}//else // if equals
			}else {
				throw new IllegalStateException("Contraseñas nulas");	
			}//else  // !=null
		}else {
			throw new IllegalStateException("Usuario no encontrado " + id);	
		}//else //if existsById
		
	}

	public void completarPerfil(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String correo,
			String calle, String colonia, String ciudad, String estado, String telefono, String fotoPerfil,
			String cedula, String descripcionCorta, String biografia, Long contador, Double promedio, String whatsapp,
			String universidad, String universidadEspecialidad, String cedulaEspecial, String especialidad,
			EnfermedadEspecialidad enfermedadEspecialidad) {
		// TODO Auto-generated method stub
		
		
		if (usuarioRepository.findById(id) != null) {
			Usuario user = usuarioRepository.findById(id).get();
			if(nombre != null) user.setNombre(nombre);
			if(apellidoPaterno != null) user.setApellidoPaterno(apellidoPaterno);			
			if(apellidoMaterno != null) user.setApellidoMaterno(apellidoMaterno);	
			if(correo != null) user.setCorreo(correo);	
			if(calle != null) user.setCalle(calle);	
			if(colonia != null) user.setColonia(colonia);	
			if(ciudad != null) user.setCiudad(ciudad);	
			if(estado!=null) user.setEstado(estado);
			if(telefono != null) user.setTelefono(telefono);
			if(fotoPerfil!=null) user.setFotoPerfil(fotoPerfil);
			if(cedula != null) user.setCedula(cedulaEspecial);	
			if(descripcionCorta != null) user.setDescripcionCorta(descripcionCorta);	
			if(biografia != null) user.setBiografia(biografia);	
			if(contador != null) user.setContador(contador);	
			if(promedio != null) user.setPromedio(promedio);	
			if(whatsapp != null) user.setWhatsapp(apellidoPaterno);	
			if(universidad != null) user.setUniversidad(universidad);	
			if(universidadEspecialidad != null) user.setUniversidadEspecialidad(universidadEspecialidad);	
			if(cedulaEspecial != null) user.setCedulaEspecial(cedulaEspecial);	
			if(especialidad != null) user.setEspecialidad(especialidad);	
			if(enfermedadEspecialidad != null) user.setEnfermedadEspecialidad(enfermedadEspecialidad);	
			
		}
		
	}

}







