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
        Incialmente deve ser feito um drop no banco para realizar todos os testes
    */
    
    //Teste de usuário válido, se já existir, falha...
    @Test
    public void verificarUsuarioValido() {
        assertTrue(ControllerUsuario.createUsuario("UsuarioTeste@teste.com", "12346578"));
    }

    //Testes inválidos referentes as verificações feitas no ControllerUsuario
    @Test
    public void verificarUsuarioInvalidoEmail() {
        assertTrue(ControllerUsuario.createUsuario("testeemail", "12345678"));
    }

    @Test
    public void verificarUsuarioInvalidoSenha() {
        assertTrue(ControllerUsuario.createUsuario("testesenha@hotmail.com", "1234567"));
    }

    @Test
    public void verificarUsuarioInvalidoEmailSenha() {
        assertTrue(ControllerUsuario.createUsuario("testeemailsenha", "1234567"));
    }

    //Testes referentes a campos nulos
    @Test
    public void verificarEmailNulo() {
        assertTrue(ControllerUsuario.createUsuario(null, "12345678"));
    }


    @Test
    public void verificarSenhaNulo() {
        assertTrue(ControllerUsuario.createUsuario("teste@hotmail.com", null));
    }

    @Test
    public void verificarEmailSenhaNulo() {
        assertTrue(ControllerUsuario.createUsuario(null, null));
    }

    //Testes referentes a campos brancos
    @Test
    public void verificarEspacoBrancoEmail() {
        assertTrue(ControllerUsuario.createUsuario("","12345678"));
    }

    @Test
    public void verificarEspacoBrancoSenha() {
        assertTrue(ControllerUsuario.createUsuario("teste@hotmail.com",""));
    }

    @Test
    public void verificarEspacoBrancoEmailSenha() {
        assertTrue(ControllerUsuario.createUsuario("",""));
    }
    
    /*
    *
    * Testes para verificar senha: acima e abaixo do limite
    */    
    @Test
    public void verificarSenhaAcimaDoLimite() {
        assertTrue(ControllerUsuario.createUsuario("senhamaior@hotmail.com","123456789123456789123"));
    }
    
    @Test
    public void verificarSenhaAbaixoDoLimite() {
        assertTrue(ControllerUsuario.createUsuario("senhamenor@hotmail.com","1234567"));
    }
    
    /*
    *
    * Testes para verificar login: acima e abaixo do limite
    */   
    @Test
    public void verificarLoginAcimaDoLimite() {
        assertTrue(ControllerUsuario.createUsuario("testeloginmaior@hotmail.com","123456789"));
    }
    
    @Test
    public void verificarLoginAbaixoDoLimite() {
        assertTrue(ControllerUsuario.createUsuario("","123456789"));
    }
}
