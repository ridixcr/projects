package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Dimension;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("dimensionDA")
public class DimensionDA extends AbstractDA<Dimension> {

    @Override
    public long registrar(Dimension bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Dimension bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Dimension bean) {
        return delete(bean);
    }

    public List<Dimension> listarDimension(long id) {
        return list("from Dimension d inner join fetch d.modeloCalidad mc where mc.idmodelocalidad=" + id);
    }

    @Override
    public List<Dimension> listar() {
        return list(Dimension.class);
    }

    @Override
    public List<Dimension> listar(String ref) {
        return list("from Dimension d left join fetch d.modeloCalidad");
    }

    @Override
    public List<Dimension> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Dimension buscar(long id) {
        return search(Dimension.class, id);
    }

    @Override
    public long id() {
        return maxId(Dimension.class);
    }

    @Override
    public Dimension buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
