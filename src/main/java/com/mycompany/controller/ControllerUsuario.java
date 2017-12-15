/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Usuario;

/**
 *
 * @author sidious
 */
public class ControllerUsuario {

    Usuario usuario = null;

    public static boolean createUsuario(String email, String senha) {
        Usuario novoUsuario = new Usuario(email, senha);
        return novoUsuario.saveOnDatabase();
    }

}
