package org.edessco.sva.cv;
//<editor-fold defaultstate="collapsed" desc="IMPORT'S">
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.edessco.sva.be.Docente;
import org.edessco.sva.be.RespuestaCuestionario;
import org.edessco.sva.bl.DocenteBL;
import org.edessco.sva.bl.RespuestaCuestionarioBL;
import org.edessco.sva.util.ReportViewerBean;
//</editor-fold>
@ManagedBean
@ViewScoped
public class RCuestionarioDocenteVC extends ReportViewerBean implements Serializable {
    @ManagedProperty(value = "#{docente}")
    private Docente docente;
    @ManagedProperty(value = "#{docenteBL}")
    private DocenteBL docenteBL;
    private List<Docente> listaDocentes = new LinkedList<>();
    
    @ManagedProperty(value = "#{respuestaCuestionarioBL}")
    private RespuestaCuestionarioBL respuestaCuestionarioBL;
    private List<RespuestaCuestionario> 
            listaRespuestaCuestionario = new LinkedList<>();
    
    
    @PostConstruct
    public void init(){}
    
    public void initHTML() {
        getListaDocentes().addAll(getDocenteBL().listar());
    }
    
    public void initPDF() {
        file_path = "/resources/t/";
        rsc_report_path = "/org/edessco/sva/rpt/";
        generarReporte("rpt", "ReporteCuestionarioDocente");
    }
    
    public List<RespuestaCuestionario> listarResultadosDocente(long idDocente) {
        listaRespuestaCuestionario.clear();
        listaRespuestaCuestionario.addAll(getRespuestaCuestionarioBL()
                                  .reporteCuestionarioDocente(idDocente));
        return listaRespuestaCuestionario;
    }

    //<editor-fold defaultstate="collapsed" desc="GET'S & SET'S">
    public List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
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

    public RespuestaCuestionarioBL getRespuestaCuestionarioBL() {
        return respuestaCuestionarioBL;
    }

    public void setRespuestaCuestionarioBL(RespuestaCuestionarioBL respuestaCuestionarioBL) {
        this.respuestaCuestionarioBL = respuestaCuestionarioBL;
    }
    //</editor-fold>
}
