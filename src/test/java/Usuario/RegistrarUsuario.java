/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import com.mycompany.model.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author FELIPE
 */
public class RegistrarUsuario {
    
    public RegistrarUsuario() {
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
    
    /*
    ESSES TESTES DEVEM SER EXECUTADOS SEPARADAMENTE 
    E PARA CADA TESTE DEVE SER EFETUADO UM DROP NO BANCO DE DADOS 
    */
    
    @Test
    public void verificarEmailNuloModel() {
             
       Usuario usuario = new Usuario("", "123");
       assertTrue(usuario.saveOnDatabase()); //REGISTRA COM EMAIL VAZIO
    }
      
    @Test
    public void verificarSenhaNuloModel() {
             
       Usuario usuario = new Usuario("Felipe", "");
       assertTrue(usuario.saveOnDatabase()); //REGISTRA COM EMAIL NÃO VAZIO E SENHA VAZIA COM UM EMAIL NÃO VALIDO
    }
    
    @Test
    public void verificarEmailSenhaNuloModel() {
             
       Usuario usuario = new Usuario("", "");
       assertTrue(usuario.saveOnDatabase()); //REGISTRA COM CAMPOS EMAIL E SENHA VAZIOS
    }
     
    @Test
    public void verificarEspacoBrancoEmail() {
             
       Usuario usuario = new Usuario(" ", "123");
       assertTrue(usuario.saveOnDatabase()); //REGISTRA COM EMAIL COM ESPAÇO EM BRANCO E SENHA NÂO NULA
    }
    
    @Test
    public void verificarEspacoBrancoSenha() {
             
       Usuario usuario = new Usuario("Felipe@hotmail.com", " ");
       assertTrue(usuario.saveOnDatabase());//REGISTRAR COM EMAIL NÃO NULO E SENHA COM ESPAÇO EM BRANCO COM EMAIL VÁLIDO
    }

    @Test
    public void verificarEspacoBrancoEmailSenha() {
             
       Usuario usuario = new Usuario(" ", " ");
       assertTrue(usuario.saveOnDatabase()); //REGISTRA COM EMAIL E SENHA COM ESPAÇO EM BRANCO
    }
}
