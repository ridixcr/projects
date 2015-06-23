package org.edessco.sva.cv;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.edessco.sva.util.ReportViewerBean;

@ManagedBean
@ViewScoped
public class RegistroProcesadoEstandarVC extends ReportViewerBean implements Serializable {
    
    @PostConstruct
    public void init() {
        file_path = "/resources/t/";
        rsc_report_path = "/org/edessco/sva/rpt/";
        generarReporte("rpt", "RegistroProcesadoEstandar");
    }
}
