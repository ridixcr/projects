/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Cuestionario;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("cuestionarioDA")
public class CuestionarioDA extends AbstractDA<Cuestionario>{
    
    @Override
    public long registrar(Cuestionario bean) {
         return save(bean);
    }

    @Override
    public long actualizar(Cuestionario bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Cuestionario bean) {
        return delete(bean);
    }

    @Override
    public List<Cuestionario> listar() {
        return list(Cuestionario.class);
    }

    @Override
    public List<Cuestionario> listar(String ref) {
        return list("from Dimension d left join fetch d.modeloCalidad");
    }

    @Override
    public List<Cuestionario> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Cuestionario buscar(long id) {
        return search(Cuestionario.class,id);
    }

    @Override
    public long id() {
        return maxId(Cuestionario.class);
    }

    @Override
    public Cuestionario buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
