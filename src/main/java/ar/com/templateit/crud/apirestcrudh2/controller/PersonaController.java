package ar.com.templateit.crud.apirestcrudh2.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import ar.com.templateit.crud.apirestcrudh2.model.Persona;
import ar.com.templateit.crud.apirestcrudh2.repository.PersonaRespository;

@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping({"/api"})
public class PersonaController {
  @Autowired
  PersonaRespository personaRepository;
  
  @GetMapping({"/personas"})
  public List<Persona> getAllPersonas() {
    List<Persona> personas = new ArrayList<>();
    this.personaRepository.findAll().forEach(personas::add);
    return personas;
  }
  
  @GetMapping({"/personas/{id}"})
  public Persona getPersonaById(@PathVariable long id) {
    Persona persona = null;
    Optional<Persona> personaOptional = this.personaRepository.findById(Long.valueOf(id));
    if (personaOptional.isPresent())
      persona = personaOptional.get(); 
    return persona;
  }
  
  @PostMapping({"/personas"})
  public Persona createPersona(@RequestBody Persona persona) {
    Persona personaBD = null;
    try {
      personaBD = (Persona)this.personaRepository
        .save(new Persona(persona.getApellido(), persona.getNombres(), persona.getEmail()));
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return personaBD;
  }
  
  @PutMapping({"/personas/{id}"})
  public Persona updatePersona(@PathVariable long id, @RequestBody Persona persona) {
    Persona personaBD = null;
    Optional<Persona> optionalPersona = this.personaRepository.findById(Long.valueOf(id));
    if (optionalPersona.isPresent()) {
      personaBD = optionalPersona.get();
      personaBD.setApellido(persona.getApellido());
      personaBD.setNombres(persona.getNombres());
      personaBD.setEmail(persona.getEmail());
      personaBD = (Persona)this.personaRepository.save(personaBD);
    } 
    return personaBD;
  }
  
  @DeleteMapping({"/personas/{id}"})
  public void deletePersona(@PathVariable long id) {
    try {
      this.personaRepository.deleteById(Long.valueOf(id));
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}

