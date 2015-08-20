package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Usuario;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("usuarioDA")
public class UsuarioDA extends AbstractDA<Usuario> {

    @Override
    public long registrar(Usuario bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Usuario bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Usuario bean) {
        return delete(bean);
    }

    @Override
    public List<Usuario> listar() {
        return list(Usuario.class);
    }

    @Override
    public List<Usuario> listar(String ref) {
        return list("from Usuario u left join fetch u.persona p left join fetch p.unidadAcademica ua");
    }

    @Override
    public Usuario buscar(long id) {
        return search(Usuario.class, id);
    }

    @Override
    public long id() {
        return Long.parseLong(searchSQL("SELECT max(idusuario) FROM usuario").toString());
    }

    @Override
    public List<Usuario> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscar(String ref) {
        return search("from Usuario as u where u.nombreUsuario='"+ref+"'");
    }

    public List<Usuario> listarAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
