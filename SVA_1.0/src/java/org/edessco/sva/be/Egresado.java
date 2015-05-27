package org.edessco.sva.be;
// Generated 27-may-2015 1:26:58 by Hibernate Tools 4.3.1

import org.springframework.stereotype.Component;




/**
 * Egresado generated by hbm2java
 */
@Component
public class Egresado  implements java.io.Serializable {


     private Long idegresado;
     private Persona persona;
     private Integer anioEgreso;

    public Egresado() {
    }

	
    public Egresado(Persona persona) {
        this.persona = persona;
    }
    public Egresado(Persona persona, Integer anioEgreso) {
       this.persona = persona;
       this.anioEgreso = anioEgreso;
    }
   
    public Long getIdegresado() {
        return this.idegresado;
    }
    
    public void setIdegresado(Long idegresado) {
        this.idegresado = idegresado;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Integer getAnioEgreso() {
        return this.anioEgreso;
    }
    
    public void setAnioEgreso(Integer anioEgreso) {
        this.anioEgreso = anioEgreso;
    }




}


