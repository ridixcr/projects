package org.edessco.sva.be;
// Generated 27-may-2015 1:26:58 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Criterio generated by hbm2java
 */
@Component
public class Criterio  implements java.io.Serializable {


     private Long idcriterio;
     private Factor factor;
     private Integer numero;
     private String titulo;
     private String descripcion;
     private Boolean estado;
     private Set<Estandar> estandars = new HashSet<Estandar>(0);

    public Criterio() {
    }

	
    public Criterio(Factor factor) {
        this.factor = factor;
    }
    public Criterio(Factor factor, Integer numero, String titulo, String descripcion, Boolean estado, Set<Estandar> estandars) {
       this.factor = factor;
       this.numero = numero;
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.estado = estado;
       this.estandars = estandars;
    }
   
    public Long getIdcriterio() {
        return this.idcriterio;
    }
    
    public void setIdcriterio(Long idcriterio) {
        this.idcriterio = idcriterio;
    }
    public Factor getFactor() {
        return this.factor;
    }
    
    public void setFactor(Factor factor) {
        this.factor = factor;
    }
    public Integer getNumero() {
        return this.numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set<Estandar> getEstandars() {
        return this.estandars;
    }
    
    public void setEstandars(Set<Estandar> estandars) {
        this.estandars = estandars;
    }




}


