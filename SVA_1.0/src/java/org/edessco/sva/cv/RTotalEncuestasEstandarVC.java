package org.edessco.sva.cv;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.edessco.sva.util.ReportViewerBean;

@ManagedBean
@ViewScoped
public class RTotalEncuestasEstandarVC extends ReportViewerBean implements Serializable {
    
    @PostConstruct
    public void init() {}
    
    public void initHTML() {
//        registroProcesadoConsolidado
//                .addAll(getRegistroGradoCumplimientoBL().reporteProcesadoEstandar());
//        lista.clear();
//        for (Object item : registroProcesadoConsolidado) {
//            Object[] o = (Object[])item;  
//            lista.add(new ItemReporteProcesadoConsolidadoEstandar(
//                            o[0].toString(),
//                            o[1].toString(),
//                            o[2].toString(),
//                            "0",
//                            o[3].toString(),
//                            o[4].toString()));            
//        }
    }
    
    public void initPDF() {
        file_path = "/resources/t/";
        rsc_report_path = "/org/edessco/sva/rpt/";
        generarReporte("rpt", "ReporteTotalEncuestasEstandar");
    }
}
