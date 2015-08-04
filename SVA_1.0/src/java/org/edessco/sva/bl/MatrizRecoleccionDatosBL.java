package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.*;
import org.edessco.sva.da.*;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("matrizRecoleccionDatosBL")
public class MatrizRecoleccionDatosBL  extends AbstractBL<MatrizRecoleccionDatos>{

    @Autowired
    @Qualifier("matrizRecoleccionDatosDA")
    private MatrizRecoleccionDatosDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(MatrizRecoleccionDatosDA) dao;
    }

    @Override
    public long registrar(MatrizRecoleccionDatos bean) {
        return save(bean);
    }

    @Override
    public long actualizar(MatrizRecoleccionDatos bean) {
        return update(bean);
    }

    @Override
    public long eliminar(MatrizRecoleccionDatos bean) {
        return delete(bean);
    }

    @Override
    public List<MatrizRecoleccionDatos> listar() {
        return list();
    }

    @Override
    public List<MatrizRecoleccionDatos> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<MatrizRecoleccionDatos> listar(long id) {
        return list(id);
    }

    @Override
    public MatrizRecoleccionDatos buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public MatrizRecoleccionDatos buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<MatrizRecoleccionDatos> listarEstandar(long id) {
        return dao.listarEstandar(id);
    }
    
    public List respuestaCuestionarioDocente(long id_estandar){
        return dao.respuestaCuestionarioDocente(id_estandar);
    }
    
}
