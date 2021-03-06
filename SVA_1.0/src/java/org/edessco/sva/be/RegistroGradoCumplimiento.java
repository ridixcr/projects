package org.edessco.sva.be;
// Generated 27-may-2015 1:26:58 by Hibernate Tools 4.3.1

import org.springframework.stereotype.Component;




/**
 * RegistroGradoCumplimiento generated by hbm2java
 */
@Component
public class RegistroGradoCumplimiento  implements java.io.Serializable {


     private Long idgradocumplimiento;
     private Autoevaluacion autoevaluacion;
     private Estandar estandar;
     private boolean cumplimiento=false;
     private String explicacionConsolidada;
     private boolean estado=false;

    public RegistroGradoCumplimiento() {
        setIdgradocumplimiento(new Long(0));
    }

	
    public RegistroGradoCumplimiento(Autoevaluacion autoevaluacion, Estandar estandar) {
        this.autoevaluacion = autoevaluacion;
        this.estandar = estandar;
    }
    public RegistroGradoCumplimiento(Autoevaluacion autoevaluacion, Estandar estandar, boolean cumplimiento, String explicacionConsolidada, boolean estado) {
       this.autoevaluacion = autoevaluacion;
       this.estandar = estandar;
       this.cumplimiento = cumplimiento;
       this.explicacionConsolidada = explicacionConsolidada;
       this.estado = estado;
    }
   
    public Long getIdgradocumplimiento() {
        return this.idgradocumplimiento;
    }
    
    public void setIdgradocumplimiento(Long idgradocumplimiento) {
        this.idgradocumplimiento = idgradocumplimiento;
    }
    public Autoevaluacion getAutoevaluacion() {
        return this.autoevaluacion;
    }
    
    public void setAutoevaluacion(Autoevaluacion autoevaluacion) {
        this.autoevaluacion = autoevaluacion;
    }
    public Estandar getEstandar() {
        return this.estandar;
    }
    
    public void setEstandar(Estandar estandar) {
        this.estandar = estandar;
    }
    public boolean getCumplimiento() {
        return this.cumplimiento;
    }
    
    public void setCumplimiento(boolean cumplimiento) {
        this.cumplimiento = cumplimiento;
    }
    public String getExplicacionConsolidada() {
        return this.explicacionConsolidada;
    }
    
    public void setExplicacionConsolidada(String explicacionConsolidada) {
        this.explicacionConsolidada = explicacionConsolidada;
    }
    public boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }




}


