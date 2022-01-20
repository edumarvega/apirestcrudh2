package ar.com.templateit.crud.apirestcrudh2.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.templateit.crud.apirestcrudh2.model.Persona;

@Repository
public interface PersonaRespository extends CrudRepository<Persona, Long> {
  Persona findByEmail(String paramString);
}

