package org.edessco.sva.be;
// Generated 17-ene-2015 17:53:31 by Hibernate Tools 3.6.0



/**
 * Egresado generated by hbm2java
 */
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


