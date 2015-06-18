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
import org.edessco.sva.be.ComiteInterno;
import org.edessco.sva.be.UnidadAcademica;
import org.edessco.sva.bl.ComiteInternoBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class ComiteInternoControler {
    @ManagedProperty(value = "#{comiteInternoBL}")
    private ComiteInternoBL comiteInternoBL;
    @ManagedProperty(value = "#{comiteInterno}")
    private ComiteInterno comiteInterno;
    private List<ComiteInterno> listaComites = new LinkedList<>();

    private List<SelectItem> selectOneItemsComites;
    
    public ComiteInternoControler() {
    }
    
    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getComiteInternoBL().registrar(getComiteInterno())) {
            @Override
            public void proceso() {
                comiteInterno = new ComiteInterno();
                listar();
            }
        });
    }

    @PostConstruct
    public void listar() {
        setListaComites(getComiteInternoBL().listar(""));
    }
    
    public void actualizar() {
        ComiteInterno temp = new ComiteInterno();
        String msg;
        temp = buscarId();
        
        temp.setNombre(getComiteInterno().getNombre());
        temp.setDocRef(getComiteInterno().getDocRef());
        temp.setFechaCreacion(getComiteInterno().getFechaCreacion());
        temp.setUnidadAcademica(getComiteInterno().getUnidadAcademica());
                
        long res = getComiteInternoBL().actualizar(temp);
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
        ComiteInterno temp = new ComiteInterno();
        String msg;
        temp = buscarId();
        long res = getComiteInternoBL().eliminar(temp);
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

    public ComiteInterno buscarId() {
        return comiteInternoBL.buscar(getComiteInterno().getIdcomiteinterno());
    }
    
    public void limpiar() {
        this.comiteInterno.setIdcomiteinterno(null);
        this.comiteInterno.setNombre("");
        this.comiteInterno.setFechaCreacion(null);
        this.comiteInterno.setDocRef("");
        this.comiteInterno.setUnidadAcademica(new UnidadAcademica());
    }

    public ComiteInternoBL getComiteInternoBL() {
        return comiteInternoBL;
    }

    public void setComiteInternoBL(ComiteInternoBL comiteInternoBL) {
        this.comiteInternoBL = comiteInternoBL;
    }

    public ComiteInterno getComiteInterno() {
        return comiteInterno;
    }

    public void setComiteInterno(ComiteInterno comiteInterno) {
        this.comiteInterno = comiteInterno;
    }

    public List<ComiteInterno> getListaComites() {
        return listaComites;
    }

    public void setListaComites(List<ComiteInterno> listaComites) {
        this.listaComites = listaComites;
    }

    public List<SelectItem> getSelectOneItemsComites() {
        return selectOneItemsComites;
    }

    public void setSelectOneItemsComites(List<SelectItem> selectOneItemsComites) {
        this.selectOneItemsComites = selectOneItemsComites;
    }
    
}
