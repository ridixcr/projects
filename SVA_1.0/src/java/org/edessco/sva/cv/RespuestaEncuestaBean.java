/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.cv;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import org.edessco.sva.be.PreguntaEncuesta;
import org.edessco.sva.be.RespuestaEncuesta;
import org.edessco.sva.bl.RespuestaEncuestaBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class RespuestaEncuestaBean {

    @ManagedProperty(value = "#{respuestaEncuestaBL}")
    private RespuestaEncuestaBL respuestaEncuestaBL;
    @ManagedProperty(value = "#{respuestaEncuesta}")
    private RespuestaEncuesta respuestaEncuesta;
    private List<RespuestaEncuesta> listaRptasEncuestas = new LinkedList<>();

    public RespuestaEncuestaBean() {
    }    
       
    public void registrar() {
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        getRespuestaEncuesta().getPreguntaEncuesta().setIdpreguntaencuesta((Long) sesion.getAttribute("idPreguntaEncuesta"));
        
        setTareaEvento(new Tarea(Tarea.REGISTRO, getRespuestaEncuestaBL().registrar(getRespuestaEncuesta())) {
            @Override
            public void proceso() {
                respuestaEncuesta = new RespuestaEncuesta();
                listar();
            }
        });
        sesion.removeAttribute("idPreguntaEncuesta");
    }

    @PostConstruct
    public void listar() {
        setListaRptasEncuestas(getRespuestaEncuestaBL().listar(""));
    }
    
    public void actualizar() {
        RespuestaEncuesta temp = new RespuestaEncuesta();
        String msg;
        temp = buscarId();
        
        temp.setPreguntaEncuesta(this.getRespuestaEncuesta().getPreguntaEncuesta());
        temp.setIdUsuario(this.getRespuestaEncuesta().getIdUsuario());
        temp.setRespuesta(this.getRespuestaEncuesta().getRespuesta());
        temp.setFechaHora(this.getRespuestaEncuesta().getFechaHora());
        
        long res = getRespuestaEncuestaBL().actualizar(temp);
        if (res == 0) {
            msg = "Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listar();
    }
    
    public void eliminar() {
        RespuestaEncuesta temp = new RespuestaEncuesta();
        String msg;
        temp = buscarId();
        long res = getRespuestaEncuestaBL().eliminar(temp);
        if (res == 0) {
            msg = "Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al eliminar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        listar();
    }
    
    public RespuestaEncuesta buscarId() {
        return getRespuestaEncuestaBL().buscar(getRespuestaEncuesta().getIdrespuestaencuesta());
    }
    
    public void limpiar() {
        this.respuestaEncuesta.setIdrespuestaencuesta(null);
        this.respuestaEncuesta.setPreguntaEncuesta(new PreguntaEncuesta());
        this.respuestaEncuesta.setIdUsuario(null);
        this.respuestaEncuesta.setRespuesta("");
        this.respuestaEncuesta.setFechaHora(null);
    }
    
    public void onRowEdit(RowEditEvent event) {
        //registrar();
        FacesMessage msg = new FacesMessage("Respuesta guardada", respuestaEncuesta.getRespuesta());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion cancelada", respuestaEncuesta.getRespuesta());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public RespuestaEncuestaBL getRespuestaEncuestaBL() {
        return respuestaEncuestaBL;
    }

    public void setRespuestaEncuestaBL(RespuestaEncuestaBL respuestaEncuestaBL) {
        this.respuestaEncuestaBL = respuestaEncuestaBL;
    }

    public RespuestaEncuesta getRespuestaEncuesta() {
        return respuestaEncuesta;
    }

    public void setRespuestaEncuesta(RespuestaEncuesta respuestaEncuesta) {
        this.respuestaEncuesta = respuestaEncuesta;
    }

    public List<RespuestaEncuesta> getListaRptasEncuestas() {
        return listaRptasEncuestas;
    }

    public void setListaRptasEncuestas(List<RespuestaEncuesta> listaRptasEncuestas) {
        this.listaRptasEncuestas = listaRptasEncuestas;
    }
    
}
