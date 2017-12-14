package com.mycompany.controller;
import com.mycompany.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Controller {

    public static boolean cadastrarPessoa(String email, String senha) {
        
        boolean commited = false;
        
        Usuario usuario  = new Usuario();
        usuario.setNomeUsuario(email);
        usuario.setSenha(senha);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(usuario);
            em.getTransaction().commit();
            commited = true;
        }catch(Exception e){
            System.out.println("ERRO: ["+ e.getMessage() + "]");
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return commited;
    }
	
}
