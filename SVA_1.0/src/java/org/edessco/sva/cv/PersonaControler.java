/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.cv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.edessco.sva.be.Administrativo;
import org.edessco.sva.be.Alumno;
import org.edessco.sva.be.Docente;
import org.edessco.sva.be.Egresado;
import org.edessco.sva.be.GrupoInteres;
import org.edessco.sva.be.Persona;
import org.edessco.sva.be.Rol;
import org.edessco.sva.be.UnidadAcademica;
import org.edessco.sva.be.Usuario;
import org.edessco.sva.be.UsuarioRol;
import org.edessco.sva.bl.AdministrativoBL;
import org.edessco.sva.bl.AlumnoBL;
import org.edessco.sva.bl.DocenteBL;
import org.edessco.sva.bl.EgresadoBL;
import org.edessco.sva.bl.GrupoInteresBL;
import org.edessco.sva.bl.PersonaBL;
import org.edessco.sva.bl.RolBL;
import org.edessco.sva.bl.UnidadAcademicaBL;
import org.edessco.sva.bl.UsuarioBL;
import org.edessco.sva.bl.UsuarioRolBL;
import org.edessco.sva.util.Encrypt;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean(name = "personaControler", eager = true)
@ViewScoped
public class PersonaControler {

    @ManagedProperty(value = "#{personaBL}")
    private PersonaBL personaBL;
    @ManagedProperty(value = "#{persona}")
    private Persona persona;
    private List<Persona> listaPersonas = new LinkedList<>();
    private List<Persona> filteredPerson;
    private Persona selectedPersona;

    @ManagedProperty(value = "#{alumnoBL}")
    private AlumnoBL alumnoBL;
    @ManagedProperty(value = "#{alumno}")
    private Alumno alumno;

    @ManagedProperty(value = "#{docenteBL}")
    private DocenteBL docenteBL;
    @ManagedProperty(value = "#{docente}")
    private Docente docente;

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

    @ManagedProperty(value = "#{unidadAcademicaBL}")
    private UnidadAcademicaBL unidadAcademicaBL;
    @ManagedProperty(value = "#{unidadAcademica}")
    private UnidadAcademica unidadAcademica;

    private String confContrasenia;
    private String tipoUsuario;

    private HttpServletRequest httpServletRequest;
    private FacesContext facesContext;
    private FacesMessage facesMessage;

    private AlumnoControler alumnoControler = null;

    private List<Rol> listaRoles = new LinkedList<>();

    private long idUnidadAcademica;

    @PostConstruct
    public void init() {
        setListaPersonas(getPersonaBL().listar());
        setListaRoles(getRolBL().listar());
    }

    public void actualizaRol() {

    }

