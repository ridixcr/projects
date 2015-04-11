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
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import org.edessco.sva.be.Facultad;
import org.edessco.sva.be.UnidadAcademica;
import org.edessco.sva.bl.UnidadAcademicaBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class UnidadAcademicaBean {
    
    @ManagedProperty(value = "#{unidadAcademicaBL}")
    private UnidadAcademicaBL unidadAcademicaBL;
    @ManagedProperty(value = "#{unidadAcademica}")
    private UnidadAcademica unidadAcademica;
    private List<UnidadAcademica> listaUnidAcademicas = new LinkedList<>();
    private List<SelectItem> selectOneItemsUnidAcademica;

    public UnidadAcademicaBean() {
    }   

    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getUnidadAcademicaBL().registrar(getUnidadAcademica())) {
            @Override
            public void proceso() {
                unidadAcademica = new UnidadAcademica();
                listarUnidAcademicas();
            }
        });
    }

    @PostConstruct
    public void listarUnidAcademicas() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if(httpSession.getAttribute("idFacultad") != null){
            setListaUnidAcademicas(getUnidadAcademicaBL().listarFacultad(Long.parseLong(httpSession.getAttribute("idFacultad").toString())));
            //httpSession.invalidate();
        }else{
            setListaUnidAcademicas(getUnidadAcademicaBL().listar(""));
        }
        
    } 
    
    public String listarEscuelas(){
      setListaUnidAcademicas(getUnidadAcademicaBL().listarFacultad(getUnidadAcademica().getFacultad().getIdfacultad()));
      return "administrarUnidadAcademica";
    }

    public void actualizar() {
        UnidadAcademica temp = new UnidadAcademica();
        String msg;
        temp = buscarId();
        temp.setFacultad(this.getUnidadAcademica().getFacultad());
        temp.setNombre(this.getUnidadAcademica().getNombre());
        
        long res = getUnidadAcademicaBL().actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarUnidAcademicas();
    }
    
    public void eliminar() {
        UnidadAcademica temp = new UnidadAcademica();
        String msg;
        temp = buscarId();
        long res = getUnidadAcademicaBL().eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
              
        listarUnidAcademicas();
    }
    
    public UnidadAcademica buscarId(){
        return unidadAcademicaBL.buscar(getUnidadAcademica().getIdunidadacademica());
    }
    
    public void limpiar(){
        this.unidadAcademica.setIdunidadacademica(null);
        this.unidadAcademica.setNombre("");
        unidadAcademica.setFacultad(new Facultad());
    }
    
    public UnidadAcademicaBL getUnidadAcademicaBL() {
        return unidadAcademicaBL;
    }

    public void setUnidadAcademicaBL(UnidadAcademicaBL unidadAcademicaBL) {
        this.unidadAcademicaBL = unidadAcademicaBL;
    }

    public UnidadAcademica getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    public List<UnidadAcademica> getListaUnidAcademicas() {
        return listaUnidAcademicas;
    }

    public void setListaUnidAcademicas(List<UnidadAcademica> listaUnidAcademicas) {
        this.listaUnidAcademicas = listaUnidAcademicas;
    }

    public List<SelectItem> getSelectOneItemsUnidAcademica() {
        this.selectOneItemsUnidAcademica = new LinkedList<SelectItem>();
        for (UnidadAcademica unidadAcademica1 : listaUnidAcademicas) {
            this.setUnidadAcademica(unidadAcademica1);
            SelectItem selectItem = new SelectItem(unidadAcademica.getIdunidadacademica(), unidadAcademica.getNombre());
            this.selectOneItemsUnidAcademica.add(selectItem);
        }
        return selectOneItemsUnidAcademica;
    }

    public void setSelectOneItemsUnidAcademica(List<SelectItem> selectOneItemsUnidAcademica) {
        this.selectOneItemsUnidAcademica = selectOneItemsUnidAcademica;
    }
}
