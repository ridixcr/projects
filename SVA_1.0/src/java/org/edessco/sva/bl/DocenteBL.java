/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Docente;
import org.edessco.sva.da.DocenteDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("docenteBL")
public class DocenteBL extends AbstractBL<Docente>{

    @Autowired
    @Qualifier("docenteDA")
    private DocenteDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(DocenteDA) dao;
    }

    @Override
    public long registrar(Docente bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Docente bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Docente bean) {
        return delete(bean);
    }

    @Override
    public List<Docente> listar() {
        return list();
    }

    @Override
    public List<Docente> listar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Docente> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Docente buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Docente buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
