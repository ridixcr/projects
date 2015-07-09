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
import org.edessco.sva.be.ComiteInterno;
import org.edessco.sva.be.MiembroComiteInterno;
import org.edessco.sva.be.Persona;
import org.edessco.sva.be.UnidadAcademica;
import org.edessco.sva.bl.MiembroComiteInternoBL;
import org.edessco.sva.bl.PersonaBL;
import org.edessco.sva.bl.UnidadAcademicaBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class MiembroComiteInternoControler {

    @ManagedProperty(value = "#{unidadAcademica}")
    private UnidadAcademica unidadAcademica;
    @ManagedProperty(value = "#{personaBL}")
    private PersonaBL personaBL;
    @ManagedProperty(value = "#{persona}")
    private Persona persona;
    @ManagedProperty(value = "#{miembroComiteInternoBL}")
    private MiembroComiteInternoBL miembroComiteInternoBL;
    @ManagedProperty(value = "#{miembroComiteInterno}")
    private MiembroComiteInterno miembroComiteInterno;
    private List<MiembroComiteInterno> listaMiembros = new LinkedList<>();

    private HttpServletRequest httpServletRequest;
    private FacesContext facesContext;
    private FacesMessage facesMessage;

    public MiembroComiteInternoControler() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    }

    public void registrar() {
        long res = getPersonaBL().registrar(getPersona());
        httpServletRequest.setAttribute("sessionIdPersona", getPersona().getIdpersona());
        if(res == 0){
            getMiembroComiteInterno().setPersona(getPersona());
            long res2 = getMiembroComiteInternoBL().registrar(getMiembroComiteInterno());
            if(res2 == 0){
                String msg = "Registro exitoso.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }else{
                String msg = "Error al intentar registrar.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            listar();
        }
        
//        setTareaEvento(new Tarea(Tarea.REGISTRO, getMiembroComiteInternoBL().registrar(getMiembroComiteInterno())) {
//            @Override
//            public void proceso() {
//                miembroComiteInterno = new MiembroComiteInterno();
//                listar();
//            }
//        });
    }

    @PostConstruct
    public void listar() {
        setListaMiembros(getMiembroComiteInternoBL().listar(""));
    }

    public void actualizar() {
        MiembroComiteInterno temp = new MiembroComiteInterno();
        String msg;
        temp = buscarId();
        //Actualizar los datos de la persona
        System.out.println("persona ... "+getMiembroComiteInterno().getPersona());
        System.out.println("getdoc comite ... "+getMiembroComiteInterno().getComiteInterno());
        
        System.out.println("get  miembro recuperado .. "+getMiembroComiteInterno().getCargo());
        temp.setIdmiembrocomiteinterno(getMiembroComiteInterno().getIdmiembrocomiteinterno());
        temp.setComiteInterno(getMiembroComiteInterno().getComiteInterno());
        temp.setPersona(getMiembroComiteInterno().getPersona());
        temp.setCargo(getMiembroComiteInterno().getCargo());
        temp.setFechaDesde(getMiembroComiteInterno().getFechaDesde());
        temp.setFechaHasta(getMiembroComiteInterno().getFechaHasta());
        

        long res = getMiembroComiteInternoBL().actualizar(temp);
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
        MiembroComiteInterno temp = new MiembroComiteInterno();
        String msg;
        temp = buscarId();
        long res = getMiembroComiteInternoBL().eliminar(temp);
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

    public MiembroComiteInterno buscarId() {
        return miembroComiteInternoBL.buscar(getMiembroComiteInterno().getIdmiembrocomiteinterno());
    }

    public void limpiar() {
        this.miembroComiteInterno.setIdmiembrocomiteinterno(null);
        this.miembroComiteInterno.setCargo("");
        this.miembroComiteInterno.setFechaDesde(null);
        this.miembroComiteInterno.setFechaHasta(null);        
        //this.miembroComiteInterno.setPersona(null);
        //this.miembroComiteInterno.setComiteInterno(new ComiteInterno());
        persona.setIdpersona(null);
        persona.setNombres("");
        persona.setApellidoPaterno("");
        persona.setApellidoMaterno("");
        persona.setDni("");
        persona.setDni("");
        persona.setSexo("");
        persona.setTelefono("");
        persona.setCorreo("");
        persona.setUnidadAcademica(new UnidadAcademica());
        
    }

    public MiembroComiteInternoBL getMiembroComiteInternoBL() {
        return miembroComiteInternoBL;
    }

    public void setMiembroComiteInternoBL(MiembroComiteInternoBL miembroComiteInternoBL) {
        this.miembroComiteInternoBL = miembroComiteInternoBL;
    }

    public MiembroComiteInterno getMiembroComiteInterno() {
        return miembroComiteInterno;
    }

    public void setMiembroComiteInterno(MiembroComiteInterno miembroComiteInterno) {
        this.miembroComiteInterno = miembroComiteInterno;
    }

    public List<MiembroComiteInterno> getListaMiembros() {
        return listaMiembros;
    }

    public void setListaMiembros(List<MiembroComiteInterno> listaMiembros) {
        this.listaMiembros = listaMiembros;
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

    public UnidadAcademica getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

}
