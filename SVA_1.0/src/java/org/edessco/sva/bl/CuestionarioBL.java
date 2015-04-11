/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Cuestionario;
import org.edessco.sva.da.CuestionarioDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("cuestionarioBL")
public class CuestionarioBL extends AbstractBL<Cuestionario>{
    @Autowired
    @Qualifier("cuestionarioDA")
    private CuestionarioDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(CuestionarioDA) dao;
    }

    @Override
    public long registrar(Cuestionario bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Cuestionario bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Cuestionario bean) {
        return delete(bean);
    }

    @Override
    public List<Cuestionario> listar() {
        return list();
    }

    @Override
    public List<Cuestionario> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Cuestionario> listar(long id) {
        return list(id);
    }

    @Override
    public Cuestionario buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Cuestionario buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
