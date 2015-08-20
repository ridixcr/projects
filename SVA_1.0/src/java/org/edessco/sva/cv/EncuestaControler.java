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
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import org.edessco.sva.be.Autoevaluacion;
import org.edessco.sva.be.Encuesta;
import org.edessco.sva.be.Usuario;
import org.edessco.sva.bl.EncuestaBL;
import org.edessco.sva.bl.UsuarioBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class EncuestaControler {
    
    @ManagedProperty(value = "#{usuarioBL}")
    private UsuarioBL usuarioBL;
    @ManagedProperty(value = "#{usuario}")
    private Usuario usuario;

    @ManagedProperty(value = "#{encuestaBL}")
    private EncuestaBL encuestaBL;
    @ManagedProperty(value = "#{encuesta}")
    private Encuesta encuesta;
    private List<Encuesta> listaEncuestas = new LinkedList<>();

    private List<SelectItem> selectOneItemsEncuesta;

    public EncuestaControler() {
    }    
    
    public void registrar() {
        HttpSession sesionUser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);        
        Usuario userTemp = usuarioBL.buscar(Long.parseLong(sesionUser.getAttribute("idUsuario").toString()));
        getEncuesta().setIdUsuario(userTemp.getIdusuario());
        getEncuesta().setFechaCreacion(new Date());
        setTareaEvento(new Tarea(Tarea.REGISTRO, getEncuestaBL().registrar(getEncuesta())) {
            @Override
            public void proceso() {
                encuesta = new Encuesta();
                listar();
            }
        });
    }

    @PostConstruct
    public void listar() {
        setListaEncuestas(getEncuestaBL().listar());
    }
    
    public void actualizar() {
        Encuesta temp = new Encuesta();
        String msg;
        temp = buscarId();
        
        temp.setAutoevaluacion(this.getEncuesta().getAutoevaluacion());
        temp.setTituloEncuesta(this.getEncuesta().getTituloEncuesta());
        temp.setFechaHoraInicio(this.getEncuesta().getFechaHoraInicio());
        temp.setFechaHoraFin(this.getEncuesta().getFechaHoraFin());
        temp.setEstado(this.getEncuesta().getEstado());
        
        long res = getEncuestaBL().actualizar(temp);
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
        Encuesta temp = new Encuesta();
        String msg;
        temp = buscarId();
        long res = getEncuestaBL().eliminar(temp);
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
    
    public Encuesta buscarId() {
        return encuestaBL.buscar(getEncuesta().getIdencuesta());
    }
    
    public void limpiar() {
        this.encuesta.setIdencuesta(null);
        this.encuesta.setTituloEncuesta("");
        this.encuesta.setFechaHoraInicio(null);
        this.encuesta.setFechaHoraFin(null);
        this.encuesta.setEstado(false);
        this.encuesta.setAutoevaluacion(new Autoevaluacion());
    }

    public EncuestaBL getEncuestaBL() {
        return encuestaBL;
    }

    public void setEncuestaBL(EncuestaBL encuestaBL) {
        this.encuestaBL = encuestaBL;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public List<Encuesta> getListaEncuestas() {
        return listaEncuestas;
    }

    public void setListaEncuestas(List<Encuesta> listaEncuestas) {
        this.listaEncuestas = listaEncuestas;
    }

    public List<SelectItem> getSelectOneItemsEncuesta() {
        this.selectOneItemsEncuesta = new LinkedList<SelectItem>();
        for (Encuesta encuesta1 : listaEncuestas) {
            this.setEncuesta(encuesta1);
            SelectItem selectItem = new SelectItem(encuesta.getIdencuesta(), encuesta.getTituloEncuesta());
            this.selectOneItemsEncuesta.add(selectItem);
        }
        return selectOneItemsEncuesta;
    }

    public void setSelectOneItemsEncuesta(List<SelectItem> selectOneItemsEncuesta) {
        this.selectOneItemsEncuesta = selectOneItemsEncuesta;
    }
    
    public String redirigir(int nro) {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.setAttribute("idEncuesta", getEncuesta().getIdencuesta());
        httpSession.setAttribute("nro_encuesta", nro);
        return "administrarPreguntasEncuestas?faces-redirect=true";
    }

    public UsuarioBL getUsuarioBL() {
        return usuarioBL;
    }

    public void setUsuarioBL(UsuarioBL usuarioBL) {
        this.usuarioBL = usuarioBL;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
