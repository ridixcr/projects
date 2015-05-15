/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.cv;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class UrlControler {

    private String tipoUser = "";

    public UrlControler() {
    }

    public String registrarUser() {
        String url = "";
        switch (getTipoUser().trim()) {
            case "Alumno":
                url = "registrarAlumno";
                break;
            case "Egresado":
                url = "registrarEgresado";
                break;
            case "Administrativo":
                url = "registrarAdministrativo";
                break;
            case "Docente":
                url = "registrarDocente";
                break;
            case "Grupo de interés":
                url = "registrarGrupoInteres";
                break;
        }
        return url + "?faces-redirect=true";
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

}
