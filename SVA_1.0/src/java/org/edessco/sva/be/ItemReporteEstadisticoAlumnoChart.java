package org.edessco.sva.be;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.springframework.stereotype.Component;

@Component
public class ItemReporteEstadisticoAlumnoChart implements Serializable {

    private String respuesta;
    private String frecuencia;
    private String porcentaje;

    public ItemReporteEstadisticoAlumnoChart() {
        setRespuesta("");
        setFrecuencia("");
        setPorcentaje("");
    }

    public ItemReporteEstadisticoAlumnoChart(String respuesta, String frecuencia, String porcentaje) {
        this.respuesta = respuesta;
        this.frecuencia = new DecimalFormat("00").format(Double.parseDouble(frecuencia));
        this.porcentaje = new DecimalFormat("00.00").format(Double.parseDouble(porcentaje));
    }
    
    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }
}
