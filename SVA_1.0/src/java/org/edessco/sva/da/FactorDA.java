/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Factor;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("factorDA")
public class FactorDA extends AbstractDA<Factor>{
    @Override
    public long registrar(Factor bean) {
         return save(bean);
    }

    @Override
    public long actualizar(Factor bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Factor bean) {
        return delete(bean);
    }

    @Override
    public List<Factor> listar() {
        return list(Factor.class);
    }

    @Override
    public List<Factor> listar(String ref) {
        return list("from Factor f left join fetch f.dimension");
    }

    @Override
    public List<Factor> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Factor buscar(long id) {
        return search(Factor.class,id);
    }

    @Override
    public long id() {
        return maxId(Factor.class);
    }

    @Override
    public Factor buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Factor> listarFactor(long id) {
        return list("from Factor f inner join fetch f.dimension d where d.iddimension=" + id);
    }
}
