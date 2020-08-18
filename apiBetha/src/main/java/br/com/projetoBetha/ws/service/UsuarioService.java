package br.com.projetoBetha.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import br.com.projetoBetha.ws.model.Usuario;
import br.com.projetoBetha.ws.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario Cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario BuscarPorNome(String nome) {
		return usuarioRepository.buscarPorNome(nome);
	}
}
