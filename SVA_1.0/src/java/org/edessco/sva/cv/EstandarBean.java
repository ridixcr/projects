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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.edessco.sva.be.Criterio;
import org.edessco.sva.be.Estandar;
import org.edessco.sva.bl.EstandarBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class EstandarBean {

    @ManagedProperty(value = "#{estandarBL}")
    private EstandarBL estandarBL;
    @ManagedProperty(value = "#{estandar}")
    private Estandar estandar;
    private List<Estandar> listaEstandares = new LinkedList<>();
    private List<SelectItem> selectOneItemsEstandar;

    public EstandarBean() {
    }



    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getEstandarBL().registrar(getEstandar())) {
            @Override
            public void proceso() {
                estandar = new Estandar();
                listar();
            }
        });
    }

    @PostConstruct
    public void listar() {
        setListaEstandares(getEstandarBL().listar(""));
    }

    public void actualizar() {
        Estandar temp = new Estandar();
        String msg;
        temp = buscarId();
        
        temp.setNumeroEstandar(getEstandar().getNumeroEstandar());
        temp.setTitulo(getEstandar().getTitulo());
        temp.setDescripcion(getEstandar().getDescripcion());
        temp.setTipoEstandar(getEstandar().getTipoEstandar());
        temp.setEstado(getEstandar().getEstado());
        temp.setCriterio(getEstandar().getCriterio());

        long res = getEstandarBL().actualizar(temp);
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
        Estandar temp = new Estandar();
        String msg;
        temp = buscarId();
        long res = getEstandarBL().eliminar(temp);
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

    public Estandar buscarId() {
        return estandarBL.buscar(getEstandar().getIdestandar());
    }

    public void limpiar() {
        this.estandar.setIdestandar(null);
        this.estandar.setNumeroEstandar(null);
        this.estandar.setTitulo("");
        this.estandar.setDescripcion("");
        this.estandar.setEstado(false);
        estandar.setCriterio(new Criterio());
    }

    public EstandarBL getEstandarBL() {
        return estandarBL;
    }

    public void setEstandarBL(EstandarBL estandarBL) {
        this.estandarBL = estandarBL;
    }

    public Estandar getEstandar() {
        return estandar;
    }

    public void setEstandar(Estandar estandar) {
        this.estandar = estandar;
    }

    public List<Estandar> getListaEstandares() {
        return listaEstandares;
    }

    public void setListaEstandares(List<Estandar> listaEstandares) {
        this.listaEstandares = listaEstandares;
    }

    public List<SelectItem> getSelectOneItemsEstandar() {
        this.selectOneItemsEstandar = new LinkedList<SelectItem>();
        for (Estandar estandar1 : listaEstandares) {
            this.setEstandar(estandar1);
            SelectItem selectItem = new SelectItem(estandar.getIdestandar(), estandar.getTitulo());
            this.selectOneItemsEstandar.add(selectItem);
        }
        return selectOneItemsEstandar;
    }

    public void setSelectOneItemsEstandar(List<SelectItem> selectOneItemsEstandar) {
        this.selectOneItemsEstandar = selectOneItemsEstandar;
    }
    
}
