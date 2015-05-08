/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Criterio;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("criterioDA")
public class CriterioDA extends AbstractDA<Criterio>{
    @Override
    public long registrar(Criterio bean) {
         return save(bean);
    }

    @Override
    public long actualizar(Criterio bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Criterio bean) {
        return delete(bean);
    }

    @Override
    public List<Criterio> listar() {
        return list(Criterio.class);
    }

    @Override
    public List<Criterio> listar(String ref) {
        return list("from Criterio d left join fetch d.factor");
    }

    @Override
    public List<Criterio> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Criterio buscar(long id) {
        return search(Criterio.class,id);
    }

    @Override
    public long id() {
        return maxId(Criterio.class);
    }

    @Override
    public Criterio buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Criterio> listarCriterio(long id) {
        System.out.println("id factor"+id);
        return list("from Criterio c inner join fetch c.factor f where f.idfactor=" + id);
    }
}
