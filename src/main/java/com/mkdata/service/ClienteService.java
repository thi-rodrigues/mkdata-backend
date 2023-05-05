package com.mkdata.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mkdata.domain.Cliente;
import com.mkdata.exception.ResourceConstraintViolation;
import com.mkdata.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		if (!findByCpf(cliente.getCpfCnpj()))
			return clienteRepository.save(cliente);
		return null;
	}

	public Page<Cliente> buscarTodos(Pageable pageable) {
		return clienteRepository.buscarTodos(pageable);
	}

	public void deleteById(Long codigo) {
		clienteRepository.deleteById(codigo);
	}

	public Cliente update(Long id, Cliente pessoa) {
		Cliente pessoaSalva = findById(id);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return clienteRepository.save(pessoaSalva);
	}
	
	public Cliente findById(Long codigo) {
		Cliente pessoaSalva = clienteRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return pessoaSalva;
	}
	
	public Boolean findByCpf(String cpf) {
		return clienteRepository.findByCpfCnpj(cpf).isPresent();
	}
	
}