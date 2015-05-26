/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Alumno;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("alumnoDA")
public class AlumnoDA extends AbstractDA<Alumno> {

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
        return list(Alumno.class);
    }

    @Override
    public List<Alumno> listar(String ref) {
        return list("from Criterio d left join fetch d.factor");
    }

    @Override
    public List<Alumno> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Alumno buscar(long id) {
        return search(Alumno.class, id);
    }

    @Override
    public long id() {
        return maxId(Alumno.class);
    }

    @Override
    public Alumno buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
