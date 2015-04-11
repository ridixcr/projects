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
import javax.servlet.http.HttpServletRequest;
import org.edessco.sva.be.Persona;
import org.edessco.sva.be.Usuario;
import org.edessco.sva.bl.PersonaBL;
import org.edessco.sva.bl.UsuarioBL;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class PersonaBean {

    @ManagedProperty(value = "#{personaBL}")
    private PersonaBL personaBL;
    @ManagedProperty(value = "#{persona}")
    private Persona persona;
    private List<Persona> listaPersonas = new LinkedList<>();

    @ManagedProperty(value = "#{usuarioBL}")
    private UsuarioBL usuarioBL;
    @ManagedProperty(value = "#{usuario}")
    private Usuario usuario;

    private String confContrasenia;

    private HttpServletRequest httpServletRequest;
    private FacesContext facesContext;
    private FacesMessage facesMessage;

    public PersonaBean() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    }

    public String registrar() {
        if (validaContrasenia()) {
            //se registra a la persona
            long res = getPersonaBL().registrar(getPersona());
            //almacenamos el idPersona en una sesion para reutilizarlo
            httpServletRequest.setAttribute("sessionIdPersona", getPersona().getIdpersona());
            //se procede a registrar el usuario
            getUsuario().setPersona(getPersona());
            long resUsuario = getUsuarioBL().registrar(getUsuario());
            if (res == 0 && resUsuario == 0) {
                String msg = "Registro exitoso.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                String msg = "Error al intentar registrar.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            limpiar();
            return "login";
        }
        return "";
    }

    public boolean validaContrasenia() {        
        if (!this.getUsuario().getContrasenia().equals(this.confContrasenia)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las contraseñas no coinciden"));
            return false;
        } else {
            return true;
        }

    }

    public void limpiar() {
        this.getPersona().setIdpersona(null);
        this.getPersona().setNombres("");
        this.getPersona().setApellidoPaterno("");
        this.getPersona().setApellidoMaterno("");
        this.getPersona().setDni("");
        this.getPersona().setTelefono("");
        this.getPersona().setCorreo("");

        this.getUsuario().setIdusuario(null);
        this.getUsuario().setPersona(new Persona());
        this.getUsuario().setNombreUsuario("");
        this.getUsuario().setContrasenia("");
        this.setConfContrasenia("");
    }

    @PostConstruct
    public void listar() {
        setListaPersonas(getPersonaBL().listar());
    }

    public PersonaBL getPersonaBL() {
        return personaBL;
    }

    public void setPersonaBL(PersonaBL personaBL) {
        this.personaBL = personaBL;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public FacesMessage getFacesMessage() {
        return facesMessage;
    }

    public void setFacesMessage(FacesMessage facesMessage) {
        this.facesMessage = facesMessage;
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

    public String getConfContrasenia() {
        return confContrasenia;
    }

    public void setConfContrasenia(String confContrasenia) {
        this.confContrasenia = confContrasenia;
    }

}
