/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Encuesta;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("encuestaDA")
public class EncuestaDA extends AbstractDA<Encuesta>{
    
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
        return list(Encuesta.class);
    }

    @Override
    public List<Encuesta> listar(String ref) {
        return list("from Dimension d left join fetch d.modeloCalidad");
    }

    @Override
    public List<Encuesta> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Encuesta buscar(long id) {
        return search(Encuesta.class,id);
    }

    @Override
    public long id() {
        return maxId(Encuesta.class);
    }

    @Override
    public Encuesta buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
