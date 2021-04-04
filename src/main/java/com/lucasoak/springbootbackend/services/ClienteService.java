package com.lucasoak.springbootbackend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasoak.springbootbackend.domain.Cliente;
import com.lucasoak.springbootbackend.repositories.ClienteRepository;
import com.lucasoak.springbootbackend.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
