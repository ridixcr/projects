/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.PreguntaEncuesta;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("preguntaEncuestaDA")
public class PreguntaEncuestaDA extends AbstractDA<PreguntaEncuesta>{
    
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
        return list(PreguntaEncuesta.class);
    }

    @Override
    public List<PreguntaEncuesta> listar(String ref) {
        return list("from PreguntaEncuesta pe left join fetch pe.estandar");
    }

    @Override
    public List<PreguntaEncuesta> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public PreguntaEncuesta buscar(long id) {
        return search(PreguntaEncuesta.class,id);
    }

    @Override
    public long id() {
        return maxId(PreguntaEncuesta.class);
    }

    @Override
    public PreguntaEncuesta buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<PreguntaEncuesta> listarPreguntas(long idEncuesta) {
        return list("from PreguntaEncuesta pe inner join fetch pe.encuesta e where e.idencuesta="+idEncuesta);
    }
}
