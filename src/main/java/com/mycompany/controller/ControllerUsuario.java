/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sidious
 */
public class ControllerUsuario {
    private static final Logger LOGGER = Logger.getLogger(ControllerUsuario.class.getName());

    private static Usuario usuario = null;

    private ControllerUsuario() {
    }

    public static boolean createUsuario(String email, String senha) {
        Usuario novoUsuario = new Usuario(email, senha);
        return novoUsuario.saveOnDatabase();
    }

    public static Usuario login(String email, String senha) {
        if (email == null || ("").equals(email) || senha == null || ("").equals(senha)) {
            System.out.println("deu ruim");
        }
        usuario = Usuario.login(email, senha);
        return usuario;
    }

    public static Usuario buscaUsuario(Integer idUsuario) {
        if(idUsuario == null || idUsuario <=0){
            LOGGER.log(Level.SEVERE, "ERRO: Usuário inválido");
            return null;
        }
        return Usuario.buscaUsuario(idUsuario);
    }

    public static Usuario buscaUsuarioEmail(String email) {
        if(email == null || ("").equals(email)){
            LOGGER.log(Level.SEVERE, "ERRO: EMAIL inválido");
            return null;
        }
        return Usuario.buscaUsuarioEmail(email);
    }

}
