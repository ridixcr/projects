package org.edessco.sva.cv;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.edessco.sva.be.Estandar;
import org.edessco.sva.be.ItemReporteEstadisticoAlumnoChart;
import org.edessco.sva.be.ItemReporteEstadisticoAlumnoTabla;
import org.edessco.sva.bl.EstandarBL;
import org.edessco.sva.bl.PreguntaEncuestaBL;
import org.edessco.sva.util.ReportViewerBean;

@ManagedBean
@ViewScoped
public class REEncuestaEstandarAlumnoVC extends ReportViewerBean implements Serializable {

    @ManagedProperty(value = "#{estandarBL}")
    private EstandarBL estandarBL;
    private List<Estandar> listaEstandar = new LinkedList<>();
    
    @ManagedProperty(value = "#{preguntaEncuestaBL}")
    private PreguntaEncuestaBL preguntaEncuestaBL;
    
    private List<ItemReporteEstadisticoAlumnoTabla> listaItemsReporteEstadisticoAlumnoTabla = new LinkedList<>();
    private List listaR1 = new LinkedList<>();
    private List<ItemReporteEstadisticoAlumnoChart> listaItemsReporteEstadisticoAlumnoChart = new LinkedList<>();
    private List listaR2 = new LinkedList<>();
    
    @PostConstruct
    public void init() {
    }
    
    public void initHTML() {
        listaEstandar.addAll(estandarBL.listar());
    }
    
    public void initPDF() {
        file_path = "/resources/t/";
        rsc_report_path = "/org/edessco/sva/rpt/";
        generarReporte("rpt", "re_encuesta_estandar",
                "re_encuesta_estandar_sub");
    }
    
    public List<ItemReporteEstadisticoAlumnoTabla> listarItemsReporteEstadisticoAlumnoTabla(long id_estandar){
        //<editor-fold defaultstate="collapsed" desc="CUERPO">
        listaR1.clear();        
        listaR1.addAll(getPreguntaEncuestaBL().reporteEstadisticoEncuestaEstudiantesTabla(id_estandar));
        listaItemsReporteEstadisticoAlumnoTabla.clear();
        for (Object item : listaR1) {
            Object[] o = (Object[])item;  
            listaItemsReporteEstadisticoAlumnoTabla.add(new ItemReporteEstadisticoAlumnoTabla(
                            o[0].toString(),
                            o[1].toString(),
                            o[2].toString(),
                            o[3].toString(),
                            o[4].toString(),
                            o[5].toString(),
                            o[6].toString(),
                            o[7].toString(),
                            o[8].toString(),
                            o[9].toString(),
                            o[10].toString(),
                            o[11].toString(),
                            o[12].toString()
            ));            
        }
        return listaItemsReporteEstadisticoAlumnoTabla;
        //</editor-fold>
    } 
    public List<ItemReporteEstadisticoAlumnoChart> listaItemsReporteEstadisticoAlumnoChart(long id_estandar){
        //<editor-fold defaultstate="collapsed" desc="CUERPO">
        listaR2.clear();        
        listaR2.addAll(getPreguntaEncuestaBL().reporteEstadisticoEncuestaEstudiantesChart(id_estandar));
        listaItemsReporteEstadisticoAlumnoChart.clear();
        for (Object item : listaR2) {
            Object[] o = (Object[])item;  
            listaItemsReporteEstadisticoAlumnoChart.add(new ItemReporteEstadisticoAlumnoChart(
                            o[0].toString(),
                            o[1].toString(),
                            o[2].toString()
            ));            
        }
        return listaItemsReporteEstadisticoAlumnoChart;
        //</editor-fold>
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
    public PreguntaEncuestaBL getPreguntaEncuestaBL() {
        return preguntaEncuestaBL;
    }

    public void setPreguntaEncuestaBL(PreguntaEncuestaBL preguntaEncuestaBL) {
        this.preguntaEncuestaBL = preguntaEncuestaBL;
    }
    //</editor-fold>
}
