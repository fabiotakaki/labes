/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Definicao;
import com.mycompany.model.Experimento;
import com.mycompany.model.Usuario;
import com.mycompany.persistences.ExperimentoPersistence;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Rogerio
 */
public class ControllerExperimento {
    
    private ControllerExperimento(){
    }

    public static Experimento createExperimento(String nome, String descricao, Calendar dataInicial, boolean isReplicavel, Usuario usuario) {
        /*Atributos atuais de um experimento: Nome, Descricao, Concluido, Replicado*/
        Experimento novoExperimento = new Experimento(nome, descricao, false, dataInicial, isReplicavel, usuario); // Ver questão do usuario
        return novoExperimento.saveOnDatabase();
    }
    
    
    public static boolean createDefinicao(Experimento experimento, String objEstudo, 
            String objetivo, String perspectiva, String focoQualidade, String contexto, boolean editavel) {

        if (experimento != null && objEstudo != null && objetivo != null 
                && perspectiva != null && focoQualidade != null && contexto != null) {
            
            Definicao novaDefinicao = new Definicao(experimento, objEstudo, objetivo, 
                    perspectiva, focoQualidade, contexto, editavel, editavel);
            return novaDefinicao.saveOnDatabase();
        }

        return false;
    }

    public static List<Experimento> listarExperimentos(Integer idUsuario) {
        return ExperimentoPersistence.listarExperimentos(idUsuario);
    }
    
    public static Experimento buscaExperimento(Integer idExperimento){
        return Experimento.buscaExperimento(idExperimento);
    }

}
