package org.edessco.sva.cv;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.edessco.sva.be.Estandar;
import org.edessco.sva.be.RespuestaCuestionario;
import org.edessco.sva.bl.EstandarBL;
import org.edessco.sva.bl.RespuestaCuestionarioBL;
import org.edessco.sva.util.ReportViewerBean;

@ManagedBean
@ViewScoped
public class RCuestionarioPorEstandarVC extends ReportViewerBean implements Serializable {
    @ManagedProperty(value = "#{estandarBL}")
    private EstandarBL estandarBL;
    private List<Estandar> listaEstandar = new LinkedList<>();
    
    @ManagedProperty(value = "#{respuestaCuestionarioBL}")
    private RespuestaCuestionarioBL respuestaCuestionarioBL;
    private List<RespuestaCuestionario> listaPreguntasEstandar = new LinkedList<>();
    
    @PostConstruct
    public void init() {}
    
    public void initHTML() {
        listaEstandar.addAll(estandarBL.listar());
    }
    
    public void initPDF() {
        file_path = "/resources/t/";
        rsc_report_path = "/org/edessco/sva/rpt/";
        generarReporte("rpt", "ReporteEstandar");
    }
    
    public List<RespuestaCuestionario> listarPreguntasEstandar(long id_estandar){
        listaPreguntasEstandar.clear();
        listaPreguntasEstandar.addAll(getRespuestaCuestionarioBL().listar(id_estandar));
        return listaPreguntasEstandar;
    }

    //<editor-fold defaultstate="collapsed" desc="GET'S & SET'S">
    public EstandarBL getEstandarBL() {
        return estandarBL;
    }

    public void setEstandarBL(EstandarBL estandarBL) {
        this.estandarBL = estandarBL;
    }

    public List<Estandar> getListaEstandar() {
        return listaEstandar;
    }

    public void setListaEstandar(List<Estandar> listaEstandar) {
        this.listaEstandar = listaEstandar;
    }

    public RespuestaCuestionarioBL getRespuestaCuestionarioBL() {
        return respuestaCuestionarioBL;
    }

    public void setRespuestaCuestionarioBL(RespuestaCuestionarioBL respuestaCuestionarioBL) {
        this.respuestaCuestionarioBL = respuestaCuestionarioBL;
    }
    //</editor-fold>
}
