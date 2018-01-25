/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Definicao;
import com.mycompany.model.Experimento;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author paulo
 */
public class ControllerDefinicao {
    private static final String exDefinicao = "([a-z]|[A-Z]|[0-9])([a-z]|[A-Z]|[0-9]|[\\s])*";
    //Mesma regra aplicada para todas as strings
    private static final Pattern padraoDefinicao = Pattern.compile(exDefinicao);
    
    
   public static boolean createDefinicao(Experimento experimento, String objEstudo,
            String objetivo, String perspectiva, String focoQualidade, String contexto, boolean editavel) {
        Matcher matcherObjEstudo = padraoDefinicao.matcher(objEstudo);
        Matcher matcherObjetivo = padraoDefinicao.matcher(objetivo);
        Matcher matcherPerspectiva = padraoDefinicao.matcher(perspectiva);
        Matcher matcherFocoQualidade = padraoDefinicao.matcher(focoQualidade);
        Matcher matcherContexto = padraoDefinicao.matcher(contexto);

        if (experimento == null || objEstudo == null || objetivo == null
                || perspectiva == null || focoQualidade == null || contexto == null) {
            return false;
        } else if ((objEstudo.length() < 0 || objEstudo.length() >= 80) || (objetivo.length() < 0 || objEstudo.length() >= 80)
                || (perspectiva.length() < 0 || perspectiva.length() >= 80) || (focoQualidade.length() < 0 || focoQualidade.length() >= 80)
                || (contexto.length() < 0 || contexto.length() >= 80)) {
            return false;
        } else if (!matcherObjEstudo.matches() || !matcherObjetivo.matches() || !matcherPerspectiva.matches()
                || !matcherFocoQualidade.matches() || !matcherContexto.matches()) {
            return false;
        }
        boolean ret;
        if (experimento.getDefinicao() == null) {
            Definicao novaDefinicao = new Definicao(experimento, objEstudo, objetivo,
                    perspectiva, focoQualidade, contexto, editavel, false);
            experimento.setDefinicao(novaDefinicao);
            ret = novaDefinicao.saveOnDatabase();

        } else {
            experimento.updateDef(objEstudo, objetivo,
                    perspectiva, focoQualidade, contexto, editavel, false);
            ret = experimento.getDefinicao().saveOnDatabase();
        }

        experimento.updateDatabase();
        return ret;
    }

}
