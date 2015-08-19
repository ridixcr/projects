package org.edessco.sva.be;
// Generated 27-may-2015 1:26:58 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Universidad generated by hbm2java
 */
@Component
public class Universidad  implements java.io.Serializable {


     private Long iduniversidad;
     private String nombre;
     private Set<Facultad> facultads = new HashSet<Facultad>(0);

    public Universidad() {
        this.iduniversidad = Long.MIN_VALUE;
    }

    public Universidad(String nombre, Set<Facultad> facultads) {
       this.nombre = nombre;
       this.facultads = facultads;
    }
   
    public Long getIduniversidad() {
        return this.iduniversidad;
    }
    
    public void setIduniversidad(Long iduniversidad) {
        this.iduniversidad = iduniversidad;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<Facultad> getFacultads() {
        return this.facultads;
    }
    
    public void setFacultads(Set<Facultad> facultads) {
        this.facultads = facultads;
    }




}


