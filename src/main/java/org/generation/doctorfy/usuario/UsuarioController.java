package org.generation.doctorfy.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/usuarios/")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	@Autowired
	public  UsuarioController(UsuarioService usuarioService) {
		// TODO Auto-generated method stub
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	@GetMapping(path = "{id}")
	public Usuario getUsuario(@PathVariable("id") Long id) {
		return usuarioService.getUsuario(id);
	}
	
	@PostMapping
	public void addUsuario(@RequestBody Usuario usuario) {
		usuarioService.addUsuario(usuario);
	}
	
	@PutMapping(path = "{id}")
	public void updateUsuario(@PathVariable("id") Long id, 
			@RequestParam (required = false) String name,
			@RequestParam (required = false) String apellidoPaterno,
			@RequestParam (required = false) String apellidoMaterno,
			@RequestParam (required = false) String correo,
			@RequestParam (required = false) String contra,
			@RequestParam (required = false) String telefono,
			@RequestParam (required = false) String fechaNacimiento,
			@RequestParam (required = false) String fotoPerfil,
			@RequestParam (required = false) String domicilio,
			@RequestParam (required = false) String colonia,
			@RequestParam (required = false) String ciudad,
			@RequestParam (required = false) String estado,
			@RequestParam (required = false) String codigoPostal,
			@RequestParam (required = false) Integer idtipo_usuario
			) {
		usuarioService.updateUsuario(id,name,apellidoPaterno,apellidoMaterno,correo,contra,telefono,fechaNacimiento, fotoPerfil, domicilio,colonia,ciudad,estado,codigoPostal,idtipo_usuario);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteUsuario(@PathVariable("id") Long id) {
		usuarioService.deleteUsuario(id);
	}
	
}
