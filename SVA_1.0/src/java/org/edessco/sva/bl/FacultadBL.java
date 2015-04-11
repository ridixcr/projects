package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Facultad;
import org.edessco.sva.be.UnidadAcademica;
import org.edessco.sva.da.FacultadDA;
import org.edessco.sva.da.UnidadAcademicaDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("facultadBL")
public class FacultadBL extends AbstractBL<Facultad> {

    @Autowired
    @Qualifier("facultadDA")
    private FacultadDA dao;
    
    @Autowired
    @Qualifier("unidadAcademicaDA")
    private UnidadAcademicaDA daoUA;

    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (FacultadDA) dao;
    }

    @Override
    public long registrar(Facultad bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Facultad bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Facultad bean) {
        return delete(bean);
    }

    @Override
    public List<Facultad> listar() {
        return list();
    }

    @Override
    public List<Facultad> listar(String ref) {
        return list(ref);
    }

    public List<UnidadAcademica> listarFacultad(long idfacultad) {
        return daoUA.listarFacultad(idfacultad);
    }

    @Override
    public List<Facultad> listar(long id) {
        return list(id);
    }

    @Override
    public Facultad buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Facultad buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
