/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

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

    public static List<Experimento> listarExperimentos(Integer idUsuario) {
        return ExperimentoPersistence.listarExperimentos(idUsuario);
    }
    
    public static Experimento buscaExperimento(Integer idExperimento){
        return Experimento.buscaExperimento(idExperimento);
    }

}
