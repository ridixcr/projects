/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Autoevaluacion;
import org.edessco.sva.da.AutoevaluacionDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("autoevaluacionBL")
public class AutoevaluacionBL extends AbstractBL<Autoevaluacion>{
    
    @Autowired
    @Qualifier("autoevaluacionDA")
    private AutoevaluacionDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(AutoevaluacionDA) dao;
    }

    @Override
    public long registrar(Autoevaluacion bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Autoevaluacion bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Autoevaluacion bean) {
        return delete(bean);
    }

    @Override
    public List<Autoevaluacion> listar() {
        return list();
    }

    @Override
    public List<Autoevaluacion> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Autoevaluacion> listar(long id) {
        return list(id);
    }

    @Override
    public Autoevaluacion buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Autoevaluacion buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
