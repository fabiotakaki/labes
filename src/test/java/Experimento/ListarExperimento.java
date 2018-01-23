/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experimento;

import com.mycompany.controller.ControllerExperimento;
import com.mycompany.model.Experimento;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FELIPE
 */
public class ListarExperimento {
    
    public ListarExperimento() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    //Verificar se o número de experimento é o mesmo que foi cadastrado no banco com aquele usúario
    //Usuário teste utilizado, 2 experimentos cadastrados nele...
    @Test
    public void listarNumExperimentosUsuario() {
              
        List<Experimento> experimentos  =  ControllerExperimento.listarExperimentos(1);
    
        assertEquals(2,experimentos.size());
    }
}
