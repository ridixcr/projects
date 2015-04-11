/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Estandar;
import org.edessco.sva.da.EstandarDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("estandarBL")
public class EstandarBL extends AbstractBL<Estandar>{
    
    @Autowired
    @Qualifier("estandarDA")
    private EstandarDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(EstandarDA) dao;
    }

    @Override
    public long registrar(Estandar bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Estandar bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Estandar bean) {
        return delete(bean);
    }

    @Override
    public List<Estandar> listar() {
        return list();
    }

    @Override
    public List<Estandar> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Estandar> listar(long id) {
        return list(id);
    }

    @Override
    public Estandar buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Estandar buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
