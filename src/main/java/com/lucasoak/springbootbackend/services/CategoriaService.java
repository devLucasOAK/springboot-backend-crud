package com.lucasoak.springbootbackend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasoak.springbootbackend.domain.Categoria;
import com.lucasoak.springbootbackend.repositories.CategoriaRepository;
import com.lucasoak.springbootbackend.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		
		find(obj.getId());
		return repo.save(obj);
	}
}
