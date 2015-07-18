package org.edessco.sva.cv;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.edessco.sva.be.Estandar;
import org.edessco.sva.be.ItemReporteTotalEncuestasEstandar;
import org.edessco.sva.bl.EstandarBL;
import org.edessco.sva.bl.PreguntaEncuestaBL;
import org.edessco.sva.util.ReportViewerBean;

@ManagedBean
@ViewScoped
public class RTotalEncuestasEstandarVC extends ReportViewerBean implements Serializable {
    @ManagedProperty(value = "#{estandarBL}")
    private EstandarBL estandarBL;
    private List<Estandar> listaEstandar = new LinkedList<>();
        
    @ManagedProperty(value = "#{preguntaEncuestaBL}")
    private PreguntaEncuestaBL preguntaEncuestaBL;
    private List listaResultadosEncuesta = new LinkedList<>();
    private List<ItemReporteTotalEncuestasEstandar> listaTotalEncuestasEstandar = new LinkedList<>();
    
    @PostConstruct
    public void init() {}
    
    public void initHTML() {
        listaEstandar.addAll(estandarBL.listar());
    }
    public List<ItemReporteTotalEncuestasEstandar> listarTotalEncuestasEstandar(long id_estandar){
        listaResultadosEncuesta.clear();        
        listaResultadosEncuesta.addAll(getPreguntaEncuestaBL().reporteTotalEncuestasEstandar(id_estandar));
        listaTotalEncuestasEstandar.clear();
        for (Object item : listaResultadosEncuesta) {
            Object[] o = (Object[])item;  
            System.out.println(o[2].toString());
            listaTotalEncuestasEstandar.add(new ItemReporteTotalEncuestasEstandar(
                            o[0].toString(),
                            o[1].toString(),
                            o[2].toString(),
                            o[3].toString(),
                            o[4].toString(),
                            o[5].toString(),
                            o[6].toString(),
                            o[7].toString(),
                            o[8].toString()
            ));            
        }
        return listaTotalEncuestasEstandar;
    }
    
    
    public void initPDF() {
        file_path = "/resources/t/";
        rsc_report_path = "/org/edessco/sva/rpt/";
        generarReporte("rpt", "ReporteTotalEncuestasEstandar");
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

    public List getListaResultadosEncuesta() {
        return listaResultadosEncuesta;
    }

    public void setListaResultadosEncuesta(List listaResultadosEncuesta) {
        this.listaResultadosEncuesta = listaResultadosEncuesta;
    }

    public PreguntaEncuestaBL getPreguntaEncuestaBL() {
        return preguntaEncuestaBL;
    }

    public void setPreguntaEncuestaBL(PreguntaEncuestaBL preguntaEncuestaBL) {
        this.preguntaEncuestaBL = preguntaEncuestaBL;
    }
    //</editor-fold>
}
