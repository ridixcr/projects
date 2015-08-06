package org.edessco.sva.be;
// Generated 27-may-2015 1:26:58 by Hibernate Tools 4.3.1


import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * MatrizRecoleccionDatos generated by hbm2java
 */
@Component
public class MatrizRecoleccionDatos  implements java.io.Serializable {


     private Long idmatriz;
     private Autoevaluacion autoevaluacion;
     private Estandar estandar;
     private Date fechaRegistro;
     private boolean resultadoComiteInterno;
     private boolean resultadoEncuestaDocente;
     private boolean resultadoEncuestaAdministrativo;
     private boolean resultadoEncuestaEgresado;
     private boolean resultadoEncuestaEstudiante;
     private boolean resultadoEncuestaGrupoint;
     private boolean resultadoCuestionario;
     private boolean resultadoInformeSgc;
     private boolean resultadoFinal;
     private String observacion;
     private Boolean estado = new Boolean(false);

    public MatrizRecoleccionDatos() {
        setIdmatriz(new Long(0));
    }

	
    public MatrizRecoleccionDatos(Autoevaluacion autoevaluacion, Estandar estandar, boolean resultadoFinal) {
        this.autoevaluacion = autoevaluacion;
        this.estandar = estandar;
        this.resultadoFinal = resultadoFinal;
    }
    public MatrizRecoleccionDatos(Autoevaluacion autoevaluacion, Estandar estandar, Date fechaRegistro, boolean resultadoComiteInterno, boolean resultadoEncuestaDocente, boolean resultadoEncuestaAdministrativo, boolean resultadoEncuestaEgresado, boolean resultadoEncuestaEstudiante, boolean resultadoEncuestaGrupoint, boolean resultadoCuestionario, boolean resultadoInformeSgc, boolean resultadoFinal, String observacion, Boolean estado) {
       this.autoevaluacion = autoevaluacion;
       this.estandar = estandar;
       this.fechaRegistro = fechaRegistro;
       this.resultadoComiteInterno = resultadoComiteInterno;
       this.resultadoEncuestaDocente = resultadoEncuestaDocente;
       this.resultadoEncuestaAdministrativo = resultadoEncuestaAdministrativo;
       this.resultadoEncuestaEgresado = resultadoEncuestaEgresado;
       this.resultadoEncuestaEstudiante = resultadoEncuestaEstudiante;
       this.resultadoEncuestaGrupoint = resultadoEncuestaGrupoint;
       this.resultadoCuestionario = resultadoCuestionario;
       this.resultadoInformeSgc = resultadoInformeSgc;
       this.resultadoFinal = resultadoFinal;
       this.observacion = observacion;
       this.estado = estado;
    }
   
    public Long getIdmatriz() {
        return this.idmatriz;
    }
    
    public void setIdmatriz(Long idmatriz) {
        this.idmatriz = idmatriz;
    }
    public Autoevaluacion getAutoevaluacion() {
        return this.autoevaluacion;
    }
    
    public void setAutoevaluacion(Autoevaluacion autoevaluacion) {
        this.autoevaluacion = autoevaluacion;
    }
    public Estandar getEstandar() {
        return this.estandar;
    }
    
    public void setEstandar(Estandar estandar) {
        this.estandar = estandar;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public boolean getResultadoComiteInterno() {
        return this.resultadoComiteInterno;
    }
    
    public void setResultadoComiteInterno(boolean resultadoComiteInterno) {
        this.resultadoComiteInterno = resultadoComiteInterno;
    }
    public boolean getResultadoEncuestaDocente() {
        return this.resultadoEncuestaDocente;
    }
    
    public void setResultadoEncuestaDocente(boolean resultadoEncuestaDocente) {
        this.resultadoEncuestaDocente = resultadoEncuestaDocente;
    }
    public boolean getResultadoEncuestaAdministrativo() {
        return this.resultadoEncuestaAdministrativo;
    }
    
    public void setResultadoEncuestaAdministrativo(boolean resultadoEncuestaAdministrativo) {
        this.resultadoEncuestaAdministrativo = resultadoEncuestaAdministrativo;
    }
    public boolean getResultadoEncuestaEgresado() {
        return this.resultadoEncuestaEgresado;
    }
    
    public void setResultadoEncuestaEgresado(boolean resultadoEncuestaEgresado) {
        this.resultadoEncuestaEgresado = resultadoEncuestaEgresado;
    }
    public boolean getResultadoEncuestaEstudiante() {
        return this.resultadoEncuestaEstudiante;
    }
    
    public void setResultadoEncuestaEstudiante(boolean resultadoEncuestaEstudiante) {
        this.resultadoEncuestaEstudiante = resultadoEncuestaEstudiante;
    }
    public boolean getResultadoEncuestaGrupoint() {
        return this.resultadoEncuestaGrupoint;
    }
    
    public void setResultadoEncuestaGrupoint(boolean resultadoEncuestaGrupoint) {
        this.resultadoEncuestaGrupoint = resultadoEncuestaGrupoint;
    }
    public boolean getResultadoCuestionario() {
        return this.resultadoCuestionario;
    }
    
    public void setResultadoCuestionario(boolean resultadoCuestionario) {
        this.resultadoCuestionario = resultadoCuestionario;
    }
    public boolean getResultadoInformeSgc() {
        return this.resultadoInformeSgc;
    }
    
    public void setResultadoInformeSgc(boolean resultadoInformeSgc) {
        this.resultadoInformeSgc = resultadoInformeSgc;
    }
    public boolean isResultadoFinal() {
        return this.resultadoFinal;
    }
    
    public void setResultadoFinal(boolean resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }




}


