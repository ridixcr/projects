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
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import org.edessco.sva.be.Autoevaluacion;
import org.edessco.sva.be.ModeloCalidad;
import org.edessco.sva.be.UnidadAcademica;
import org.edessco.sva.bl.AutoevaluacionBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class AutoevaluacionControler {

    @ManagedProperty(value = "#{autoevaluacionBL}")
    private AutoevaluacionBL autoevaluacionBL;
    @ManagedProperty(value = "#{autoevaluacion}")
    private Autoevaluacion autoevaluacion;
    private List<Autoevaluacion> listaAutoevaluaciones = new LinkedList<>();

    private List<SelectItem> selectOneItemsAutoevaluacion;

    public AutoevaluacionControler() {
    }

    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getAutoevaluacionBL().registrar(getAutoevaluacion())) {
            @Override
            public void proceso() {
                autoevaluacion = new Autoevaluacion();
                listar();
            }
        });
    }

    @PostConstruct
    public void listar() {
        setListaAutoevaluaciones(getAutoevaluacionBL().listar(""));
    }

    public void actualizar() {
        Autoevaluacion temp = new Autoevaluacion();
        String msg;
        temp = buscarId();
        
        temp.setFechaInicio(getAutoevaluacion().getFechaInicio());
        temp.setFechaFin(getAutoevaluacion().getFechaFin());
        temp.setEstado(getAutoevaluacion().getEstado());
        temp.setTitulo(getAutoevaluacion().getTitulo());
        temp.setUnidadAcademica(this.getAutoevaluacion().getUnidadAcademica());
        temp.setModeloCalidad(this.getAutoevaluacion().getModeloCalidad());
        System.out.println("id unidada academica...."+temp.getUnidadAcademica());
        System.out.println("id unidada modelo clidad...."+temp.getModeloCalidad());
        
        long res = getAutoevaluacionBL().actualizar(temp);
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
        Autoevaluacion temp = new Autoevaluacion();
        String msg;
        temp = buscarId();
        long res = getAutoevaluacionBL().eliminar(temp);
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

    public Autoevaluacion buscarId() {
        return autoevaluacionBL.buscar(getAutoevaluacion().getIdautoevaluacion());
    }
    
    public void limpiar() {
        this.autoevaluacion.setIdautoevaluacion(null);
        this.autoevaluacion.setFechaInicio(null);
        this.autoevaluacion.setFechaFin(null);
        this.autoevaluacion.setEstado(false);
        this.autoevaluacion.setUnidadAcademica(new UnidadAcademica());
        this.autoevaluacion.setModeloCalidad(new ModeloCalidad());
        this.autoevaluacion.setTitulo("");
    }

    public AutoevaluacionBL getAutoevaluacionBL() {
        return autoevaluacionBL;
    }

    public void setAutoevaluacionBL(AutoevaluacionBL autoevaluacionBL) {
        this.autoevaluacionBL = autoevaluacionBL;
    }

    public Autoevaluacion getAutoevaluacion() {
        return autoevaluacion;
    }

    public void setAutoevaluacion(Autoevaluacion autoevaluacion) {
        this.autoevaluacion = autoevaluacion;
    }

    public List<Autoevaluacion> getListaAutoevaluaciones() {
        return listaAutoevaluaciones;
    }

    public void setListaAutoevaluaciones(List<Autoevaluacion> listaAutoevaluaciones) {
        this.listaAutoevaluaciones = listaAutoevaluaciones;
    }

    public List<SelectItem> getSelectOneItemsAutoevaluacion() {
        this.selectOneItemsAutoevaluacion = new LinkedList<SelectItem>();
        for (Autoevaluacion autoevaluacion1 : listaAutoevaluaciones) {
            this.setAutoevaluacion(autoevaluacion1);
            SelectItem selectItem = new SelectItem(autoevaluacion.getIdautoevaluacion(), autoevaluacion.getTitulo());
            this.selectOneItemsAutoevaluacion.add(selectItem);
        }
        return selectOneItemsAutoevaluacion;
    }

    public void setSelectOneItemsAutoevaluacion(List<SelectItem> selectOneItemsAutoevaluacion) {
        this.selectOneItemsAutoevaluacion = selectOneItemsAutoevaluacion;
    }
    
}
