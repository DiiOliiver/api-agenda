package com.agenda.apiagenda.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.apiagenda.model.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
	Contato findById(long id);
	
	boolean existsById(long id);
}
