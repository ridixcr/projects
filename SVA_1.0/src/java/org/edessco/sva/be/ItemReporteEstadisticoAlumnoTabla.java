package org.edessco.sva.be;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.springframework.stereotype.Component;

@Component
public class ItemReporteEstadisticoAlumnoTabla implements Serializable{
        private String nro;
        private String estandar;
        private String encuesta;
        private String totalmente_acuerdo;
        private String p_totalmente_acuerdo;
        private String de_acuerdo;
        private String p_de_acuerdo;
        private String poco_de_acuerdo;
        private String p_poco_de_acuerdo;
        private String en_desacuerdo;
        private String p_en_desacuerdo;
        private String no_conosco_tema;
        private String p_no_conosco_tema;

    public ItemReporteEstadisticoAlumnoTabla() {
        setNro("");
        setEstandar("");
        setEncuesta("");
        setTotalmente_acuerdo("");
        setP_totalmente_acuerdo("");
        setDe_acuerdo("");
        setP_de_acuerdo("");
        setPoco_de_acuerdo("");
        setP_poco_de_acuerdo("");
        setEn_desacuerdo("");
        setP_en_desacuerdo("");
        setNo_conosco_tema("");
        setP_no_conosco_tema("");
    }

    public ItemReporteEstadisticoAlumnoTabla(String nro,String encuesta, String estandar, String totalmente_acuerdo, String de_acuerdo,String poco_de_acuerdo, String en_desacuerdo, String no_conosco_tema,String p_totalmente_acuerdo, String p_de_acuerdo, String p_poco_de_acuerdo, String p_en_desacuerdo, String p_no_conosco_tema) {
        this.nro = nro;
        this.estandar = estandar;
        this.encuesta = encuesta;
        this.totalmente_acuerdo = new DecimalFormat("00").format(Double.parseDouble(totalmente_acuerdo));
        this.p_totalmente_acuerdo = new DecimalFormat("00.00").format(Double.parseDouble(p_totalmente_acuerdo));
        this.de_acuerdo = new DecimalFormat("00").format(Double.parseDouble(de_acuerdo));
        this.p_de_acuerdo = new DecimalFormat("00.00").format(Double.parseDouble(p_de_acuerdo));
        this.poco_de_acuerdo = new DecimalFormat("00").format(Double.parseDouble(poco_de_acuerdo));
        this.p_poco_de_acuerdo = new DecimalFormat("00.00").format(Double.parseDouble(p_poco_de_acuerdo));
        this.en_desacuerdo = new DecimalFormat("00").format(Double.parseDouble(en_desacuerdo));
        this.p_en_desacuerdo = new DecimalFormat("00.00").format(Double.parseDouble(p_en_desacuerdo));
        this.no_conosco_tema = new DecimalFormat("00").format(Double.parseDouble(no_conosco_tema));
        this.p_no_conosco_tema = new DecimalFormat("00.00").format(Double.parseDouble(p_no_conosco_tema));
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

    public String getTotalmente_acuerdo() {
        return totalmente_acuerdo;
    }

    public void setTotalmente_acuerdo(String totalmente_acuerdo) {
        this.totalmente_acuerdo = totalmente_acuerdo;
    }

    public String getDe_acuerdo() {
        return de_acuerdo;
    }

    public void setDe_acuerdo(String de_acuerdo) {
        this.de_acuerdo = de_acuerdo;
    }

    public String getPoco_de_acuerdo() {
        return poco_de_acuerdo;
    }

    public void setPoco_de_acuerdo(String poco_de_acuerdo) {
        this.poco_de_acuerdo = poco_de_acuerdo;
    }

    public String getEn_desacuerdo() {
        return en_desacuerdo;
    }

    public void setEn_desacuerdo(String en_desacuerdo) {
        this.en_desacuerdo = en_desacuerdo;
    }

    public String getNo_conosco_tema() {
        return no_conosco_tema;
    }

    public void setNo_conosco_tema(String no_conosco_tema) {
        this.no_conosco_tema = no_conosco_tema;
    }

    public String getP_totalmente_acuerdo() {
        return p_totalmente_acuerdo;
    }

    public void setP_totalmente_acuerdo(String p_totalmente_acuerdo) {
        this.p_totalmente_acuerdo = p_totalmente_acuerdo;
    }

    public String getP_de_acuerdo() {
        return p_de_acuerdo;
    }

    public void setP_de_acuerdo(String p_de_acuerdo) {
        this.p_de_acuerdo = p_de_acuerdo;
    }

    public String getP_poco_de_acuerdo() {
        return p_poco_de_acuerdo;
    }

    public void setP_poco_de_acuerdo(String p_poco_de_acuerdo) {
        this.p_poco_de_acuerdo = p_poco_de_acuerdo;
    }

    public String getP_en_desacuerdo() {
        return p_en_desacuerdo;
    }

    public void setP_en_desacuerdo(String p_en_desacuerdo) {
        this.p_en_desacuerdo = p_en_desacuerdo;
    }

    public String getP_no_conosco_tema() {
        return p_no_conosco_tema;
    }

    public void setP_no_conosco_tema(String p_no_conosco_tema) {
        this.p_no_conosco_tema = p_no_conosco_tema;
    }
        
       
}
