/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.cv;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.edessco.sva.be.ModeloCalidad;
import org.edessco.sva.bl.ModeloBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class ModeloCalidadBean {

    @ManagedProperty(value = "#{modeloBL}")
    private ModeloBL modeloBL;
    @ManagedProperty(value = "#{modeloCalidad}")
    private ModeloCalidad modeloCalidad;
    private List<ModeloCalidad> listaModelo = new LinkedList<>();
    
    private List<SelectItem> selectOneItemsModeloCalidad;

    public ModeloCalidadBean() {
    }     

    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getModeloBL().registrar(getModeloCalidad())) {
            @Override
            public void proceso() {
                modeloCalidad = new ModeloCalidad();
                listar();
            }
        });
    }

    @PostConstruct
    public void listar() {
        setListaModelo(getModeloBL().listar());       
    }    

    public void actualizar() {
        ModeloCalidad temp = new ModeloCalidad();
        String msg;
        temp = buscarId();
        
        temp.setTitulo(this.getModeloCalidad().getTitulo());
        temp.setResolucion(this.getModeloCalidad().getResolucion());
        temp.setFechaPublicacion(this.getModeloCalidad().getFechaPublicacion());
        
        long res = getModeloBL().actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listar();
    }
    
    public void eliminar() {
        ModeloCalidad temp = new ModeloCalidad();
        String msg;
        temp = buscarId();
        long res = getModeloBL().eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
              
        listar();
    }
    
    public ModeloCalidad buscarId(){
        return getModeloBL().buscar(getModeloCalidad().getIdmodelocalidad());
    }
    
    public void limpiar(){
        this.modeloCalidad.setIdmodelocalidad(null);
        this.modeloCalidad.setTitulo("");
        this.modeloCalidad.setResolucion("");
        this.modeloCalidad.setFechaPublicacion(null);
    }

    public ModeloBL getModeloBL() {
        return modeloBL;
    }

    public void setModeloBL(ModeloBL modeloBL) {
        this.modeloBL = modeloBL;
    }

    public ModeloCalidad getModeloCalidad() {
        return modeloCalidad;
    }

    public void setModeloCalidad(ModeloCalidad modeloCalidad) {
        this.modeloCalidad = modeloCalidad;
    }

    public List<ModeloCalidad> getListaModelo() {
        return listaModelo;
    }

    public void setListaModelo(List<ModeloCalidad> listaModelo) {
        this.listaModelo = listaModelo;
    }

    public List<SelectItem> getSelectOneItemsModeloCalidad() {
        this.selectOneItemsModeloCalidad = new LinkedList<SelectItem>();
        for (ModeloCalidad modeloCalidad1 : listaModelo) {
            this.setModeloCalidad(modeloCalidad1);
            SelectItem selectItem = new SelectItem(modeloCalidad.getIdmodelocalidad(), modeloCalidad.getTitulo());
            this.selectOneItemsModeloCalidad.add(selectItem);
        }
        return selectOneItemsModeloCalidad;
    }

    public void setSelectOneItemsModeloCalidad(List<SelectItem> selectOneItemsModeloCalidad) {
        this.selectOneItemsModeloCalidad = selectOneItemsModeloCalidad;
    }
    
}
