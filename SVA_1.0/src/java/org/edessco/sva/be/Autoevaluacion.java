package org.edessco.sva.be;
// Generated 27-may-2015 1:26:58 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Autoevaluacion generated by hbm2java
 */
@Component
public class Autoevaluacion implements java.io.Serializable {

    private Long idautoevaluacion;
    private ModeloCalidad modeloCalidad;
    private UnidadAcademica unidadAcademica;
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean estado;
    private String titulo;
    private Set<Encuesta> encuestas = new HashSet<Encuesta>(0);
    private Set<Cuestionario> cuestionarios = new HashSet<Cuestionario>(0);
    private Set<IniciativaMejora> iniciativaMejoras = new HashSet<IniciativaMejora>(0);
    private Set<MatrizRecoleccionDatos> matrizRecoleccionDatoses = new HashSet<MatrizRecoleccionDatos>(0);
    private Set<RegistroGradoCumplimiento> registroGradoCumplimientos = new HashSet<RegistroGradoCumplimiento>(0);
    private Set<RegistroResultado> registroResultados = new HashSet<RegistroResultado>(0);

    public Autoevaluacion() {
        this.idautoevaluacion = Long.MIN_VALUE;
        this.modeloCalidad = new ModeloCalidad();
        this.unidadAcademica = new UnidadAcademica();
    }

    public Autoevaluacion(ModeloCalidad modeloCalidad, UnidadAcademica unidadAcademica) {
        this.modeloCalidad = modeloCalidad;
        this.unidadAcademica = unidadAcademica;
    }

    public Autoevaluacion(ModeloCalidad modeloCalidad, UnidadAcademica unidadAcademica, Date fechaInicio, Date fechaFin, Boolean estado, String titulo, Set<Encuesta> encuestas, Set<Cuestionario> cuestionarios, Set<IniciativaMejora> iniciativaMejoras, Set<MatrizRecoleccionDatos> matrizRecoleccionDatoses, Set<RegistroGradoCumplimiento> registroGradoCumplimientos, Set<RegistroResultado> registroResultados) {
        this.modeloCalidad = modeloCalidad;
        this.unidadAcademica = unidadAcademica;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.titulo = titulo;
        this.encuestas = encuestas;
        this.cuestionarios = cuestionarios;
        this.iniciativaMejoras = iniciativaMejoras;
        this.matrizRecoleccionDatoses = matrizRecoleccionDatoses;
        this.registroGradoCumplimientos = registroGradoCumplimientos;
        this.registroResultados = registroResultados;
    }

    public Long getIdautoevaluacion() {
        return this.idautoevaluacion;
    }

    public void setIdautoevaluacion(Long idautoevaluacion) {
        this.idautoevaluacion = idautoevaluacion;
    }

    public ModeloCalidad getModeloCalidad() {
        return this.modeloCalidad;
    }

    public void setModeloCalidad(ModeloCalidad modeloCalidad) {
        this.modeloCalidad = modeloCalidad;
    }

    public UnidadAcademica getUnidadAcademica() {
        return this.unidadAcademica;
    }

    public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Encuesta> getEncuestas() {
        return this.encuestas;
    }

    public void setEncuestas(Set<Encuesta> encuestas) {
        this.encuestas = encuestas;
    }

    public Set<Cuestionario> getCuestionarios() {
        return this.cuestionarios;
    }

    public void setCuestionarios(Set<Cuestionario> cuestionarios) {
        this.cuestionarios = cuestionarios;
    }

    public Set<IniciativaMejora> getIniciativaMejoras() {
        return this.iniciativaMejoras;
    }

    public void setIniciativaMejoras(Set<IniciativaMejora> iniciativaMejoras) {
        this.iniciativaMejoras = iniciativaMejoras;
    }

    public Set<MatrizRecoleccionDatos> getMatrizRecoleccionDatoses() {
        return this.matrizRecoleccionDatoses;
    }

    public void setMatrizRecoleccionDatoses(Set<MatrizRecoleccionDatos> matrizRecoleccionDatoses) {
        this.matrizRecoleccionDatoses = matrizRecoleccionDatoses;
    }

    public Set<RegistroGradoCumplimiento> getRegistroGradoCumplimientos() {
        return this.registroGradoCumplimientos;
    }

    public void setRegistroGradoCumplimientos(Set<RegistroGradoCumplimiento> registroGradoCumplimientos) {
        this.registroGradoCumplimientos = registroGradoCumplimientos;
    }

    public Set<RegistroResultado> getRegistroResultados() {
        return this.registroResultados;
    }

    public void setRegistroResultados(Set<RegistroResultado> registroResultados) {
        this.registroResultados = registroResultados;
    }

}
