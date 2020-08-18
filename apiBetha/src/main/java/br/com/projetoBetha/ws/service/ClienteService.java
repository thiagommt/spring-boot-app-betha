package br.com.projetoBetha.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.projetoBetha.ws.model.Cliente;
import br.com.projetoBetha.ws.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	public Cliente Cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Collection<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public void Excluir (Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	public Cliente BuscarPorId(Integer id) {
		return clienteRepository.findById(id).get();
	}
	
	public Cliente Alterar(Cliente cliente) {
		return clienteRepository.save(cliente);	
	}
}
