package org.edessco.sva.cv;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.edessco.sva.be.Universidad;
import org.edessco.sva.bl.UniversidadBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class UniversidadBean {

    @ManagedProperty(value = "#{universidadBL}")
    private UniversidadBL universidadBL;
    @ManagedProperty(value = "#{universidad}")
    private Universidad universidad;

    private List<Universidad> listaUniversidades = new LinkedList<>();
    private List<SelectItem> selectOneItemsUniversidad;

    public UniversidadBean() {
    }
            
    public void registrarUniversidad() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getUniversidadBL().registrar(getUniversidad())) {
            @Override
            public void proceso() {
                universidad = new Universidad();
                listarUniversidades();
            }
        });
    }
    
    public void actualizarUniversidad(ActionEvent actionEvent) {
        Universidad temp = new Universidad();
        String msg;
        temp = buscarId();
        temp.setNombre(this.getUniversidad().getNombre());
        long res = universidadBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarUniversidades();
    }
    
    public void eliminarUniversidad() {        
        Universidad temp = new Universidad();
        String msg;
        temp = buscarId();
        long res = universidadBL.eliminar(temp);
        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
              
        listarUniversidades();
    } 
    
    public Universidad buscarId(){
        System.out.println("ID enviado: "+getUniversidad().getIduniversidad());
        return universidadBL.buscar(getUniversidad().getIduniversidad());
    }
    
    public void limpiar(){
        this.universidad.setIduniversidad(Long.MIN_VALUE);
        this.universidad.setNombre("");
    }

    @PostConstruct
    public void listarUniversidades() {
        setListaUniversidades(universidadBL.listar());
    }      
    /*
    public String irFacultades(){
        RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "";
        return ruta = NavegacionUtil.baseurlAdmin()+"administrarFacultad.xhtml";
        //context.addCallbackParam("ruta", ruta);
    }
    */
    public List<SelectItem> getSelectOneItemsUniversidad() {
        this.selectOneItemsUniversidad = new LinkedList<SelectItem>();
        for (Universidad universidad1 : listaUniversidades) {
            this.setUniversidad(universidad1);
            SelectItem selectItem = new SelectItem(universidad.getIduniversidad(), universidad.getNombre());
            this.selectOneItemsUniversidad.add(selectItem);
        }        
        return selectOneItemsUniversidad;
    }
    
        
    public UniversidadBL getUniversidadBL() {
        return universidadBL;
    }

    public void setUniversidadBL(UniversidadBL UniversidadBL) {
        this.universidadBL = UniversidadBL;
    }

    public void setListaUniversidades(List<Universidad> listaUniversidades) {
        this.listaUniversidades = listaUniversidades;
    }

    public List<Universidad> getListaUniversidades() {
        return listaUniversidades;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    
}
