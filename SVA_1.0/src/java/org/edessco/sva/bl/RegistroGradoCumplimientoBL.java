/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.RegistroGradoCumplimiento;
import org.edessco.sva.da.RegistroGradoCumplimientoDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("registroGradoCumplimientoBL")
public class RegistroGradoCumplimientoBL extends AbstractBL<RegistroGradoCumplimiento> {

    @Autowired
    @Qualifier("registroGradoCumplimientoDA")
    private RegistroGradoCumplimientoDA dao;

    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (RegistroGradoCumplimientoDA) dao;
    }

    @Override
    public long registrar(RegistroGradoCumplimiento bean) {
        return save(bean);
    }

    @Override
    public long actualizar(RegistroGradoCumplimiento bean) {
        return update(bean);
    }

    @Override
    public long eliminar(RegistroGradoCumplimiento bean) {
        return delete(bean);
    }

    @Override
    public List<RegistroGradoCumplimiento> listar() {
        return list();
    }
    @Override
    public List listarSQL(){
        return dao.listarSQL();
    }
    public List reporteProcesadoEstandar(){
        return dao.reporteProcesadoEstandar();
    }
    public List reporteProcesadoConsolidadoEstandar(){
        return dao.reporteProcesadoConsolidadoEstandar();
    }

    @Override
    public List<RegistroGradoCumplimiento> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<RegistroGradoCumplimiento> listar(long id) {
        return list(id);
    }

    @Override
    public RegistroGradoCumplimiento buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public RegistroGradoCumplimiento buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
