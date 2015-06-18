/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.ComiteInterno;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("comiteInternoDA")
public class ComiteInternoDA extends AbstractDA<ComiteInterno>{
    
    public long registrar(ComiteInterno bean) {
        return save(bean);
    }

    @Override
    public long actualizar(ComiteInterno bean) {
        return update(bean);
    }

    @Override
    public long eliminar(ComiteInterno bean) {
        return delete(bean);
    }

    @Override
    public List<ComiteInterno> listar() {
        return list(ComiteInterno.class);
    }

    @Override
    public List<ComiteInterno> listar(String ref) {
        return list("from ComiteInterno ci left join fetch ci.unidadAcademica");
    }

    @Override
    public List<ComiteInterno> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ComiteInterno buscar(long id) {
        return search(ComiteInterno.class, id);
    }

    @Override
    public long id() {
        return maxId(ComiteInterno.class);
    }

    @Override
    public ComiteInterno buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
