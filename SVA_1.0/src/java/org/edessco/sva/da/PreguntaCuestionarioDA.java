/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.PreguntaCuestionario;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("preguntaCuestionarioDA")
public class PreguntaCuestionarioDA extends AbstractDA<PreguntaCuestionario>{
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
        return list(PreguntaCuestionario.class);
    }

    @Override
    public List<PreguntaCuestionario> listar(String ref) {
        return list("from PreguntaCuestionario pc left join fetch pc.estandar");
    }

    @Override
    public List<PreguntaCuestionario> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public PreguntaCuestionario buscar(long id) {
        return search(PreguntaCuestionario.class,id);
    }

    @Override
    public long id() {
        return maxId(PreguntaCuestionario.class);
    }

    @Override
    public PreguntaCuestionario buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
