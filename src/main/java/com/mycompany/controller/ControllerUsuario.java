/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Usuario;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sidious
 */
public class ControllerUsuario {
    private static final Logger LOGGER = Logger.getLogger(ControllerUsuario.class.getName());

    private static Usuario usuario = null;
    private static final String exEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                              + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern padraoEmail = Pattern.compile(exEmail, Pattern.CASE_INSENSITIVE);

    private static final String exSenha = "^(?U)[^\\W_]*$";
    private static final Pattern padraoSenha = Pattern.compile(exSenha);

    private ControllerUsuario() {
    }

    public static boolean createUsuario(String email, String senha) {
        Matcher matcherEmail = padraoEmail.matcher(email);
        Matcher matcherSenha = padraoSenha.matcher(senha);

        if(email == null || senha == null){
            return false;
        }
        else if((email.length() > 25 || email.length() <=0)
                || (senha.length() > 20 || senha.length() < 8)){
            return false;
        }
        else if(!matcherEmail.matches() || !matcherSenha.matches()){
            return false;
        }

        Usuario novoUsuario = new Usuario(email, senha);
        return novoUsuario.saveOnDatabase();
    }

    public static Usuario login(String email, String senha) {
        Matcher matcherEmail = padraoEmail.matcher(email);
        Matcher matcherSenha = padraoSenha.matcher(senha);

        if(email == null || senha == null){
            return null;
        }
        else if((email.length() > 25 || email.length() < 0)
                || (senha.length() > 20 || senha.length() < 8)){
            return null;
        }
        else if(!matcherEmail.matches() || !matcherSenha.matches()){
            return null;
        }

        usuario = Usuario.login(email, senha);
        return usuario;
    }

    public static Usuario buscaUsuario(Integer idUsuario){
        if(idUsuario == null || idUsuario < 0){
            return null;
        }

        return Usuario.buscaUsuario(idUsuario);
    }

    public static Usuario buscaUsuarioEmail(String email){
        Matcher matcherEmail = padraoEmail.matcher(email);

        if(email == null || (email.length() > 25 || email.length() <=0) || !matcherEmail.matches()){
            return null;
        }

        return Usuario.buscaUsuarioEmail(email);
    }

}
