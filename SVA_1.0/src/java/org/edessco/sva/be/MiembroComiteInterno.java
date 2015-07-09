package org.edessco.sva.be;
// Generated 27-may-2015 1:26:58 by Hibernate Tools 4.3.1


import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * MiembroComiteInterno generated by hbm2java
 */
@Component
public class MiembroComiteInterno  implements java.io.Serializable {


     private Long idmiembrocomiteinterno;
     private ComiteInterno comiteInterno;
     private Persona persona;
     private String cargo;
     private Date fechaDesde;
     private Date fechaHasta;

    public MiembroComiteInterno() {
        this.idmiembrocomiteinterno = Long.parseLong("0");
        this.persona = new Persona();
        this.comiteInterno = new ComiteInterno();
    }

	
    public MiembroComiteInterno(ComiteInterno comiteInterno, Persona persona) {
        this.comiteInterno = comiteInterno;
        this.persona = persona;
    }
    public MiembroComiteInterno(ComiteInterno comiteInterno, Persona persona, String cargo, Date fechaDesde, Date fechaHasta) {
       this.comiteInterno = comiteInterno;
       this.persona = persona;
       this.cargo = cargo;
       this.fechaDesde = fechaDesde;
       this.fechaHasta = fechaHasta;
    }
   
    public Long getIdmiembrocomiteinterno() {
        return this.idmiembrocomiteinterno;
    }
    
    public void setIdmiembrocomiteinterno(Long idmiembrocomiteinterno) {
        this.idmiembrocomiteinterno = idmiembrocomiteinterno;
    }
    public ComiteInterno getComiteInterno() {
        return this.comiteInterno;
    }
    
    public void setComiteInterno(ComiteInterno comiteInterno) {
        this.comiteInterno = comiteInterno;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public Date getFechaDesde() {
        return this.fechaDesde;
    }
    
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    public Date getFechaHasta() {
        return this.fechaHasta;
    }
    
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }




}


