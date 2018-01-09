/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import com.mycompany.model.Usuario;
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
public class LogarUsuario {
    
    public LogarUsuario() {
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

    //Usuário em braco já existente
    @Test
    public void logarUsuarioVazio() {
        
       assertNotNull(Usuario.login("", "")); 
    }
    
    //Usuário em braco já existente
    @Test
    public void logarUsuarioEspacoBranco() {
        
       assertNotNull(Usuario.login(" ", " "));
    }
    
    @Test
    public void logarUsuarioInexistente() {
        
       assertNotNull(Usuario.login("Rogerio.garcia@fct.com.br","labes"));
    }
}
