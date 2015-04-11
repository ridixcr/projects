/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.cv;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.edessco.sva.be.Usuario;
import org.edessco.sva.bl.UsuarioBL;
import org.edessco.sva.da.UsuarioDA;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    @ManagedProperty(value = "#{usuarioBL}")
    private UsuarioBL usuarioBL;
    @ManagedProperty(value = "#{usuario}")
    private Usuario usuario;

    private String nombreUsuario;
    private String contrasenia;

    public LoginBean() {
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sesion.setMaxInactiveInterval(5000);
    }

    public String login() {
        String url = "";
        Usuario temp = getUsuarioBL().buscar(this.getNombreUsuario());
        if (temp != null) {
            if (temp.getContrasenia().equals(this.getContrasenia())) {
                HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSession.setAttribute("nombreUsuario", this.nombreUsuario);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Bienvenido " + temp.getNombreUsuario());
                FacesContext.getCurrentInstance().addMessage(null, message);
                url = "/page/inicioAdmin";
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso", "Usuario y/o contraseña incorrectos");
                FacesContext.getCurrentInstance().addMessage(null, message);
                url = "/page/login";
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso", "Usuario y/o contraseña incorrectos");
            FacesContext.getCurrentInstance().addMessage(null, message);
            url = "/page/login";
        }
        return url;
    }
    
    public String cerrarSesion(){
        this.nombreUsuario=null;
        this.contrasenia=null;
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();
        return "/page/login";
    }

    public String irRegistrarse() {
        System.out.println("Entra al metodo....");
        return "registrarUsuario";
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
