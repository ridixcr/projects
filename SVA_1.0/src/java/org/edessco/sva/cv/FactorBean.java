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
import org.edessco.sva.be.Dimension;
import org.edessco.sva.be.Factor;
import org.edessco.sva.bl.FactorBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class FactorBean {
@ManagedProperty(value = "#{factorBL}")
    private FactorBL factorBL;
    @ManagedProperty(value = "#{factor}")
    private Factor factor;
    private List<Factor> listaFactores = new LinkedList<>();

    private List<SelectItem> selectOneItemsFactor;
    
    public FactorBean() {
    }

    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getFactorBL().registrar(getFactor())) {
            @Override
            public void proceso() {
                factor = new Factor();
                listar();
            }
        });
    }

    @PostConstruct
    public void listar() {
        setListaFactores(getFactorBL().listar(""));
    }

    public void actualizar() {
        Factor temp = new Factor();
        String msg;
        temp = buscarId();
        temp.setNumero(getFactor().getNumero());
        temp.setTitulo(getFactor().getTitulo());
        temp.setDescripcion(getFactor().getDescripcion());
        temp.setEstado(getFactor().getEstado());
        temp.setDimension(getFactor().getDimension());

        long res = getFactorBL().actualizar(temp);
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
        Factor temp = new Factor();
        String msg;
        temp = buscarId();
        long res = getFactorBL().eliminar(temp);
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

    public Factor buscarId() {
        return factorBL.buscar(getFactor().getIdfactor());
    }

    public void limpiar() {
        this.factor.setIdfactor(null);
        this.factor.setNumero(null);
        this.factor.setTitulo("");
        this.factor.setDescripcion("");
        this.factor.setEstado(false);
        factor.setDimension(new Dimension());
    }

    public FactorBL getFactorBL() {
        return factorBL;
    }

    public void setFactorBL(FactorBL factorBL) {
        this.factorBL = factorBL;
    }

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    public List<Factor> getListaFactores() {
        return listaFactores;
    }

    public void setListaFactores(List<Factor> listaFactores) {
        this.listaFactores = listaFactores;
    }

    public List<SelectItem> getSelectOneItemsFactor() {
        this.selectOneItemsFactor = new LinkedList<SelectItem>();
        for (Factor factor1 : listaFactores) {
            this.setFactor(factor1);
            SelectItem selectItem = new SelectItem(factor.getIdfactor(), factor.getTitulo());
            this.selectOneItemsFactor.add(selectItem);
        }
        return selectOneItemsFactor;
    }

    public void setSelectOneItemsFactor(List<SelectItem> selectOneItemsFactor) {
        this.selectOneItemsFactor = selectOneItemsFactor;
    }
}
