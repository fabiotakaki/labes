/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Definicao;
import com.mycompany.model.Experimento;

/**
 *
 * @author paulo
 */
public class ControllerDefinicao {

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

}
