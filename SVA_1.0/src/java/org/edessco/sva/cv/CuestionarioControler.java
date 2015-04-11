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
import org.edessco.sva.be.Cuestionario;
import org.edessco.sva.bl.CuestionarioBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class CuestionarioControler {
    @ManagedProperty(value = "#{cuestionarioBL}")
    private CuestionarioBL cuestionarioBL;
    @ManagedProperty(value = "#{cuestionario}")
    private Cuestionario cuestionario;
    private List<Cuestionario> listaCuestionarios = new LinkedList<>();

    private List<SelectItem> selectOneItemsCuestionario;

    public CuestionarioControler() {
    }    
    
    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getCuestionarioBL().registrar(getCuestionario())) {
            @Override
            public void proceso() {
                cuestionario = new Cuestionario();
                listar();
            }
        });
    }

    @PostConstruct
    public void listar() {
        setListaCuestionarios(getCuestionarioBL().listar());
    }
    
    public void actualizar() {
        Cuestionario temp = new Cuestionario();
        String msg;
        temp = buscarId();
                        
        temp.setAutoevaluacion(this.getCuestionario().getAutoevaluacion());
        temp.setTituloCuestionario(this.getCuestionario().getTituloCuestionario());
        temp.setFechaHoraInicio(this.getCuestionario().getFechaHoraInicio());
        temp.setFechaHoraFin(this.getCuestionario().getFechaHoraFin());
        temp.setEstado(this.getCuestionario().getEstado());
        
        long res = getCuestionarioBL().actualizar(temp);
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
        Cuestionario temp = new Cuestionario();
        String msg;
        temp = buscarId();
        long res = getCuestionarioBL().eliminar(temp);
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
    
    public Cuestionario buscarId() {
        return getCuestionarioBL().buscar(getCuestionario().getIdcuestionario());
    }
    
    public void limpiar() {
        this.getCuestionario().setIdcuestionario(null);
        this.getCuestionario().setTituloCuestionario("");
        this.getCuestionario().setFechaHoraInicio(null);
        this.getCuestionario().setFechaHoraFin(null);
        this.getCuestionario().setEstado(false);
        this.getCuestionario().setAutoevaluacion(new Autoevaluacion());
    }

    public CuestionarioBL getCuestionarioBL() {
        return cuestionarioBL;
    }

    public void setCuestionarioBL(CuestionarioBL cuestionarioBL) {
        this.cuestionarioBL = cuestionarioBL;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    public List<Cuestionario> getListaCuestionarios() {
        return listaCuestionarios;
    }

    public void setListaCuestionarios(List<Cuestionario> listaCuestionarios) {
        this.listaCuestionarios = listaCuestionarios;
    }

    public List<SelectItem> getSelectOneItemsCuestionario() {
        this.selectOneItemsCuestionario = new LinkedList<SelectItem>();
        for (Cuestionario cuestionario1 : listaCuestionarios) {
            this.setCuestionario(cuestionario1);
            SelectItem selectItem = new SelectItem(cuestionario.getIdcuestionario(), cuestionario.getTituloCuestionario());
            this.selectOneItemsCuestionario.add(selectItem);
        }
        return selectOneItemsCuestionario;
    }

    public void setSelectOneItemsCuestionario(List<SelectItem> selectOneItemsCuestionario) {
        this.selectOneItemsCuestionario = selectOneItemsCuestionario;
    }
}
