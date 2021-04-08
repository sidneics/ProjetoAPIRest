package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.dto.ClienteCadastroDTO;
import br.com.cotiinformatica.dto.ClienteConsultaDTO;
import br.com.cotiinformatica.dto.ClienteEdicaoDTO;
import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.repositories.ClienteRepository;

@Controller
public class ClienteController {

	//definir o ENDPOINT (atributo de valor constante)
	private static final String ENDPOINT = "/api/clientes";	
	
	@Autowired
	private ClienteRepository repository;
	
	@CrossOrigin //habilitando a politica de CORS configurada
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	@ResponseBody //método retorna informações
	public String cadastrarCliente(@RequestBody ClienteCadastroDTO dto) {
		
		try {
			
			//verificar se o cpf informado já está cadastrado..
			if(repository.findByCpf(dto.getCpf()) != null)
				throw new Exception("O cpf informado já encontra-se cadastrado.");
			
			//verificar se o email informado já está cadastrado..
			if(repository.findByEmail(dto.getEmail()) != null)
				throw new Exception("O email informado já encontra-se cadastrado.");
			
			Cliente cliente = new Cliente();
			
			cliente.setNome(dto.getNome());
			cliente.setEmail(dto.getEmail());
			cliente.setCpf(dto.getCpf());
			
			repository.saveOrUpdate(cliente);
			
			return "Cliente cadastrado com sucesso.";
		}
		catch(Exception e) {
			return "Erro: " + e.getMessage();
		}		
	}	
	
	@CrossOrigin //habilitando a politica de CORS configurada
	@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
	@ResponseBody //método retorna informações
	public String atualizarCliente(@RequestBody ClienteEdicaoDTO dto) {
		
		try {
			
			//buscar no banco de dados o cliente atraves do id..
			Cliente cliente = repository.findById(dto.getIdCliente());
			
			//verificar se o cliente foi encontrado..
			if(cliente != null) {
				
				cliente.setNome(dto.getNome());
				repository.saveOrUpdate(cliente);
				
				return "Cliente atualizado com sucesso.";
			}
			else {
				throw new Exception("Cliente não encontrado.");
			}
		}
		catch(Exception e) {
			return "Erro: " + e.getMessage();
		}
	}
	
	@CrossOrigin //habilitando a politica de CORS configurada
	@RequestMapping(value = ENDPOINT + "/{id}", method = RequestMethod.DELETE)
	@ResponseBody //método retorna informações
	public String excluirCliente(@PathVariable("id") Integer id) {
		
		try {
			
			//buscar no banco de dados o cliente atraves do id..
			Cliente cliente = repository.findById(id);
			
			//verificar se o cliente foi encontrado..
			if(cliente != null) {
				
				//excluindo o cliente..
				repository.delete(cliente);
				
				return "Cliente excluido com sucesso.";
			}
			else {
				throw new Exception("Cliente não encontrado.");
			}
		}
		catch(Exception e) {
			return "Erro: " + e.getMessage();
		}
	}
	
	@CrossOrigin //habilitando a politica de CORS configurada
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	@ResponseBody //método retorna informações
	public List<ClienteConsultaDTO> consultarClientes() {
		
		try {
			
			List<ClienteConsultaDTO> lista = new ArrayList<ClienteConsultaDTO>();
			
			//varrer todos os clientes obtidos do banco de dados..
			for(Cliente cliente : repository.findAll()) {
				
				ClienteConsultaDTO dto = new ClienteConsultaDTO();
				dto.setIdCliente(cliente.getIdCliente());
				dto.setNome(cliente.getNome());
				dto.setEmail(cliente.getEmail());
				dto.setCpf(cliente.getCpf());
				
				lista.add(dto);
			}
			
			return lista;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@CrossOrigin //habilitando a politica de CORS configurada
	@RequestMapping(value = ENDPOINT + "/{id}", method = RequestMethod.GET)
	@ResponseBody //método retorna informações
	public ClienteConsultaDTO obterClientePorId(@PathVariable("id") Integer id) {

		try {
			
			//buscar o cliente no banco de dados atraves do id..
			Cliente cliente = repository.findById(id);
			
			//verificando se o cliente foi encontrado
			if(cliente != null) {
				
				ClienteConsultaDTO dto = new ClienteConsultaDTO();
				dto.setIdCliente(cliente.getIdCliente());
				dto.setNome(cliente.getNome());
				dto.setEmail(cliente.getEmail());
				dto.setCpf(cliente.getCpf());
				
				return dto;
			}
			else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			return null;
		}
		
	}
	
}






