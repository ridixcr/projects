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
import org.edessco.sva.be.Cuestionario;
import org.edessco.sva.be.Estandar;
import org.edessco.sva.be.PreguntaCuestionario;
import org.edessco.sva.bl.PreguntaCuestionarioBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class PreguntaCuestionarioControler {

    @ManagedProperty(value = "#{preguntaCuestionarioBL}")
    private PreguntaCuestionarioBL preguntaCuestionarioBL;
    @ManagedProperty(value = "#{preguntaCuestionario}")
    private PreguntaCuestionario preguntaCuestionario;
    private List<PreguntaCuestionario> listaPreguntasCuestionario = new LinkedList<>();

    public PreguntaCuestionarioControler() {
    }
       
    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getPreguntaCuestionarioBL().registrar(getPreguntaCuestionario())) {
            @Override
            public void proceso() {
                preguntaCuestionario = new PreguntaCuestionario();
                listar();
            }
        });
    }

    @PostConstruct
    public void listar() {
        setListaPreguntasCuestionario(getPreguntaCuestionarioBL().listar(""));
    }
    
    public void actualizar() {
        PreguntaCuestionario temp = new PreguntaCuestionario();
        String msg;
        temp = buscarId();
        
        temp.setCuestionario(this.getPreguntaCuestionario().getCuestionario());
        temp.setEstandar(this.getPreguntaCuestionario().getEstandar());
        temp.setPregunta(this.getPreguntaCuestionario().getPregunta());
        
        long res = getPreguntaCuestionarioBL().actualizar(temp);
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
        PreguntaCuestionario temp = new PreguntaCuestionario();
        String msg;
        temp = buscarId();
        long res = getPreguntaCuestionarioBL().eliminar(temp);
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
    
    public PreguntaCuestionario buscarId() {
        return getPreguntaCuestionarioBL().buscar(getPreguntaCuestionario().getIdpreguntacuestionario());
    }
    
    public void limpiar() {
        this.getPreguntaCuestionario().setIdpreguntacuestionario(null);
        this.getPreguntaCuestionario().setCuestionario(new Cuestionario());
        this.getPreguntaCuestionario().setEstandar(new Estandar());
        this.getPreguntaCuestionario().setPregunta("");
    }
    
    public void obtenerPregunta(){
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sesion.setAttribute("idPreguntaCuestionario", getPreguntaCuestionario().getIdpreguntacuestionario());
    }

    public PreguntaCuestionarioBL getPreguntaCuestionarioBL() {
        return preguntaCuestionarioBL;
    }

    public void setPreguntaCuestionarioBL(PreguntaCuestionarioBL preguntaCuestionarioBL) {
        this.preguntaCuestionarioBL = preguntaCuestionarioBL;
    }

    public PreguntaCuestionario getPreguntaCuestionario() {
        return preguntaCuestionario;
    }

    public void setPreguntaCuestionario(PreguntaCuestionario preguntaCuestionario) {
        this.preguntaCuestionario = preguntaCuestionario;
    }

    public List<PreguntaCuestionario> getListaPreguntasCuestionario() {
        return listaPreguntasCuestionario;
    }

    public void setListaPreguntasCuestionario(List<PreguntaCuestionario> listaPreguntasCuestionario) {
        this.listaPreguntasCuestionario = listaPreguntasCuestionario;
    }
    
}
