/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definicao;

import com.mycompany.controller.ControllerDefinicao;
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
public class CriarDefinicao {
    
    public CriarDefinicao() {
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
    
    @Before
    public void setUp() {
        calendario = Calendar.getInstance();
        usuario = ControllerUsuario.buscaUsuario(1);
        
        if(usuario == null){
           usuario = new Usuario("UsuarioTeste@teste.com","123456789");
           usuario.saveOnDatabase();
        }
        if(ControllerExperimento.listarExperimentos(1) == null){
            experimento = new Experimento("Testeum", "Testeum", false, calendario, false, usuario);
            experimento.saveOnDatabase();         
        }    
        else{
            List<Experimento> experimentos = ControllerExperimento.listarExperimentos(1);
            experimento = experimentos.get(0);
        }
    }
    
    @After
    public void tearDown() {
    }
    
    //Testando todos campos nulos
    @Test
    public void verificarNuloDefinicao() {
       
        assertTrue(ControllerDefinicao.createDefinicao(null,null,null,null,null,null,false)); 
    }
    
    //Definição com campos não nulos e objeto experimento não nulo
    @Test
    public void verificarDefinicaoFuncional() {
        
        assertTrue(ControllerDefinicao.createDefinicao(experimento,"ObjEstudo","Objetivo","Perspectiva","FocoQualidade","Contexto",false)); 
    }
    
    //Testando campo com objeto experimento nulo
    @Test
    public void verificarDefinicaoExperimentoNulo() {
        
        assertTrue(ControllerDefinicao.createDefinicao(null,"objEstudo","objetivo","perspectiva","focoQualidade","contexto",false)); 
    }
    
    //Testando com objeto experimento não nulo, porém os outros campos nulos
    @Test
    public void verificarDefinicaoExperimoNaoNuloCamposNulos() {
        
        assertTrue(ControllerDefinicao.createDefinicao(experimento,null,null,null,null,null,false)); 
    }
}
