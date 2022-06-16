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
			usuario.setCorreo(us.getCorreo());
			if(us.getEspecialidad() != null) usuario.setEspecialidad(us.getEspecialidad());
			String passHash = SHAUtil.createHash(us.getPassword());
			usuario.setPassword(passHash);
			usuarioRepository.save(usuario);
		}
	}

}