    public PersonaControler() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    }

    public void registrar() {
        setUnidadAcademica(getUnidadAcademicaBL().buscar(getIdUnidadAcademica()));
        getPersona().setUnidadAcademica(getUnidadAcademica());
        setTareaEvento(new Tarea(Tarea.REGISTRO, getPersonaBL().registrar(getPersona())) {
            @Override
            public void proceso() {
                if (getRepuesta() >= 0) {
                    getUsuario().setPersona(getPersona());
                    getUsuario().setFechaRegistro(new Date());
                    getUsuario().setFechaAlta(new Date());
                    getUsuario().setEstado(true);
                    setTareaEvento(new Tarea(Tarea.REGISTRO, getUsuarioBL().registrar(getUsuario())) {
                        @Override
                        public void proceso() {
                            if (getRepuesta() >= 0) {
                                getUsuarioRol().setUsuario(getUsuario());
                                getUsuarioRol().setRol(getRolBL().buscar(getTipoUsuario()));
                                setTareaEvento(new Tarea(Tarea.REGISTRO, getUsuarioRolBL().registrar(getUsuarioRol())) {
                                    @Override
                                    public void proceso() {
                                        if (getRepuesta() >= 0) {
                                            switch (getTipoUsuario()) {
                                                case "ALUMNO":
                                                    getAlumno().setPersona(getPersona());
                                                    setTareaEvento(new Tarea(Tarea.REGISTRO, getAlumnoBL().registrar(getAlumno())) {
                                                        @Override
                                                        public void proceso() {
                                                            if (getRepuesta() >= 0) {
                                                                setPersona(new Persona());
                                                                setUsuario(new Usuario());
                                                                setUsuarioRol(new UsuarioRol());
                                                                setAlumno(new Alumno());
                                                            }
                                                        }
                                                    });
                                                    break;
                                                case "COMISION INTERNA":
                                                    
                                                    break;
                                                case "DOCENTE":
                                                    getDocente().setPersona(getPersona());
                                                    setTareaEvento(new Tarea(Tarea.REGISTRO, getDocenteBL().registrar(getDocente())) {
                                                        @Override
                                                        public void proceso() {
                                                            if (getRepuesta() >= 0) {
                                                                setPersona(new Persona());
                                                                setUsuario(new Usuario());
                                                                setUsuarioRol(new UsuarioRol());
                                                                setDocente(new Docente());
                                                            }
                                                        }
                                                    });
                                                    break;
                                                case "EGRESADO":
                                                    getEgresado().setPersona(getPersona());
                                                    setTareaEvento(new Tarea(Tarea.REGISTRO, getEgresadoBL().registrar(getEgresado())) {
                                                        @Override
                                                        public void proceso() {
                                                            if (getRepuesta() >= 0) {
                                                                setPersona(new Persona());
                                                                setUsuario(new Usuario());
                                                                setUsuarioRol(new UsuarioRol());
                                                                setEgresado(new Egresado());
                                                            }
                                                        }
                                                    });
                                                    break;
                                                case "GRUPO DE INTERES":
                                                    getGrupoInteres().setPersona(getPersona());
                                                    setTareaEvento(new Tarea(Tarea.REGISTRO, getGrupoInteresBL().registrar(getGrupoInteres())) {
                                                        @Override
                                                        public void proceso() {
                                                            if (getRepuesta() >= 0) {
                                                                setPersona(new Persona());
                                                                setUsuario(new Usuario());
                                                                setUsuarioRol(new UsuarioRol());
                                                                setGrupoInteres(new GrupoInteres());
                                                            }
                                                        }
                                                    });
                                                    break;
                                                case "ADMINISTRATIVO":
                                                    getAdministrativo().setPersona(getPersona());
                                                    setTareaEvento(new Tarea(Tarea.REGISTRO, getAdministrativoBL().registrar(getAdministrativo())) {
                                                        @Override
                                                        public void proceso() {
                                                            if (getRepuesta() >= 0) {
                                                                setPersona(new Persona());
                                                                setUsuario(new Usuario());
                                                                setUsuarioRol(new UsuarioRol());
                                                                setAdministrativo(new Administrativo());
                                                            }
                                                        }
                                                    });
                                                    break;
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });

    }

    public boolean validaContrasenia() {
        if (!this.getUsuario().getContrasenia().equals(this.confContrasenia)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las contraseñas no coinciden"));
            return false;
        } else {
            return true;
        }

    }

    public String registrarUser() {
        String url = "";
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.setAttribute("tipoUsuario", this.getTipoUsuario());
        switch (getTipoUsuario().trim()) {
            case "Alumno":
                url = "registrarAlumno";
                break;
            case "Egresado":
                url = "registrarEgresado";
                break;
            case "Administrativo":
                url = "registrarAdministrativo";
                break;
            case "Docente":
                url = "registrarDocente";
                break;
            case "Grupo de interés":
                url = "registrarGrupoInteres";
                break;
        }
        return url + "?faces-redirect=true";
    }

    public void limpiar() {
        this.getPersona().setIdpersona(null);
        this.getPersona().getUnidadAcademica().setIdunidadacademica(null);
        this.getPersona().setSexo("");
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

    public List<Persona> complete(String query) {
        listaPersonas = personaBL.list();
        filteredPerson = new ArrayList<Persona>();
        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona per = listaPersonas.get(i);
            if (per.getNombres().toLowerCase().startsWith(query)) {
                filteredPerson.add(per);
            }
        }
        return filteredPerson;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public DocenteBL getDocenteBL() {
        return docenteBL;
    }

    public void setDocenteBL(DocenteBL docenteBL) {
        this.docenteBL = docenteBL;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
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

    public Persona getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(Persona selectedPersona) {
        this.selectedPersona = selectedPersona;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Persona Seleccionada", ((Persona) event.getObject()).getIdpersona().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Persona no seleccionada", ((Persona) event.getObject()).getIdpersona().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public long getIdUnidadAcademica() {
        return idUnidadAcademica;
    }

    public void setIdUnidadAcademica(long idUnidadAcademica) {
        this.idUnidadAcademica = idUnidadAcademica;
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
}
