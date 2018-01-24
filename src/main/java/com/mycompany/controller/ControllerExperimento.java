/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Definicao;
import com.mycompany.model.Experimento;
import com.mycompany.model.Usuario;
import com.mycompany.persistences.DefinicaoPersistence;
import com.mycompany.persistences.ExperimentoPersistence;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rogerio
 */
public class ControllerExperimento {

    private static final String NOME_PATTERN = "([a-z]|[A-Z]|[0-9])([a-z]|[A-Z]|[0-9]|[\\s])*";
    private static final String DESCRICAO_PATTERN = "([a-z]|[A-Z]|[0-9])([a-z]|[A-Z]|[0-9]|[\\s])*";
    private static final Pattern patternNome = Pattern.compile(NOME_PATTERN);
    private static final Pattern patternDescricao = Pattern.compile(DESCRICAO_PATTERN);

    private ControllerExperimento(){
    }

    public static Experimento createExperimento(String nome, String descricao, Calendar dataInicial, boolean isReplicavel, Usuario usuario) {
        /*Atributos atuais de um experimento: Nome, Descricao, Concluido, Replicado*/

        if (nome != null && descricao != null && dataInicial != null
                && usuario != null) {

            if (nome.length() > 30) return null;
            if (descricao.length() > 200) return null;
            //
            Matcher m1 = patternNome.matcher(nome);
            if(!m1.matches()){
		return null;
            }

            Matcher m2 = patternNome.matcher(descricao);
            if(!m2.matches()){
		return null;
            }

            Experimento novoExperimento = new Experimento(nome, descricao, false, dataInicial, isReplicavel, usuario); // Ver questão do usuario
            return novoExperimento.saveOnDatabase();
        }

        return null;

    }


    public static boolean createDefinicao(Experimento experimento, String objEstudo,
            String objetivo, String perspectiva, String focoQualidade, String contexto, boolean editavel) {

        LOGGER.log(Level.WARNING, "Scope: Controller");

        if (experimento != null && objEstudo != null && objetivo != null
                && perspectiva != null && focoQualidade != null && contexto != null) {
            LOGGER.log(Level.WARNING, "Scope: if Controller");
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

    public static Definicao buscaDefinicao(Integer idExperimento){
        return null;//Definicao.buscaDefinicao(idExperimento);
    }

}
