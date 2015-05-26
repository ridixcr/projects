/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.cv;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import org.edessco.sva.be.Alumno;
import org.edessco.sva.bl.AlumnoBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class AlumnoControler {

    @ManagedProperty(value = "#{alumnoBL}")
    private AlumnoBL alumnoBL;
    @ManagedProperty(value = "#{alumno}")
    private Alumno alumno;
    
    public AlumnoControler() {
    }
    
    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getAlumnoBL().registrar(getAlumno())) {
            @Override
            public void proceso() {
                alumno = new Alumno();
                //listar();
            }
        });
    }

    public AlumnoBL getAlumnoBL() {
        return alumnoBL;
    }

    public void setAlumnoBL(AlumnoBL alumnoBL) {
        this.alumnoBL = alumnoBL;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
}
