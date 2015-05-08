/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Criterio;
import org.edessco.sva.da.CriterioDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("criterioBL")
public class CriterioBL extends AbstractBL<Criterio>{
    @Autowired
    @Qualifier("criterioDA")
    private CriterioDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(CriterioDA) dao;
    }

    @Override
    public long registrar(Criterio bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Criterio bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Criterio bean) {
        return delete(bean);
    }

    @Override
    public List<Criterio> listar() {
        return list();
    }

    @Override
    public List<Criterio> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Criterio> listar(long id) {
        return list(id);
    }

    @Override
    public Criterio buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Criterio buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Criterio> listarCriterio(long id) {
        return dao.listarCriterio(id);
    }
}
