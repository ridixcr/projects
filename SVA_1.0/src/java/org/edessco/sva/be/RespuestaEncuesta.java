package org.edessco.sva.be;
// Generated 17-ene-2015 17:53:31 by Hibernate Tools 3.6.0


import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * RespuestaEncuesta generated by hbm2java
 */
@Component
public class RespuestaEncuesta  implements java.io.Serializable {


     private Long idrespuestaencuesta;
     private PreguntaEncuesta preguntaEncuesta;
     private Usuario usuario;
     private String respuesta;
     private Date fechaHora;
     private Boolean estado;

    public RespuestaEncuesta() {
        this.idrespuestaencuesta = null;
        this.preguntaEncuesta = new PreguntaEncuesta();
    }

	
    public RespuestaEncuesta(PreguntaEncuesta preguntaEncuesta) {
        this.preguntaEncuesta = preguntaEncuesta;
    }
    public RespuestaEncuesta(PreguntaEncuesta preguntaEncuesta, Usuario usuario, String respuesta, Date fechaHora) {
       this.preguntaEncuesta = preguntaEncuesta;
       this.usuario = usuario;
       this.respuesta = respuesta;
       this.fechaHora = fechaHora;
    }
   
    public Long getIdrespuestaencuesta() {
        return this.idrespuestaencuesta;
    }
    
    public void setIdrespuestaencuesta(Long idrespuestaencuesta) {
        this.idrespuestaencuesta = idrespuestaencuesta;
    }
    public PreguntaEncuesta getPreguntaEncuesta() {
        return this.preguntaEncuesta;
    }
    
    public void setPreguntaEncuesta(PreguntaEncuesta preguntaEncuesta) {
        this.preguntaEncuesta = preguntaEncuesta;
    }
    public String getRespuesta() {
        return this.respuesta;
    }
    
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public Date getFechaHora() {
        return this.fechaHora;
    }
    
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }




}


