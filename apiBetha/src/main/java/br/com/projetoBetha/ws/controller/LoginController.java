package br.com.projetoBetha.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoBetha.ws.model.Usuario;
import br.com.projetoBetha.ws.service.UsuarioService;

@RestController
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/autenticar", consumes=MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
	public ResponseEntity<Usuario> autenticar(@RequestBody Usuario usuario) {
		
		System.out.println(usuario.getNome() + "-" + usuario.getSenha());
		Usuario usuarioAutenticado = usuarioService.BuscarPorNome(usuario.getNome());
		return new ResponseEntity<Usuario>(usuarioAutenticado, HttpStatus.OK);
	}
}
