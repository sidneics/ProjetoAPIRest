package br.com.cotiinformatica.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Integer> {

	/*
	 * JPQL -> Java Persistence Query Language Linguagem Java (JPA) para consultas
	 * orientadas a objetos.
	 */

	// método para consultar 1 cliente atraves do cpf
	@Query("select c from Cliente c where c.cpf = :param")
	public Cliente findByCpf(@Param("param") String cpf);

	// método para consultar 1 cliente atraves do email
	@Query("select c from Cliente c where c.email = :param")
	public Cliente findByEmail(@Param("param") String email);
}
