package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Rol;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("rolDA")
public class RolDA extends AbstractDA<Rol>{

    @Override
    public long registrar(Rol bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Rol bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Rol bean) {
        return delete(bean);
    }

    @Override
    public List<Rol> listar() {
        return list(Rol.class);
    }

    @Override
    public List<Rol> listar(String ref) {
        return list("");
    }

    @Override
    public List<Rol> listar(long id) {
        return list(Rol.class, Rol.class, id);
    }

    @Override
    public Rol buscar(long id) {
        return search(Rol.class, id);
    }

    @Override
    public long id() {
        return maxId(Rol.class);
    }

    @Override
    public Rol buscar(String ref) {
        int idExterno = Integer.parseInt(ref);
        return search("from Rol as r where r.idrol="+idExterno);
    }
    
}
