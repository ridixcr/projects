/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.UnidadAcademica;
import org.edessco.sva.da.UnidadAcademicaDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("unidadAcademicaBL")
public class UnidadAcademicaBL extends AbstractBL<UnidadAcademica>{

    @Autowired
    @Qualifier("unidadAcademicaDA")
    private UnidadAcademicaDA dao;
    
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (UnidadAcademicaDA) dao;
    }

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
        return list();
    }

    @Override
    public List<UnidadAcademica> listar(String ref) {
        return list(ref);
    }
    
    public List<UnidadAcademica> listarFacultad(long idfacultad){
        return dao.listarFacultad(idfacultad);
    }
    
    @Override
    public List<UnidadAcademica> listar(long id) {
        return list(id);
    }

    @Override
    public UnidadAcademica buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public UnidadAcademica buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
