/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Factor;
import org.edessco.sva.da.FactorDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("factorBL")
public class FactorBL extends AbstractBL<Factor>{
    @Autowired
    @Qualifier("factorDA")
    private FactorDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(FactorDA) dao;
    }
    
    @Override
    public long registrar(Factor bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Factor bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Factor bean) {
        return delete(bean);
    }

    @Override
    public List<Factor> listar() {
        return list();
    }

    @Override
    public List<Factor> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Factor> listar(long id) {
        return list(id);
    }

    @Override
    public Factor buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Factor buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
