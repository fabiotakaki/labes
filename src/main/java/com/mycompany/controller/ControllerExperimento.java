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
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rogerio
 */
public class ControllerExperimento {

    private static final Logger LOGGER = Logger.getLogger(ControllerExperimento.class.getName());

    private static final String NOME_PATTERN = "([a-z]|[A-Z]|[0-9])([a-z]|[A-Z]|[0-9]|[\\s])*";
    private static final String DESCRICAO_PATTERN = "([a-z]|[A-Z]|[0-9])([a-z]|[A-Z]|[0-9]|[\\s])*";
    private static final Pattern patternNome = Pattern.compile(NOME_PATTERN);
    private static final Pattern patternDescricao = Pattern.compile(DESCRICAO_PATTERN);
    private static final String exDefinicao = "([a-z]|[A-Z]|[0-9])([a-z]|[A-Z]|[0-9]|[\\s])*";
    // Mesma regra aplicada para todas as strings
    private static final Pattern padraoDefinicao = Pattern.compile(exDefinicao);

    private ControllerExperimento() {
    }

    public static Experimento createExperimento(String nome, String descricao, Calendar dataInicial, boolean isReplicavel, Usuario usuario) {
        /*Atributos atuais de um experimento: Nome, Descricao, Concluido, Replicado*/

        if (nome != null && descricao != null && dataInicial != null
                && usuario != null) {

            if (nome.length() > 30) {
                return null;
            }
            if (descricao.length() > 200) {
                return null;
            }
            //
            Matcher m1 = patternNome.matcher(nome);
            if (!m1.matches()) {
                return null;
            }

            Matcher m2 = patternNome.matcher(descricao);
            if (!m2.matches()) {
                return null;
            }

            Experimento novoExperimento = new Experimento(nome, descricao, false, dataInicial, isReplicavel, usuario); // Ver questão do usuario
            return novoExperimento.saveOnDatabase();
        }

        return null;

    }

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

        Definicao novaDefinicao = new Definicao(experimento, objEstudo, objetivo,
                perspectiva, focoQualidade, contexto, editavel, editavel);
        return novaDefinicao.saveOnDatabase();
    }

    public static List<Experimento> listarExperimentos(Integer idUsuario) {
        return ExperimentoPersistence.listarExperimentos(idUsuario);
    }

    public static Experimento buscaExperimento(Integer idExperimento) {
        return Experimento.buscaExperimento(idExperimento);
    }

    public static Definicao buscaDefinicao(Integer idExperimento) {
        return null;//Definicao.buscaDefinicao(idExperimento);
    }

}
