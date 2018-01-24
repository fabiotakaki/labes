/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import com.mycompany.controller.ControllerUsuario;
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
    
    Usuario usuario;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        usuario = ControllerUsuario.buscaUsuario(1);
        
        if(usuario == null){
           usuario = new Usuario("UsuarioTeste@teste.com","12346578");
           usuario.saveOnDatabase();
        }
    }
    
    @After
    public void tearDown() {
    }

    //Testar logar um usuário nulo
    @Test
    public void logarUsuarioVazio() {
       assertNotNull(ControllerUsuario.login(null, null)); 
    }
    
    //Testar logar usuario com espaços em branco
    @Test
    public void logarUsuarioEspacoBranco() {
        
       assertNotNull(ControllerUsuario.login("", ""));
    }
    
    //Testar um usuário inexistente
    @Test
    public void logarUsuarioInexistente() {
        
       assertNotNull(ControllerUsuario.login("Rogerio.garcia@fct.com.br","labes"));
    }
    
    //Testar um suário existente
    @Test
    public void logarUsuarioExistente() {
        
       assertNotNull(ControllerUsuario.login("UsuarioTeste@teste.com","12346578"));
    }
}
