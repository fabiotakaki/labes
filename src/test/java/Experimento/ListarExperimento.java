/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experimento;

import com.mycompany.controller.ControllerExperimento;
import com.mycompany.controller.ControllerUsuario;
import com.mycompany.model.Experimento;
import com.mycompany.model.Usuario;
import java.util.Calendar;
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
      
    Usuario usuario;
    Calendar calendario;
    Experimento experimento;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    //Caso o banco esteja vazio, cria usuario de teste com 2 experimentos testes
    @Before
    public void setUp() {
        calendario = Calendar.getInstance();
        usuario = ControllerUsuario.buscaUsuario(1);
        
        if(ControllerUsuario.buscaUsuario(1) == null){
           usuario = new Usuario("UsuarioTeste@teste.com","123456789");
           usuario.saveOnDatabase();
        }
        
        if(ControllerExperimento.listarExperimentos(1).size() == 0){
            Experimento experimento1 = new Experimento("Testeum", "Testeum", false, calendario, false, usuario);
            experimento1.saveOnDatabase();
            Experimento experimento2 = new Experimento("Testedois", "Testedois", false, calendario, false, usuario);
            experimento2.saveOnDatabase();
        }    
        else if(ControllerExperimento.listarExperimentos(1).size() == 1){
            Experimento experimento2 = new Experimento("Testedois", "Testedois", false, calendario, false, usuario);
            experimento2.saveOnDatabase();
        }
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
