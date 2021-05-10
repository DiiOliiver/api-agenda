package com.agenda.apiagenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.apiagenda.model.entities.Contato;
import com.agenda.apiagenda.model.repositories.ContatoRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ContatoController {
	@Autowired
	ContatoRepository contatoRepository;
	
	@GetMapping(path = "/contatos")
	public List<Contato> listarContatos() {
		return contatoRepository.findAll();
	}
	
	@GetMapping(path = "/contato/{id}")
	public Contato listarContato(@PathVariable long id) {
		return contatoRepository.findById(id);
	}

	@PostMapping(path = "/contato")
	public Contato criarContatoNovo(@RequestBody Contato contato) {
		return contatoRepository.save(contato); 
	}
	
	@DeleteMapping(path = "/contato/{id}")
	public void deletarContato(@PathVariable long id) {
		Contato contato = contatoRepository.findById(id);
		contatoRepository.delete(contato);
	}
	
	@PutMapping(path = "/contato")
	public Contato editarContato(@RequestBody Contato contato) {
		boolean contatoExiste = contatoRepository.existsById(contato.getId());
		if (contatoExiste) {
			return contatoRepository.save(contato);
		}
		
		return contato;
	}
}
