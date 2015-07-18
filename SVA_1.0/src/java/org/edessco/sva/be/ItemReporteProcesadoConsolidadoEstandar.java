package org.edessco.sva.be;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.springframework.stereotype.Component;

@Component
public class ItemReporteProcesadoConsolidadoEstandar implements Serializable{
        private String nro;
        private String estandar;
        private String cumplimiento_si_no;
        private String cumplimiento_porcentaje;
        private String explicacion;
        private String alternativa_solucion;

        public ItemReporteProcesadoConsolidadoEstandar() {
            setNro("");
            setEstandar("");
            setCumplimiento_si_no("");
            setCumplimiento_porcentaje("");
            setExplicacion("");
            setAlternativa_solucion("");
        }

        public ItemReporteProcesadoConsolidadoEstandar(String nro, String estandar, String cumplimiento_si_no, String cumplimiento_porcentaje, String explicacion, String alternativa_solucion) {
            setNro(nro);
            setEstandar(estandar);
            setCumplimiento_si_no(cumplimiento_si_no);
            setCumplimiento_porcentaje(new DecimalFormat("00").format(Double.parseDouble(cumplimiento_porcentaje)));
            setExplicacion(explicacion);
            setAlternativa_solucion(alternativa_solucion);
        }
        
 
        public String getNro() {
            return nro;
        }

        public void setNro(String nro) {
            this.nro = nro;
        }

        public String getEstandar() {
            return estandar;
        }

        public void setEstandar(String estandar) {
            this.estandar = estandar;
        }

        public String getCumplimiento_si_no() {
            return cumplimiento_si_no;
        }

        public void setCumplimiento_si_no(String cumplimiento_si_no) {
            this.cumplimiento_si_no = cumplimiento_si_no;
        }

        public String getCumplimiento_porcentaje() {
            return cumplimiento_porcentaje;
        }

        public void setCumplimiento_porcentaje(String cumplimiento_porcentaje) {
            this.cumplimiento_porcentaje = cumplimiento_porcentaje;
        }

        public String getExplicacion() {
            return explicacion;
        }

        public void setExplicacion(String explicacion) {
            this.explicacion = explicacion;
        }

        public String getAlternativa_solucion() {
            return alternativa_solucion;
        }

        public void setAlternativa_solucion(String alternativa_solucion) {
            this.alternativa_solucion = alternativa_solucion;
        }
    }
