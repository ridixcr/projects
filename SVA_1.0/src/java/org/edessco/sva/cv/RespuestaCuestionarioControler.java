/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.cv;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import org.edessco.sva.be.Docente;
import org.edessco.sva.be.RespuestaCuestionario;
import org.edessco.sva.bl.RespuestaCuestionarioBL;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class RespuestaCuestionarioControler {

    @ManagedProperty(value = "#{respuestaCuestionarioBL}")
    private RespuestaCuestionarioBL respuestaCuestionarioBL;
    @ManagedProperty(value = "#{respuestaCuestionario}")
    private RespuestaCuestionario respuestaCuestionario;
    private List<RespuestaCuestionario> listaRptasCuestionario = new LinkedList<>();

    public RespuestaCuestionarioControler() {
    }

    public void registrar() {
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        getRespuestaCuestionario().getPreguntaCuestionario().setIdpreguntacuestionario((Long) sesion.getAttribute("idPreguntaCuestionario"));
        //Recuperar el docente de la sesion
        HttpSession sesionDoc = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        getRespuestaCuestionario().setDocente((Docente) sesionDoc.getAttribute("docente"));
        setTareaEvento(new Tarea(Tarea.REGISTRO, getRespuestaCuestionarioBL().registrar(getRespuestaCuestionario())) {
            @Override
            public void proceso() {
                respuestaCuestionario = new RespuestaCuestionario();
                listar();
            }
        });
        sesion.removeAttribute("idPreguntaEncuesta");
    }

    @PostConstruct
    public void listar() {
        setListaRptasCuestionario(getRespuestaCuestionarioBL().listar(""));
    }

    public RespuestaCuestionarioBL getRespuestaCuestionarioBL() {
        return respuestaCuestionarioBL;
    }

    public void setRespuestaCuestionarioBL(RespuestaCuestionarioBL respuestaCuestionarioBL) {
        this.respuestaCuestionarioBL = respuestaCuestionarioBL;
    }

    public RespuestaCuestionario getRespuestaCuestionario() {
        return respuestaCuestionario;
    }

    public void setRespuestaCuestionario(RespuestaCuestionario respuestaCuestionario) {
        this.respuestaCuestionario = respuestaCuestionario;
    }

    public List<RespuestaCuestionario> getListaRptasCuestionario() {
        return listaRptasCuestionario;
    }

    public void setListaRptasCuestionario(List<RespuestaCuestionario> listaRptasCuestionario) {
        this.listaRptasCuestionario = listaRptasCuestionario;
    }

}
