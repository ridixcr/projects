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
import org.edessco.sva.be.Facultad;
import org.edessco.sva.be.UnidadAcademica;
import org.edessco.sva.be.Universidad;
import org.edessco.sva.bl.FacultadBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class FacultadBean {

    @ManagedProperty(value = "#{facultadBL}")
    private FacultadBL facultadBL;
    @ManagedProperty(value = "#{facultad}")
    private Facultad facultad;
    private List<Facultad> listaFacultades = new LinkedList<>();
    private List<UnidadAcademica> listaUnidAcademicas = new LinkedList<>();

    private List<SelectItem> selectOneItemsFacultad;

    public FacultadBean() {
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sesion.setMaxInactiveInterval(5000);
    }

    public void registrarFacultad() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getFacultadBL().registrar(getFacultad())) {
            @Override
            public void proceso() {
                facultad = new Facultad();
                listarFacultades();
            }
        });
    }

    @PostConstruct
    public void listarFacultades() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if(httpSession.getAttribute("idUniversidad") != null){
            setListaFacultades(getFacultadBL().listarFacultad(Long.parseLong(httpSession.getAttribute("idUniversidad").toString())));
            //httpSession.invalidate();
        }else{
            setListaFacultades(getFacultadBL().listar(""));
        }
    }
    
    public void actualizarFacultad() {
        Facultad temp = new Facultad();
        String msg;
        temp = buscarId();

        temp.setNombre(this.getFacultad().getNombre());
        temp.setUniversidad(this.getFacultad().getUniversidad());

        long res = getFacultadBL().actualizar(temp);
        if (res == 0) {
            msg = "Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarFacultades();
    }

    public void eliminarFacultad() {
        Facultad temp = new Facultad();
        String msg;
        temp = buscarId();
        long res = getFacultadBL().eliminar(temp);
        if (res == 0) {
            msg = "Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al eliminar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        listarFacultades();
    }

    public Facultad buscarId() {
        return facultadBL.buscar(getFacultad().getIdfacultad());
    }

    public void limpiar() {
        this.facultad.setIdfacultad(null);
        this.facultad.setUniversidad(new Universidad());
        this.facultad.setNombre("");
    }

    public String redirigir() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.setAttribute("idFacultad", getFacultad().getIdfacultad());
        return "administrarUnidadAcademica";
    }

    public FacultadBL getFacultadBL() {
        return facultadBL;
    }

    public void setFacultadBL(FacultadBL facultadBL) {
        this.facultadBL = facultadBL;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<Facultad> getListaFacultades() {
        return listaFacultades;
    }

    public void setListaFacultades(List<Facultad> listaFacultades) {
        this.listaFacultades = listaFacultades;
    }

    public List<SelectItem> getSelectOneItemsFacultad() {
        this.selectOneItemsFacultad = new LinkedList<SelectItem>();
        for (Facultad facultad1 : listaFacultades) {
            this.setFacultad(facultad1);
            SelectItem selectItem = new SelectItem(facultad.getIdfacultad(), facultad.getNombre());
            this.selectOneItemsFacultad.add(selectItem);
        }
        return selectOneItemsFacultad;
    }

    public void setSelectOneItemsFacultad(List<SelectItem> selectOneItemsFacultad) {
        this.selectOneItemsFacultad = selectOneItemsFacultad;
    }
}
