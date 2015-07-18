/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.PreguntaEncuesta;
import org.edessco.sva.da.PreguntaEncuestaDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("preguntaEncuestaBL")
public class PreguntaEncuestaBL extends AbstractBL<PreguntaEncuesta>{
    
    @Autowired
    @Qualifier("preguntaEncuestaDA")
    private PreguntaEncuestaDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(PreguntaEncuestaDA) dao;
    }

    @Override
    public long registrar(PreguntaEncuesta bean) {
        return save(bean);
    }

    @Override
    public long actualizar(PreguntaEncuesta bean) {
        return update(bean);
    }

    @Override
    public long eliminar(PreguntaEncuesta bean) {
        return delete(bean);
    }

    @Override
    public List<PreguntaEncuesta> listar() {
        return list();
    }

    @Override
    public List<PreguntaEncuesta> listar(String ref) {
        return list(ref);
    }
    
    public List<PreguntaEncuesta> listarEstandaresEncuesta(){
        return dao.listarEstandaresEncuesta();
    }

    @Override
    public List<PreguntaEncuesta> listar(long id) {
        return list(id);
    }

    @Override
    public PreguntaEncuesta buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public PreguntaEncuesta buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<PreguntaEncuesta> listarPreguntas(long idEncuesta) {
        return dao.listarPreguntas(idEncuesta);
    }
}
