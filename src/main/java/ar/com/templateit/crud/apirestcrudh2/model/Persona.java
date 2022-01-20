package ar.com.templateit.crud.apirestcrudh2.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {
  private static final long serialVersionUID = 7319721969757844521L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column(name = "apellido")
  private String apellido;
  
  @Column(name = "nombres")
  private String nombres;
  
  @Column(name = "email")
  private String email;
  
  public Persona() {}
  
  public Persona(String apellido, String nombres, String email) {
    this.apellido = apellido;
    this.nombres = nombres;
    this.email = email;
  }
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getApellido() {
    return this.apellido;
  }
  
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  
  public String getNombres() {
    return this.nombres;
  }
  
  public void setNombres(String nombres) {
    this.nombres = nombres;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public int hashCode() {
    int prime = 31;
    int result = 1;
    result = 31 * result + ((this.id == null) ? 0 : this.id.hashCode());
    return result;
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null)
      return false; 
    if (getClass() != obj.getClass())
      return false; 
    Persona other = (Persona)obj;
    if (this.id == null) {
      if (other.id != null)
        return false; 
    } else if (!this.id.equals(other.id)) {
      return false;
    } 
    return true;
  }
  
  public String toString() {
    return "Persona [id=" + this.id + ", apellido=" + this.apellido + ", nombres=" + this.nombres + ", email=" + this.email + "]";
  }
}

