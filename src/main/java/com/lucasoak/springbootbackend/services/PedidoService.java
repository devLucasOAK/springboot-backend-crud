package com.lucasoak.springbootbackend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasoak.springbootbackend.domain.Pedido;
import com.lucasoak.springbootbackend.repositories.PedidoRepository;
import com.lucasoak.springbootbackend.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
