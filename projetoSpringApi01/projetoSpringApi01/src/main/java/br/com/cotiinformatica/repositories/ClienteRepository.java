package br.com.cotiinformatica.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.interfaces.IClienteRepository;

@Service
@Transactional
public class ClienteRepository {

	@Autowired
	private IClienteRepository clienteRepository;

	public void saveOrUpdate(Cliente cliente) throws Exception {
		clienteRepository.save(cliente);
	}

	public void delete(Cliente cliente) throws Exception {
		clienteRepository.delete(cliente);
	}

	public List<Cliente> findAll() throws Exception {
		return (List<Cliente>) clienteRepository.findAll();
	}

	public Cliente findById(Integer idCliente) throws Exception {
		return clienteRepository.findById(idCliente).get();
	}
	
	public Cliente findByCpf(String cpf) throws Exception {
		return clienteRepository.findByCpf(cpf);
	}
	
	public Cliente findByEmail(String email) throws Exception{
		return clienteRepository.findByEmail(email);
	}
}











