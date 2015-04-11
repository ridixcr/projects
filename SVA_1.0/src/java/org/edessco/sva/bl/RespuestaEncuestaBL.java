/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.RespuestaEncuesta;
import org.edessco.sva.da.RespuestaEncuestaDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("respuestaEncuestaBL")
public class RespuestaEncuestaBL extends AbstractBL<RespuestaEncuesta> {

    @Autowired
    @Qualifier("respuestaEncuestaDA")
    private RespuestaEncuestaDA dao;

    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (RespuestaEncuestaDA) dao;
    }

    @Override
    public long registrar(RespuestaEncuesta bean) {
        return save(bean);
    }

    @Override
    public long actualizar(RespuestaEncuesta bean) {
        return update(bean);
    }

    @Override
    public long eliminar(RespuestaEncuesta bean) {
        return delete(bean);
    }

    @Override
    public List<RespuestaEncuesta> listar() {
        return list();
    }

    @Override
    public List<RespuestaEncuesta> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<RespuestaEncuesta> listar(long id) {
        return list(id);
    }

    @Override
    public RespuestaEncuesta buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public RespuestaEncuesta buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
