package org.edessco.sva.be;
// Generated 27-may-2015 1:26:58 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Cuestionario generated by hbm2java
 */
@Component
public class Cuestionario  implements java.io.Serializable {


     private Long idcuestionario;
     private Autoevaluacion autoevaluacion;
     private String tituloCuestionario;
     private Date fechaHoraInicio;
     private Date fechaHoraFin;
     private Boolean estado;
     private Set<PreguntaCuestionario> preguntaCuestionarios = new HashSet<PreguntaCuestionario>(0);

    public Cuestionario() {
        this.idcuestionario=null;
        this.autoevaluacion = new Autoevaluacion();
    }

	
    public Cuestionario(Autoevaluacion autoevaluacion) {
        this.autoevaluacion = autoevaluacion;
    }
    public Cuestionario(Autoevaluacion autoevaluacion, String tituloCuestionario, Date fechaHoraInicio, Date fechaHoraFin, Boolean estado, Set<PreguntaCuestionario> preguntaCuestionarios) {
       this.autoevaluacion = autoevaluacion;
       this.tituloCuestionario = tituloCuestionario;
       this.fechaHoraInicio = fechaHoraInicio;
       this.fechaHoraFin = fechaHoraFin;
       this.estado = estado;
       this.preguntaCuestionarios = preguntaCuestionarios;
    }
   
    public Long getIdcuestionario() {
        return this.idcuestionario;
    }
    
    public void setIdcuestionario(Long idcuestionario) {
        this.idcuestionario = idcuestionario;
    }
    public Autoevaluacion getAutoevaluacion() {
        return this.autoevaluacion;
    }
    
    public void setAutoevaluacion(Autoevaluacion autoevaluacion) {
        this.autoevaluacion = autoevaluacion;
    }
    public String getTituloCuestionario() {
        return this.tituloCuestionario;
    }
    
    public void setTituloCuestionario(String tituloCuestionario) {
        this.tituloCuestionario = tituloCuestionario;
    }
    public Date getFechaHoraInicio() {
        return this.fechaHoraInicio;
    }
    
    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }
    public Date getFechaHoraFin() {
        return this.fechaHoraFin;
    }
    
    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set<PreguntaCuestionario> getPreguntaCuestionarios() {
        return this.preguntaCuestionarios;
    }
    
    public void setPreguntaCuestionarios(Set<PreguntaCuestionario> preguntaCuestionarios) {
        this.preguntaCuestionarios = preguntaCuestionarios;
    }




}


