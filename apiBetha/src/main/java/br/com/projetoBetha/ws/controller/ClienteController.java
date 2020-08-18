package br.com.projetoBetha.ws.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetoBetha.ws.model.Cliente;
import br.com.projetoBetha.ws.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(method=RequestMethod.POST, value="/clientes", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> CadastrarCliente(@RequestBody Cliente cliente) {
		
		Cliente clienteCadastrado = clienteService.Cadastrar(cliente);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> BuscarTodosClientes() {
		
		Collection<Cliente> clientesBuscados = clienteService.buscarTodos();
		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/clientes/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> BuscarClienteId(@PathVariable Integer id) {
		
		Cliente clienteBuscado = clienteService.BuscarPorId(id);
		return new ResponseEntity<>(clienteBuscado, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/clientes/{id}")
	public ResponseEntity<Cliente> ExcluirCliente(@PathVariable Integer id) {
		
		Cliente clienteEncontrado = clienteService.BuscarPorId(id);
		
		if (clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			clienteService.Excluir(clienteEncontrado);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@RequestMapping(method=RequestMethod.PUT, value="/clientes", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> AlterarCliente(@RequestBody Cliente cliente) {
		
		Cliente clienteAlterado = clienteService.Alterar(cliente);
		return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
	}

}
