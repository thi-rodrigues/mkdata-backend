package com.mkdata.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mkdata.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(value = "SELECT * from Cliente WHERE ativo = 1 ", nativeQuery = true)
	public Page<Cliente> buscarTodos(Pageable pageable);
	
	public Optional<Cliente> findByCpfCnpj(String cpfCnpj);
	
}
