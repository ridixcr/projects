/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.cv;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import org.edessco.sva.be.Administrativo;
import org.edessco.sva.be.Alumno;
import org.edessco.sva.bl.AdministrativoBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class AdministrativoControler {

    @ManagedProperty(value = "#{administrativoBL}")
    private AdministrativoBL administrativoBL;
    @ManagedProperty(value = "#{administrativo}")
    private Administrativo administrativo;
    public AdministrativoControler() {
    }
    
    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getAdministrativoBL().registrar(getAdministrativo())) {
            @Override
            public void proceso() {
                administrativo = new Administrativo();
                //listar();
            }
        });
    }

    public AdministrativoBL getAdministrativoBL() {
        return administrativoBL;
    }

    public void setAdministrativoBL(AdministrativoBL administrativoBL) {
        this.administrativoBL = administrativoBL;
    }

    public Administrativo getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(Administrativo administrativo) {
        this.administrativo = administrativo;
    }
    
}
