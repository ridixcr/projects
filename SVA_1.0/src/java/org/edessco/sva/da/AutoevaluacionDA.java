/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Autoevaluacion;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("autoevaluacionDA")
public class AutoevaluacionDA extends AbstractDA<Autoevaluacion>{
    
    @Override
    public long registrar(Autoevaluacion bean) {
         return save(bean);
    }

    @Override
    public long actualizar(Autoevaluacion bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Autoevaluacion bean) {
        return delete(bean);
    }

    @Override
    public List<Autoevaluacion> listar() {
        return list(Autoevaluacion.class);
    }

    @Override
    public List<Autoevaluacion> listar(String ref) {
        return list("from Autoevaluacion a left join fetch a.unidadAcademica ua");
    }

    @Override
    public List<Autoevaluacion> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Autoevaluacion buscar(long id) {
        return search(Autoevaluacion.class,id);
    }

    @Override
    public long id() {
        return maxId(Autoevaluacion.class);
    }

    @Override
    public Autoevaluacion buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
