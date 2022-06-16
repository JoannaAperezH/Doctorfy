package org.generation.doctorfy.service;

import java.util.List;
import java.util.Optional;

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

	public void signIn(Usuario us) {
		// TODO Auto-generated method stub
		Optional<Usuario> u = usuarioRepository.findByEmail(us.getCorreo());
		if(u.isPresent()) {
			throw new IllegalStateException("El usuario ya existe");
		}else {
			Usuario usuario = new Usuario();
			usuario.setNombre(us.getNombre());
			usuario.setApellidoPaterno(us.getApellidoPaterno());
			usuario.setApellidoMaterno(us.getApellidoMaterno());
			usuario.setCorreo(us.getCorreo());
			if(us.getEspecialidad() != null) usuario.setEspecialidad(us.getEspecialidad());
			String passHash = SHAUtil.createHash(us.getPassword());
			usuario.setPassword(passHash);
			usuarioRepository.save(usuario);
		}
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

}
