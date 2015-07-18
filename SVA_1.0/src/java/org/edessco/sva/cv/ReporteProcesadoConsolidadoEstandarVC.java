package org.edessco.sva.cv;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.edessco.sva.be.ItemReporteProcesadoConsolidadoEstandar;
import org.edessco.sva.be.RegistroGradoCumplimiento;
import org.edessco.sva.bl.RegistroGradoCumplimientoBL;
import org.edessco.sva.util.ReportViewerBean;

@ManagedBean
@ViewScoped
public class ReporteProcesadoConsolidadoEstandarVC extends ReportViewerBean implements Serializable {
    @ManagedProperty(value = "#{registroGradoCumplimiento}")
    private RegistroGradoCumplimiento registroGradoCumplimiento;
    @ManagedProperty(value = "#{registroGradoCumplimientoBL}")
    private RegistroGradoCumplimientoBL registroGradoCumplimientoBL;
    private List registroProcesadoConsolidado = new LinkedList<>();
    private List<ItemReporteProcesadoConsolidadoEstandar> lista = new LinkedList<>();
    
    @PostConstruct
    public void init() {}
    
    public void initHTML() {
        registroProcesadoConsolidado
                .addAll(getRegistroGradoCumplimientoBL().reporteProcesadoConsolidadoEstandar());
        lista.clear();
        for (Object item : registroProcesadoConsolidado) {
            Object[] o = (Object[])item;  
            lista.add(new ItemReporteProcesadoConsolidadoEstandar(
                            o[0].toString(),
                            o[1].toString(),
                            o[5].toString(),
                            o[3].toString(),
                            o[6].toString(),
                            o[7].toString()));            
        }
    }
    
    public void initPDF() {
        file_path = "/resources/t/";
        rsc_report_path = "/org/edessco/sva/rpt/";
        generarReporte("rpt", "ReporteConsolidadoEstandar");
    }

    //<editor-fold defaultstate="collapsed" desc="GET'S & SET'S">
    public RegistroGradoCumplimiento getRegistroGradoCumplimiento() {
        return registroGradoCumplimiento;
    }

    public void setRegistroGradoCumplimiento(RegistroGradoCumplimiento registroGradoCumplimiento) {
        this.registroGradoCumplimiento = registroGradoCumplimiento;
    }

    public RegistroGradoCumplimientoBL getRegistroGradoCumplimientoBL() {
        return registroGradoCumplimientoBL;
    }

    public void setRegistroGradoCumplimientoBL(RegistroGradoCumplimientoBL registroGradoCumplimientoBL) {
        this.registroGradoCumplimientoBL = registroGradoCumplimientoBL;
    }

    public List<ItemReporteProcesadoConsolidadoEstandar> getLista() {
        return lista;
    }

    public void setLista(List<ItemReporteProcesadoConsolidadoEstandar> lista) {
        this.lista = lista;
    }
    //</editor-fold>
}
