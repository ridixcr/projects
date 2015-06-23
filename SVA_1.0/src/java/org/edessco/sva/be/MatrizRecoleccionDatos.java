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
     private Integer resultadoComiteInterno;
     private Integer resultadoEncuestaDocente;
     private Integer resultadoEncuestaAdministrativo;
     private Integer resultadoEncuestaEgresado;
     private Integer resultadoEncuestaEstudiante;
     private Integer resultadoEncuestaGrupoint;
     private Integer resultadoCuestionario;
     private Integer resultadoInformeSgc;
     private boolean resultadoFinal;
     private String observacion;
     private Boolean estado;

    public MatrizRecoleccionDatos() {
    }

	
    public MatrizRecoleccionDatos(Autoevaluacion autoevaluacion, Estandar estandar, boolean resultadoFinal) {
        this.autoevaluacion = autoevaluacion;
        this.estandar = estandar;
        this.resultadoFinal = resultadoFinal;
    }
    public MatrizRecoleccionDatos(Autoevaluacion autoevaluacion, Estandar estandar, Date fechaRegistro, Integer resultadoComiteInterno, Integer resultadoEncuestaDocente, Integer resultadoEncuestaAdministrativo, Integer resultadoEncuestaEgresado, Integer resultadoEncuestaEstudiante, Integer resultadoEncuestaGrupoint, Integer resultadoCuestionario, Integer resultadoInformeSgc, boolean resultadoFinal, String observacion, Boolean estado) {
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
    public Integer getResultadoComiteInterno() {
        return this.resultadoComiteInterno;
    }
    
    public void setResultadoComiteInterno(Integer resultadoComiteInterno) {
        this.resultadoComiteInterno = resultadoComiteInterno;
    }
    public Integer getResultadoEncuestaDocente() {
        return this.resultadoEncuestaDocente;
    }
    
    public void setResultadoEncuestaDocente(Integer resultadoEncuestaDocente) {
        this.resultadoEncuestaDocente = resultadoEncuestaDocente;
    }
    public Integer getResultadoEncuestaAdministrativo() {
        return this.resultadoEncuestaAdministrativo;
    }
    
    public void setResultadoEncuestaAdministrativo(Integer resultadoEncuestaAdministrativo) {
        this.resultadoEncuestaAdministrativo = resultadoEncuestaAdministrativo;
    }
    public Integer getResultadoEncuestaEgresado() {
        return this.resultadoEncuestaEgresado;
    }
    
    public void setResultadoEncuestaEgresado(Integer resultadoEncuestaEgresado) {
        this.resultadoEncuestaEgresado = resultadoEncuestaEgresado;
    }
    public Integer getResultadoEncuestaEstudiante() {
        return this.resultadoEncuestaEstudiante;
    }
    
    public void setResultadoEncuestaEstudiante(Integer resultadoEncuestaEstudiante) {
        this.resultadoEncuestaEstudiante = resultadoEncuestaEstudiante;
    }
    public Integer getResultadoEncuestaGrupoint() {
        return this.resultadoEncuestaGrupoint;
    }
    
    public void setResultadoEncuestaGrupoint(Integer resultadoEncuestaGrupoint) {
        this.resultadoEncuestaGrupoint = resultadoEncuestaGrupoint;
    }
    public Integer getResultadoCuestionario() {
        return this.resultadoCuestionario;
    }
    
    public void setResultadoCuestionario(Integer resultadoCuestionario) {
        this.resultadoCuestionario = resultadoCuestionario;
    }
    public Integer getResultadoInformeSgc() {
        return this.resultadoInformeSgc;
    }
    
    public void setResultadoInformeSgc(Integer resultadoInformeSgc) {
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

