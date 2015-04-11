/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Estandar;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("estandarDA")
public class EstandarDA extends AbstractDA<Estandar>{
    
    @Override
    public long registrar(Estandar bean) {
         return save(bean);
    }

    @Override
    public long actualizar(Estandar bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Estandar bean) {
        return delete(bean);
    }

    @Override
    public List<Estandar> listar() {
        return list(Estandar.class);
    }

    @Override
    public List<Estandar> listar(String ref) {
        return list("from Estandar e left join fetch e.criterio");
    }

    @Override
    public List<Estandar> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Estandar buscar(long id) {
        return search(Estandar.class,id);
    }

    @Override
    public long id() {
        return maxId(Estandar.class);
    }

    @Override
    public Estandar buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
