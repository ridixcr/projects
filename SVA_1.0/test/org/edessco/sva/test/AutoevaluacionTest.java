/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.test;

import java.util.Date;
import org.edessco.sva.be.Autoevaluacion;
import org.edessco.sva.be.ModeloCalidad;
import org.edessco.sva.be.UnidadAcademica;
import org.edessco.sva.bl.AutoevaluacionBL;
import org.edessco.sva.da.AutoevaluacionDA;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JorgeLuis
 */
public class AutoevaluacionTest {
    
    private Autoevaluacion autoevaluacion;
    private UnidadAcademica unidadAcademica;
    private ModeloCalidad modeloCalidad;
    private AutoevaluacionBL bl;
    private AutoevaluacionDA da;
    
    public AutoevaluacionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        autoevaluacion = new Autoevaluacion();
        unidadAcademica = new UnidadAcademica();
        modeloCalidad = new  ModeloCalidad();
        
        unidadAcademica.setIdunidadacademica(Long.parseLong(""+18));
        modeloCalidad.setIdmodelocalidad(Long.parseLong(""+3));
                
        autoevaluacion.setFechaInicio(new Date());
        autoevaluacion.setFechaFin(new Date());
        autoevaluacion.setTitulo("Autoevaluacion 2015");
        autoevaluacion.setModeloCalidad(modeloCalidad);
        autoevaluacion.setUnidadAcademica(unidadAcademica);
        
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void registrar() {
        System.out.println("Registrar");
        bl = new AutoevaluacionBL();
        da = new AutoevaluacionDA();
        System.out.println(""+autoevaluacion.getTitulo());
        System.out.println(""+autoevaluacion.getUnidadAcademica().getIdunidadacademica());
        long resp = da.save(autoevaluacion);
        
        assertEquals(3, resp);
        System.out.println("termino la prueba");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
