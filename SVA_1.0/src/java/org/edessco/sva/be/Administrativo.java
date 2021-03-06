package org.edessco.sva.be;
// Generated 27-may-2015 1:26:58 by Hibernate Tools 4.3.1

import org.springframework.stereotype.Component;




/**
 * Administrativo generated by hbm2java
 */
@Component
public class Administrativo  implements java.io.Serializable {


     private Long idadministrativo;
     private Persona persona;
     private String cargo;
     private String dependencia;
     private String condicionLaboral;
     private String nivelEstudios;

    public Administrativo() {
    }

	
    public Administrativo(Persona persona) {
        this.persona = persona;
    }
    public Administrativo(Persona persona, String cargo, String dependencia, String condicionLaboral, String nivelEstudios) {
       this.persona = persona;
       this.cargo = cargo;
       this.dependencia = dependencia;
       this.condicionLaboral = condicionLaboral;
       this.nivelEstudios = nivelEstudios;
    }
   
    public Long getIdadministrativo() {
        return this.idadministrativo;
    }
    
    public void setIdadministrativo(Long idadministrativo) {
        this.idadministrativo = idadministrativo;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getDependencia() {
        return this.dependencia;
    }
    
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
    public String getCondicionLaboral() {
        return this.condicionLaboral;
    }
    
    public void setCondicionLaboral(String condicionLaboral) {
        this.condicionLaboral = condicionLaboral;
    }
    public String getNivelEstudios() {
        return this.nivelEstudios;
    }
    
    public void setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }




}


