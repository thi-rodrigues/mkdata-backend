package com.mkdata.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mkdata.domain.Cliente;
import com.mkdata.exception.ResourceConstraintViolation;
import com.mkdata.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) throws Throwable {
		Boolean clienteExistente = clienteService.findByCpf(cliente.getCpfCnpj());
		
		if (!clienteExistente)
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
		else
			throw new ResourceConstraintViolation();
	}
	
	@GetMapping
	public Page<Cliente> buscarTodos(Pageable pageable) {
		return clienteService.buscarTodos(pageable);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		clienteService.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Cliente> update(@PathVariable Long codigo, @RequestBody @Valid Cliente cliente) {
		Cliente clienteSalvo = clienteService.update(codigo, cliente);
		return ResponseEntity.ok(clienteService.salvar(clienteSalvo));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.findById(id));
	}
	
}
