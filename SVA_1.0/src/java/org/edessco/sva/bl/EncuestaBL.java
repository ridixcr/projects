/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Encuesta;
import org.edessco.sva.da.EncuestaDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("encuestaBL")
public class EncuestaBL extends AbstractBL<Encuesta>{
    @Autowired
    @Qualifier("encuestaDA")
    private EncuestaDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(EncuestaDA) dao;
    }

    @Override
    public long registrar(Encuesta bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Encuesta bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Encuesta bean) {
        return delete(bean);
    }

    @Override
    public List<Encuesta> listar() {
        return list();
    }

    @Override
    public List<Encuesta> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Encuesta> listar(long id) {
        return list(id);
    }

    @Override
    public Encuesta buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Encuesta buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
