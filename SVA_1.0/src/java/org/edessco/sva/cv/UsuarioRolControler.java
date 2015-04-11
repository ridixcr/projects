/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.cv;

import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import org.edessco.sva.be.UsuarioRol;
import org.edessco.sva.bl.UsuarioRolBL;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class UsuarioRolControler {

    @ManagedProperty(value = "#{usaurioRolBL}")
    private UsuarioRolBL usuarioRolBL;
    @ManagedProperty(value = "#{usuarioRol}")
    private UsuarioRol usuarioRol;

    public UsuarioRolControler() {
    }

    public void registrar() {
        long resUR = getUsuarioRolBL().registrar(getUsuarioRol());
    }

    public UsuarioRolBL getUsuarioRolBL() {
        return usuarioRolBL;
    }

    public void setUsuarioRolBL(UsuarioRolBL usuarioRolBL) {
        this.usuarioRolBL = usuarioRolBL;
    }

    public UsuarioRol getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(UsuarioRol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

}
