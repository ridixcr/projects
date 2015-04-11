package org.edessco.sva.be;
// Generated 17-ene-2015 17:53:31 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * PreguntaCuestionario generated by hbm2java
 */
@Component
public class PreguntaCuestionario  implements java.io.Serializable {


     private Long idpreguntacuestionario;
     private Cuestionario cuestionario;
     private Estandar estandar;
     private String pregunta;
     private String ayuda;
     private Boolean estado;
     private Set<RespuestaCuestionario> respuestaCuestionarios = new HashSet<RespuestaCuestionario>(0);

    public PreguntaCuestionario() {
        this.idpreguntacuestionario = null;
        this.cuestionario = new Cuestionario();
        this.estandar = new Estandar();
    }

	
    public PreguntaCuestionario(Cuestionario cuestionario, Estandar estandar) {
        this.cuestionario = cuestionario;
        this.estandar = estandar;
    }
    public PreguntaCuestionario(Cuestionario cuestionario, Estandar estandar, String pregunta, String ayuda, Boolean estado, Set<RespuestaCuestionario> respuestaCuestionarios) {
       this.cuestionario = cuestionario;
       this.estandar = estandar;
       this.pregunta = pregunta;
       this.ayuda = ayuda;
       this.estado = estado;
       this.respuestaCuestionarios = respuestaCuestionarios;
    }
   
    public Long getIdpreguntacuestionario() {
        return this.idpreguntacuestionario;
    }
    
    public void setIdpreguntacuestionario(Long idpreguntacuestionario) {
        this.idpreguntacuestionario = idpreguntacuestionario;
    }
    public Cuestionario getCuestionario() {
        return this.cuestionario;
    }
    
    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }
    public Estandar getEstandar() {
        return this.estandar;
    }
    
    public void setEstandar(Estandar estandar) {
        this.estandar = estandar;
    }
    public String getPregunta() {
        return this.pregunta;
    }
    
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public String getAyuda() {
        return this.ayuda;
    }
    
    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set<RespuestaCuestionario> getRespuestaCuestionarios() {
        return this.respuestaCuestionarios;
    }
    
    public void setRespuestaCuestionarios(Set<RespuestaCuestionario> respuestaCuestionarios) {
        this.respuestaCuestionarios = respuestaCuestionarios;
    }




}


