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
import org.edessco.sva.be.ModeloCalidad;
import org.edessco.sva.bl.DimensionBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class DimensionBean {

    @ManagedProperty(value = "#{dimensionBL}")
    private DimensionBL dimensionBL;
    @ManagedProperty(value = "#{dimension}")
    private Dimension dimension;
    private List<Dimension> listaDimensiones = new LinkedList<>();

    private List<SelectItem> selectOneItemsDimension;
    
    public DimensionBean() {
    }

    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getDimensionBL().registrar(getDimension())) {
            @Override
            public void proceso() {
                dimension = new Dimension();
                listar();
            }
        });
    }

    @PostConstruct
    public void listar() {
        setListaDimensiones(getDimensionBL().listar(""));
    }

    public void actualizar() {
        Dimension temp = new Dimension();
        String msg;
        temp = buscarId();
        temp.setNumero(getDimension().getNumero());
        temp.setTitulo(getDimension().getTitulo());
        temp.setDescripcion(getDimension().getDescripcion());
        temp.setEstado(getDimension().getEstado());

        long res = getDimensionBL().actualizar(temp);
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
        Dimension temp = new Dimension();
        String msg;
        temp = buscarId();
        long res = getDimensionBL().eliminar(temp);
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

    public Dimension buscarId() {
        return dimensionBL.buscar(getDimension().getIddimension());
    }

    public void limpiar() {
        this.dimension.setIddimension(null);
        this.dimension.setNumero(null);
        this.dimension.setTitulo("");
        this.dimension.setDescripcion("");
        this.dimension.setEstado(false);
        dimension.setModeloCalidad(new ModeloCalidad());
    }

    public DimensionBL getDimensionBL() {
        return dimensionBL;
    }

    public void setDimensionBL(DimensionBL dimensionBL) {
        this.dimensionBL = dimensionBL;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public List<Dimension> getListaDimensiones() {
        return listaDimensiones;
    }

    public void setListaDimensiones(List<Dimension> listaDimensiones) {
        this.listaDimensiones = listaDimensiones;
    }

    public List<SelectItem> getSelectOneItemsDimension() {
        this.selectOneItemsDimension = new LinkedList<SelectItem>();
        for (Dimension dimension1 : listaDimensiones) {
            this.setDimension(dimension1);
            SelectItem selectItem = new SelectItem(dimension.getIddimension(), dimension.getTitulo());
            this.selectOneItemsDimension.add(selectItem);
        }
        return selectOneItemsDimension;
    }

    public void setSelectOneItemsDimension(List<SelectItem> selectOneItemsDimension) {
        this.selectOneItemsDimension = selectOneItemsDimension;
    }
}
