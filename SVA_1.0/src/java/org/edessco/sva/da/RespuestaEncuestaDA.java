/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.RespuestaEncuesta;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("respuestaEncuestaDA")
public class RespuestaEncuestaDA extends AbstractDA<RespuestaEncuesta>{
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
        return list(RespuestaEncuesta.class);
    }

    @Override
    public List<RespuestaEncuesta> listar(String ref) {
        return list("from RespuestaEncuesta re left join fetch re.preguntaEncuesta");
    }

    @Override
    public List<RespuestaEncuesta> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public RespuestaEncuesta buscar(long id) {
        return search(RespuestaEncuesta.class,id);
    }

    @Override
    public long id() {
        return maxId(RespuestaEncuesta.class);
    }

    @Override
    public RespuestaEncuesta buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
