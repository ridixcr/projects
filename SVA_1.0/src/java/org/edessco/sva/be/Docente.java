package org.edessco.sva.be;
// Generated 17-ene-2015 17:53:31 by Hibernate Tools 3.6.0



/**
 * Docente generated by hbm2java
 */
public class Docente  implements java.io.Serializable {


     private Long iddocente;
     private Persona persona;
     private String gradoAcademico;
     private String condicion;
     private String categoria;

    public Docente() {
    }

    public Docente(Persona persona, String gradoAcademico, String condicion, String categoria) {
       this.persona = persona;
       this.gradoAcademico = gradoAcademico;
       this.condicion = condicion;
       this.categoria = categoria;
    }
   
    public Long getIddocente() {
        return this.iddocente;
    }
    
    public void setIddocente(Long iddocente) {
        this.iddocente = iddocente;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getGradoAcademico() {
        return this.gradoAcademico;
    }
    
    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }
    public String getCondicion() {
        return this.condicion;
    }
    
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }




}


