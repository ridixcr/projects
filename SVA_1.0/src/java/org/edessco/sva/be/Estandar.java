package org.edessco.sva.be;
// Generated 27-may-2015 1:26:58 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Estandar generated by hbm2java
 */
@Component
public class Estandar  implements java.io.Serializable {


     private Long idestandar;
     private Criterio criterio;
     private long idUnidadacademica;
     private Integer numeroEstandar;
     private String titulo;
     private String descripcion;
     private String tipoEstandar;
     private Boolean estado;
     private Set<PreguntaCuestionario> preguntaCuestionarios = new HashSet<PreguntaCuestionario>(0);
     private Set<IniciativaMejora> iniciativaMejoras = new HashSet<IniciativaMejora>(0);
     private Set<PreguntaEncuesta> preguntaEncuestas = new HashSet<PreguntaEncuesta>(0);
     private Set<RegistroGradoCumplimiento> registroGradoCumplimientos = new HashSet<RegistroGradoCumplimiento>(0);
     private Set<MatrizRecoleccionDatos> matrizRecoleccionDatoses = new HashSet<MatrizRecoleccionDatos>(0);
     private Set<RegistroResultado> registroResultados = new HashSet<RegistroResultado>(0);

    public Estandar() {
        this.idestandar = Long.MIN_VALUE;
        this.criterio = new Criterio();
    }

	
    public Estandar(Criterio criterio, long idUnidadacademica) {
        this.criterio = criterio;
        this.idUnidadacademica = idUnidadacademica;
    }
    public Estandar(Criterio criterio, long idUnidadacademica, Integer numeroEstandar, String titulo, String descripcion, String tipoEstandar, Boolean estado, Set<PreguntaCuestionario> preguntaCuestionarios, Set<IniciativaMejora> iniciativaMejoras, Set<PreguntaEncuesta> preguntaEncuestas, Set<RegistroGradoCumplimiento> registroGradoCumplimientos, Set<MatrizRecoleccionDatos> matrizRecoleccionDatoses, Set<RegistroResultado> registroResultados) {
       this.criterio = criterio;
       this.idUnidadacademica = idUnidadacademica;
       this.numeroEstandar = numeroEstandar;
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.tipoEstandar = tipoEstandar;
       this.estado = estado;
       this.preguntaCuestionarios = preguntaCuestionarios;
       this.iniciativaMejoras = iniciativaMejoras;
       this.preguntaEncuestas = preguntaEncuestas;
       this.registroGradoCumplimientos = registroGradoCumplimientos;
       this.matrizRecoleccionDatoses = matrizRecoleccionDatoses;
       this.registroResultados = registroResultados;
    }
   
    public Long getIdestandar() {
        return this.idestandar;
    }
    
    public void setIdestandar(Long idestandar) {
        this.idestandar = idestandar;
    }
    public Criterio getCriterio() {
        return this.criterio;
    }
    
    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }
    public long getIdUnidadacademica() {
        return this.idUnidadacademica;
    }
    
    public void setIdUnidadacademica(long idUnidadacademica) {
        this.idUnidadacademica = idUnidadacademica;
    }
    public Integer getNumeroEstandar() {
        return this.numeroEstandar;
    }
    
    public void setNumeroEstandar(Integer numeroEstandar) {
        this.numeroEstandar = numeroEstandar;
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
    public String getTipoEstandar() {
        return this.tipoEstandar;
    }
    
    public void setTipoEstandar(String tipoEstandar) {
        this.tipoEstandar = tipoEstandar;
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
    public Set<IniciativaMejora> getIniciativaMejoras() {
        return this.iniciativaMejoras;
    }
    
    public void setIniciativaMejoras(Set<IniciativaMejora> iniciativaMejoras) {
        this.iniciativaMejoras = iniciativaMejoras;
    }
    public Set<PreguntaEncuesta> getPreguntaEncuestas() {
        return this.preguntaEncuestas;
    }
    
    public void setPreguntaEncuestas(Set<PreguntaEncuesta> preguntaEncuestas) {
        this.preguntaEncuestas = preguntaEncuestas;
    }
    public Set<RegistroGradoCumplimiento> getRegistroGradoCumplimientos() {
        return this.registroGradoCumplimientos;
    }
    
    public void setRegistroGradoCumplimientos(Set<RegistroGradoCumplimiento> registroGradoCumplimientos) {
        this.registroGradoCumplimientos = registroGradoCumplimientos;
    }
    public Set<MatrizRecoleccionDatos> getMatrizRecoleccionDatoses() {
        return this.matrizRecoleccionDatoses;
    }
    
    public void setMatrizRecoleccionDatoses(Set<MatrizRecoleccionDatos> matrizRecoleccionDatoses) {
        this.matrizRecoleccionDatoses = matrizRecoleccionDatoses;
    }
    public Set<RegistroResultado> getRegistroResultados() {
        return this.registroResultados;
    }
    
    public void setRegistroResultados(Set<RegistroResultado> registroResultados) {
        this.registroResultados = registroResultados;
    }




}


