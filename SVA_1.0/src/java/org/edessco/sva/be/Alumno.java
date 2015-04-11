package org.edessco.sva.be;
// Generated 17-ene-2015 17:53:31 by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Alumno generated by hbm2java
 */
public class Alumno  implements java.io.Serializable {


     private Long idalumno;
     private Persona persona;
     private String codigo;
     private String serie;
     private Date fechaIngreso;

    public Alumno() {
    }

	
    public Alumno(Persona persona, String codigo) {
        this.persona = persona;
        this.codigo = codigo;
    }
    public Alumno(Persona persona, String codigo, String serie, Date fechaIngreso) {
       this.persona = persona;
       this.codigo = codigo;
       this.serie = serie;
       this.fechaIngreso = fechaIngreso;
    }
   
    public Long getIdalumno() {
        return this.idalumno;
    }
    
    public void setIdalumno(Long idalumno) {
        this.idalumno = idalumno;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getSerie() {
        return this.serie;
    }
    
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }




}


