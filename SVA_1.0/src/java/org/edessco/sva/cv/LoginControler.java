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
import org.edessco.sva.be.Administrativo;
import org.edessco.sva.be.Alumno;
import org.edessco.sva.be.Docente;
import org.edessco.sva.be.Egresado;
import org.edessco.sva.be.GrupoInteres;
import org.edessco.sva.be.Rol;
import org.edessco.sva.be.Usuario;
import org.edessco.sva.be.UsuarioRol;
import org.edessco.sva.bl.AdministrativoBL;
import org.edessco.sva.bl.AlumnoBL;
import org.edessco.sva.bl.DocenteBL;
import org.edessco.sva.bl.EgresadoBL;
import org.edessco.sva.bl.GrupoInteresBL;
import org.edessco.sva.bl.RolBL;
import org.edessco.sva.bl.UsuarioBL;
import org.edessco.sva.bl.UsuarioRolBL;
import org.edessco.sva.da.UsuarioDA;
import org.edessco.sva.util.Encrypt;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@SessionScoped
public class LoginControler implements Serializable {

    @ManagedProperty(value = "#{usuarioBL}")
    private UsuarioBL usuarioBL;
    @ManagedProperty(value = "#{usuario}")
    private Usuario usuario;

    @ManagedProperty(value = "#{usuarioRolBL}")
    private UsuarioRolBL usuarioRolBL;
    @ManagedProperty(value = "#{usuarioRol}")
    private UsuarioRol usuarioRol;

    @ManagedProperty(value = "#{rolBL}")
    private RolBL rolBL;
    @ManagedProperty(value = "#{rol}")
    private Rol rol;

    @ManagedProperty(value = "#{docenteBL}")
    private DocenteBL docenteBL;
    @ManagedProperty(value = "#{docente}")
    private Docente docente;

    @ManagedProperty(value = "#{alumnoBL}")
    private AlumnoBL alumnoBL;
    @ManagedProperty(value = "#{alumno}")
    private Alumno alumno;

    @ManagedProperty(value = "#{egresadoBL}")
    private EgresadoBL egresadoBL;
    @ManagedProperty(value = "#{egresado}")
    private Egresado egresado;

    @ManagedProperty(value = "#{administrativoBL}")
    private AdministrativoBL administrativoBL;
    @ManagedProperty(value = "#{administrativo}")
    private Administrativo administrativo;

    @ManagedProperty(value = "#{grupoInteresBL}")
    private GrupoInteresBL grupoInteresBL;
    @ManagedProperty(value = "#{grupoInteres}")
    private GrupoInteres grupoInteres;

    private String nombreUsuario;
    private String contrasenia;

    public LoginControler() {
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sesion.setMaxInactiveInterval(5000);
    }

    public String login() {
        String url = "";
        //Obtenemos los datos del usuario
        Usuario temp = getUsuarioBL().buscar(this.getNombreUsuario());

        if (temp != null) {
            //guardamos en sesion usuario para las respuetsas de las encuestas
            HttpSession sesionUser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            sesionUser.setAttribute("usuario", temp);
            //Obtenemos los datos del usuario vinculado al rol
            usuarioRol = getUsuarioRolBL().buscar("" + temp.getIdusuario());
            //Obtenemos el rol del usuario que ingresa, para establecer las paginas de acceso
            rol = getRolBL().buscar("" + getUsuarioRol().getRol().getIdrol());
            if (temp.getEstado() == true) {
                if (temp.getContrasenia().equals(Encrypt.sha512(this.getContrasenia()))) {
                    HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    httpSession.setAttribute("nombreUsuario", this.nombreUsuario);
                    //FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Bienvenido " + temp.getNombreUsuario());
                    //FacesContext.getCurrentInstance().addMessage(null, message);
                    switch (rol.getNombreRol()) {
                        case "Administrador":
                            url = "/page/inicioAdmin";
                            break;
                        case "Administrativo":
                            url = "/page/inicioUsuario";
                            break;
                        case "Alumno":
                            url = "/page/inicioUsuario";
                            break;
                        case "Comisión interna":
                            url = "/page/inicioComision";
                            break;
                        case "Docente":
                            url = "/page/inicioDocente";
                            docente = getDocenteBL().buscarXidPersona(temp.getPersona().getIdpersona());
                            HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                            sesion.setAttribute("docente", docente);
                            break;
                        case "Egresado":
                            url = "/page/inicioUsuario";
                            break;
                        case "Grupo de interés":
                            url = "/page/inicioUsuario";
                            break;
                    }
                } else {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso", "Usuario y/o contraseña incorrectos");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    url = "/page/login";
                }
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso", "Su cuenta aún no esta activada, pongase en contacto con el administrador");
                FacesContext.getCurrentInstance().addMessage(null, message);
                url = "/page/login";
            }

        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso", "Usuario y/o contraseña incorrectos");
            FacesContext.getCurrentInstance().addMessage(null, message);
            url = "/page/login";
        }
        return url + "?faces-redirect=true";
    }

    public String cerrarSesion() {
        this.nombreUsuario = null;
        this.contrasenia = null;
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();
        return "/page/login?faces-redirect=true";
    }

    public String irRegistrarse() {
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

    public UsuarioRolBL getUsuarioRolBL() {
        return usuarioRolBL;
    }

    public void setUsuarioRolBL(UsuarioRolBL usuarioRolBL) {
        this.usuarioRolBL = usuarioRolBL;
    }

    public UsuarioRol getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(UsuarioRol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    public RolBL getRolBL() {
        return rolBL;
    }

    public void setRolBL(RolBL rolBL) {
        this.rolBL = rolBL;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public DocenteBL getDocenteBL() {
        return docenteBL;
    }

    public void setDocenteBL(DocenteBL docenteBL) {
        this.docenteBL = docenteBL;
    }

    public AlumnoBL getAlumnoBL() {
        return alumnoBL;
    }

    public void setAlumnoBL(AlumnoBL alumnoBL) {
        this.alumnoBL = alumnoBL;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public EgresadoBL getEgresadoBL() {
        return egresadoBL;
    }

    public void setEgresadoBL(EgresadoBL egresadoBL) {
        this.egresadoBL = egresadoBL;
    }

    public Egresado getEgresado() {
        return egresado;
    }

    public void setEgresado(Egresado egresado) {
        this.egresado = egresado;
    }

    public AdministrativoBL getAdministrativoBL() {
        return administrativoBL;
    }

    public void setAdministrativoBL(AdministrativoBL administrativoBL) {
        this.administrativoBL = administrativoBL;
    }

    public Administrativo getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(Administrativo administrativo) {
        this.administrativo = administrativo;
    }

    public GrupoInteresBL getGrupoInteresBL() {
        return grupoInteresBL;
    }

    public void setGrupoInteresBL(GrupoInteresBL grupoInteresBL) {
        this.grupoInteresBL = grupoInteresBL;
    }

    public GrupoInteres getGrupoInteres() {
        return grupoInteres;
    }

    public void setGrupoInteres(GrupoInteres grupoInteres) {
        this.grupoInteres = grupoInteres;
    }
}
