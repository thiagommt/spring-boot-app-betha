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
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/usuarios", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		
		Usuario usuarioCadastrado = usuarioService.Cadastrar(usuario);
		return new ResponseEntity<Usuario>(usuarioCadastrado, HttpStatus.OK);
	}
}
