/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Alumno;
import org.edessco.sva.da.AlumnoDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author JorgeLuis
 */
@Service("alumnoBL")
public class AlumnoBL extends AbstractBL<Alumno>{
    @Autowired
    @Qualifier("alumnoDA")
    private AlumnoDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(AlumnoDA) dao;
    }

    @Override
    public long registrar(Alumno bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Alumno bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Alumno bean) {
        return delete(bean);
    }

    @Override
    public List<Alumno> listar() {
        return list();
    }

    @Override
    public List<Alumno> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Alumno> listar(long id) {
        return list(id);
    }

    @Override
    public Alumno buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Alumno buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
