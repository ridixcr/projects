/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Facultad;
import org.edessco.sva.be.UnidadAcademica;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("unidadAcademicaDA")
public class UnidadAcademicaDA extends AbstractDA<UnidadAcademica>{

    @Override
    public long registrar(UnidadAcademica bean) {
        return save(bean);
    }

    @Override
    public long actualizar(UnidadAcademica bean) {
        return update(bean);
    }

    @Override
    public long eliminar(UnidadAcademica bean) {
        return delete(bean);
    }

    @Override
    public List<UnidadAcademica> listar() {
        return list(UnidadAcademica.class);
    }

    @Override
    public List<UnidadAcademica> listar(String ref) {
        return list("from UnidadAcademica ua left join fetch ua.facultad");
    }
    
    public List<UnidadAcademica> listarFacultad(long idFacultad){
        return list("from UnidadAcademica ua inner join fetch ua.facultad f where f.idfacultad="+idFacultad);
    }

    @Override
    public List<UnidadAcademica> listar(long id) {
        return list(UnidadAcademica.class, Facultad.class, id);
    }

    @Override
    public UnidadAcademica buscar(long id) {
        return search("from UnidadAcademica ua where ua.idunidadacademica="+id);
    }

    @Override
    public long id() {
        return maxId(UnidadAcademica.class);
    }

    @Override
    public UnidadAcademica buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
