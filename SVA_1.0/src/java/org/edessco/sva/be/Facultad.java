package org.edessco.sva.be;
// Generated 27-may-2015 1:26:58 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Facultad generated by hbm2java
 */
@Component
public class Facultad  implements java.io.Serializable {


     private Long idfacultad;
     private Universidad universidad;
     private String nombre;
     private Set<UnidadAcademica> unidadAcademicas = new HashSet<UnidadAcademica>(0);

    public Facultad() {
        this.idfacultad = Long.MIN_VALUE;
        this.universidad = new Universidad();
    }

	
    public Facultad(Universidad universidad) {
        this.universidad = universidad;
    }
    public Facultad(Universidad universidad, String nombre, Set<UnidadAcademica> unidadAcademicas) {
       this.universidad = universidad;
       this.nombre = nombre;
       this.unidadAcademicas = unidadAcademicas;
    }
   
    public Long getIdfacultad() {
        return this.idfacultad;
    }
    
    public void setIdfacultad(Long idfacultad) {
        this.idfacultad = idfacultad;
    }
    public Universidad getUniversidad() {
        return this.universidad;
    }
    
    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<UnidadAcademica> getUnidadAcademicas() {
        return this.unidadAcademicas;
    }
    
    public void setUnidadAcademicas(Set<UnidadAcademica> unidadAcademicas) {
        this.unidadAcademicas = unidadAcademicas;
    }




}


