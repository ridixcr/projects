package org.edessco.sva.be;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.springframework.stereotype.Component;

@Component
public class ItemReporteTotalEncuestasEstandar implements Serializable{
        private String nro;
        private String estandar;
        private String encuesta;
        private String tipo_encuesta;
        private String cantidad;
        private String porcentajes_completados;
        private String completos;
        private String porcentaje_pendientes;
        private String pendientes;

    public ItemReporteTotalEncuestasEstandar() {
        setNro("");
        setEstandar("");
        setEncuesta("");
        setTipo_encuesta("");
        setCantidad("");
        setPorcentajes_completados("");
        setCompletos("");
        setPorcentaje_pendientes("");
        setPendientes("");
    }
    public ItemReporteTotalEncuestasEstandar(String nro, String estandar, String encuesta, String tipo_encuesta, String cantidad, String porcentajes_completados, String completos, String porcentaje_pendientes, String pendientes) {
        this.nro = nro;
        this.estandar = estandar;
        this.encuesta = encuesta;
        this.tipo_encuesta = tipo_encuesta;
        this.cantidad = new DecimalFormat("00").format(Double.parseDouble(cantidad));
        this.porcentajes_completados = new DecimalFormat("00").format(Double.parseDouble(porcentajes_completados));
        this.completos = new DecimalFormat("00").format(Double.parseDouble(completos));
        this.porcentaje_pendientes = new DecimalFormat("00").format(Double.parseDouble(porcentaje_pendientes));
        this.pendientes = new DecimalFormat("00").format(Double.parseDouble(pendientes));
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

    public String getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(String encuesta) {
        this.encuesta = encuesta;
    }

    public String getTipo_encuesta() {
        return tipo_encuesta;
    }

    public void setTipo_encuesta(String tipo_encuesta) {
        this.tipo_encuesta = tipo_encuesta;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPorcentajes_completados() {
        return porcentajes_completados;
    }

    public void setPorcentajes_completados(String porcentajes_completados) {
        this.porcentajes_completados = porcentajes_completados;
    }

    public String getCompletos() {
        return completos;
    }

    public void setCompletos(String completos) {
        this.completos = completos;
    }

    public String getPorcentaje_pendientes() {
        return porcentaje_pendientes;
    }

    public void setPorcentaje_pendientes(String porcentaje_pendientes) {
        this.porcentaje_pendientes = porcentaje_pendientes;
    }

    public String getPendientes() {
        return pendientes;
    }

    public void setPendientes(String pendientes) {
        this.pendientes = pendientes;
    }
    }
