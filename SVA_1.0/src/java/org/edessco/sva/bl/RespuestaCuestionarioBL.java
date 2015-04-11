/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.RespuestaCuestionario;
import org.edessco.sva.da.RespuestaCuestionarioDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("respuestaCuestionarioBL")
public class RespuestaCuestionarioBL extends AbstractBL<RespuestaCuestionario>{
    @Autowired
    @Qualifier("respuestaCuestionarioDA")
    private RespuestaCuestionarioDA dao;

    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (RespuestaCuestionarioDA) dao;
    }

    @Override
    public long registrar(RespuestaCuestionario bean) {
        return save(bean);
    }

    @Override
    public long actualizar(RespuestaCuestionario bean) {
        return update(bean);
    }

    @Override
    public long eliminar(RespuestaCuestionario bean) {
        return delete(bean);
    }

    @Override
    public List<RespuestaCuestionario> listar() {
        return list();
    }

    @Override
    public List<RespuestaCuestionario> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<RespuestaCuestionario> listar(long id) {
        return list(id);
    }

    @Override
    public RespuestaCuestionario buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public RespuestaCuestionario buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
