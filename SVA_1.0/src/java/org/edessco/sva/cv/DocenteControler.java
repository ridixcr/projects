
package org.edessco.sva.cv;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import org.edessco.sva.be.Docente;
import org.edessco.sva.bl.DocenteBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class DocenteControler {

    @ManagedProperty(value = "#{docenteBL}")
    private DocenteBL docenteBL;
    @ManagedProperty(value = "#{docente}")
    private Docente docente;
    
    public DocenteControler() {
    }
    
    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getDocenteBL().registrar(getDocente())) {
            @Override
            public void proceso() {
                docente = new Docente();
                //listar();
            }
        });
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
    
}
