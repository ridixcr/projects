/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.PreguntaCuestionario;
import org.edessco.sva.da.PreguntaCuestionarioDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("preguntaCuestionarioBL")
public class PreguntaCuestionarioBL extends AbstractBL<PreguntaCuestionario>{
    @Autowired
    @Qualifier("preguntaCuestionarioDA")
    private PreguntaCuestionarioDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(PreguntaCuestionarioDA) dao;
    }

    @Override
    public long registrar(PreguntaCuestionario bean) {
        return save(bean);
    }

    @Override
    public long actualizar(PreguntaCuestionario bean) {
        return update(bean);
    }

    @Override
    public long eliminar(PreguntaCuestionario bean) {
        return delete(bean);
    }

    @Override
    public List<PreguntaCuestionario> listar() {
        return list();
    }

    @Override
    public List<PreguntaCuestionario> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<PreguntaCuestionario> listar(long id) {
        return list(id);
    }

    @Override
    public PreguntaCuestionario buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public PreguntaCuestionario buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
