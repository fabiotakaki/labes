/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experimento;

import com.mycompany.controller.ControllerExperimento;
import com.mycompany.controller.ControllerUsuario;
import com.mycompany.model.Usuario;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author FELIPE
 */
public class CriarExperimento {
    
    public CriarExperimento() {
    }
    
    Usuario usuario;
    Calendar calendario;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        calendario = Calendar.getInstance();
        usuario = ControllerUsuario.buscaUsuario(1);
        
        if(usuario == null){
           usuario = new Usuario("UsuarioTeste@teste.com","123");
           usuario.saveOnDatabase();
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void verificarEspacoBrancoExperimento() {     
        assertNotNull(ControllerExperimento.createExperimento("", "", calendario, false, usuario)); 
    }
    
    @Test
    public void verificarNomeDescricaoNuloExperimento() {
        assertNotNull(ControllerExperimento.createExperimento(null,null,null,true,null)); 
    }
    
    @Test
    public void verificarNomeNuloExperimento() {
        assertNotNull(ControllerExperimento.createExperimento(null,"descricao",null,true,null)); 
    }
    
    @Test
    public void verificarNomeNaoNuloExperimento() {
        assertNotNull(ControllerExperimento.createExperimento("nome",null,null,true,null)); 
    }
    
    @Test
    public void verificarExperimentoFuncional() {
        assertNotNull(ControllerExperimento.createExperimento("nome", "descricao", calendario, false, usuario)); 
    }
}
