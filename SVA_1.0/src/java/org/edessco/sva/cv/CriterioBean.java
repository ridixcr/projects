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
import javax.servlet.http.HttpSession;
import org.edessco.sva.be.Criterio;
import org.edessco.sva.be.Factor;
import org.edessco.sva.bl.CriterioBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class CriterioBean {

    @ManagedProperty(value = "#{criterioBL}")
    private CriterioBL criterioBL;
    @ManagedProperty(value = "#{criterio}")
    private Criterio criterio;
    private List<Criterio> listaCriterios = new LinkedList<>();

    private List<SelectItem> selectOneItemsCriterio;

    public CriterioBean() {
    }


    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getCriterioBL().registrar(getCriterio())) {
            @Override
            public void proceso() {
                criterio = new Criterio();
                listar();
            }
        });
    }
    
    public String redirigir() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.setAttribute("idCriterio", getCriterio().getIdcriterio());
        return "administrarEstandar";
    }

    @PostConstruct
    public void listar() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if(httpSession.getAttribute("idFactor") != null){
            setListaCriterios(getCriterioBL().listarCriterio(Long.parseLong(httpSession.getAttribute("idFactor").toString())));
        }else{
            setListaCriterios(getCriterioBL().listar(""));
        }        
    }

    public void actualizar() {
        Criterio temp = new Criterio();
        String msg;
        temp = buscarId();
        
        temp.setNumero(getCriterio().getNumero());
        temp.setTitulo(getCriterio().getTitulo());
        temp.setDescripcion(getCriterio().getDescripcion());
        temp.setEstado(getCriterio().getEstado());
        temp.setFactor(getCriterio().getFactor());

        long res = getCriterioBL().actualizar(temp);
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
        Criterio temp = new Criterio();
        String msg;
        temp = buscarId();
        long res = getCriterioBL().eliminar(temp);
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

    public Criterio buscarId() {
        return criterioBL.buscar(getCriterio().getIdcriterio());
    }

    public void limpiar() {
        this.criterio.setIdcriterio(null);
        this.criterio.setNumero(null);
        this.criterio.setTitulo("");
        this.criterio.setDescripcion("");
        this.criterio.setEstado(false);
        criterio.setFactor(new Factor());
    }

    public CriterioBL getCriterioBL() {
        return criterioBL;
    }

    public void setCriterioBL(CriterioBL criterioBL) {
        this.criterioBL = criterioBL;
    }

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }

    public List<Criterio> getListaCriterios() {
        return listaCriterios;
    }

    public void setListaCriterios(List<Criterio> listaCriterios) {
        this.listaCriterios = listaCriterios;
    }

    public List<SelectItem> getSelectOneItemsCriterio() {
        this.selectOneItemsCriterio = new LinkedList<SelectItem>();
        for (Criterio criterio1 : listaCriterios) {
            this.setCriterio(criterio1);
            SelectItem selectItem = new SelectItem(criterio.getIdcriterio(), criterio.getTitulo());
            this.selectOneItemsCriterio.add(selectItem);
        }
        return selectOneItemsCriterio;
    }

    public void setSelectOneItemsCriterio(List<SelectItem> selectOneItemsCriterio) {
        this.selectOneItemsCriterio = selectOneItemsCriterio;
    }

}
