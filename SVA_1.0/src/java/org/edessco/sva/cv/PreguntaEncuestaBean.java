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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import org.edessco.sva.be.Encuesta;
import org.edessco.sva.be.Estandar;
import org.edessco.sva.be.PreguntaEncuesta;
import org.edessco.sva.bl.PreguntaEncuestaBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;
import org.primefaces.event.RowEditEvent;


/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class PreguntaEncuestaBean {

    @ManagedProperty(value = "#{preguntaEncuestaBL}")
    private PreguntaEncuestaBL preguntaEncuestaBL;
    @ManagedProperty(value = "#{preguntaEncuesta}")
    private PreguntaEncuesta preguntaEncuesta;
    private List<PreguntaEncuesta> listaPreguntasEncuestas = new LinkedList<>();

    public PreguntaEncuestaBean() {
    }
       
    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getPreguntaEncuestaBL().registrar(getPreguntaEncuesta())) {
            @Override
            public void proceso() {
                preguntaEncuesta = new PreguntaEncuesta();
                listar();
            }
        });
    }

    @PostConstruct
    public void listar() {
        setListaPreguntasEncuestas(getPreguntaEncuestaBL().listar(""));
    }
    
    public void actualizar() {
        PreguntaEncuesta temp = new PreguntaEncuesta();
        String msg;
        temp = buscarId();
        
        temp.setEncuesta(this.getPreguntaEncuesta().getEncuesta());
        temp.setEstandar(this.getPreguntaEncuesta().getEstandar());
        temp.setPregunta(this.getPreguntaEncuesta().getPregunta());
        
        long res = getPreguntaEncuestaBL().actualizar(temp);
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
        PreguntaEncuesta temp = new PreguntaEncuesta();
        String msg;
        temp = buscarId();
        long res = getPreguntaEncuestaBL().eliminar(temp);
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
    
    public PreguntaEncuesta buscarId() {
        return getPreguntaEncuestaBL().buscar(getPreguntaEncuesta().getIdpreguntaencuesta());
    }
    
    public void limpiar() {
        this.preguntaEncuesta.setIdpreguntaencuesta(null);
        this.preguntaEncuesta.setEncuesta(new Encuesta());
        this.preguntaEncuesta.setEstandar(new Estandar());
        this.preguntaEncuesta.setPregunta("");
    }
    
    public void obtenerPregunta(){
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sesion.setAttribute("idPreguntaEncuesta", getPreguntaEncuesta().getIdpreguntaencuesta());
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Respuesta guardada", preguntaEncuesta.getPregunta());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion cancelada", preguntaEncuesta.getPregunta());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public PreguntaEncuestaBL getPreguntaEncuestaBL() {
        return preguntaEncuestaBL;
    }

    public void setPreguntaEncuestaBL(PreguntaEncuestaBL preguntaEncuestaBL) {
        this.preguntaEncuestaBL = preguntaEncuestaBL;
    }

    public PreguntaEncuesta getPreguntaEncuesta() {
        return preguntaEncuesta;
    }

    public void setPreguntaEncuesta(PreguntaEncuesta preguntaEncuesta) {
        this.preguntaEncuesta = preguntaEncuesta;
    }

    public List<PreguntaEncuesta> getListaPreguntasEncuestas() {
        return listaPreguntasEncuestas;
    }

    public void setListaPreguntasEncuestas(List<PreguntaEncuesta> listaPreguntasEncuestas) {
        this.listaPreguntasEncuestas = listaPreguntasEncuestas;
    }
    
}
