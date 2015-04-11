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
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import org.edessco.sva.be.Rol;
import org.edessco.sva.bl.RolBL;


/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@ViewScoped
public class RolControler {
    
    @ManagedProperty(value = "#{rolBL}")
    private RolBL rolBL;
    @ManagedProperty(value = "#{rol}")
    private Rol rol;
    private List<Rol> listRoles = new LinkedList<>();

    private List<SelectItem> selectOneItemsRol;
    
    public RolControler() {
    }
    
    @PostConstruct
    public void listarRoles() {
        setListRoles(getRolBL().listar());
    }  

    public RolBL getRolBL() {
        return rolBL;
    }

    public void setRolBL(RolBL rolBL) {
        this.rolBL = rolBL;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getListRoles() {
        return listRoles;
    }

    public void setListRoles(List<Rol> listRoles) {
        this.listRoles = listRoles;
    }

    public List<SelectItem> getSelectOneItemsRol() {
        this.selectOneItemsRol = new LinkedList<SelectItem>();
        for (Rol rol1 : listRoles) {
            this.setRol(rol1);
            SelectItem selectItem = new SelectItem(rol.getIdrol(), rol.getNombreRol());
            this.selectOneItemsRol.add(selectItem);
        }
        return selectOneItemsRol;
    }

    public void setSelectOneItemsRol(List<SelectItem> selectOneItemsRol) {
        this.selectOneItemsRol = selectOneItemsRol;
    }
    
}
