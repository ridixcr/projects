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
import javax.faces.view.ViewScoped;
import org.edessco.sva.be.Usuario;
import org.edessco.sva.bl.UsuarioBL;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class UsuarioControler {

    @ManagedProperty(value = "#{usuarioBL}")
    private UsuarioBL usuarioBL;
    @ManagedProperty(value = "#{usuario}")
    private Usuario usuario;
    private List<Usuario> listUsuarioPersona = new LinkedList<>();
    
    Usuario temp;
    
    public UsuarioControler() {
    }
    
    @PostConstruct
    public void listar() {
        setListUsuarioPersona(getUsuarioBL().listar(""));
    }
    
    public void actualizar() {
        Usuario temp2 = new Usuario();
        String msg;
        temp2 = buscarId();
        
        temp2.setEstado(this.getUsuario().getEstado());
        System.out.println("estado..."+temp2.getEstado());
        
        long res = getUsuarioBL().actualizar(temp2);
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
    
    public Usuario buscarId() {
        return getUsuarioBL().buscar(getUsuario().getIdusuario());
    }
    
    public void onRowEdit(RowEditEvent event) {
        temp = new Usuario();
        String msg = "";
        temp.setIdusuario(((Usuario)event.getObject()).getIdusuario());
        Usuario temp2 = new Usuario();
        temp2 = getUsuarioBL().buscar(temp.getIdusuario());
        System.out.println("Estado modificado..."+getUsuario().getEstado());
        temp2.setEstado(getUsuario().getEstado());
        
        long res = getUsuarioBL().actualizar(temp2);
        if (res == 0) {
            msg = "Se habilitó la cuenta para "+temp2.getNombreUsuario();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al actualizar el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listar();
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion cancelada", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public List<Usuario> getListUsuarioPersona() {
        return listUsuarioPersona;
    }

    public void setListUsuarioPersona(List<Usuario> listUsuarioPersona) {
        this.listUsuarioPersona = listUsuarioPersona;
    }
    
}
