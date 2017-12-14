package com.mycompany.controller;
import com.mycompany.model.Definicao;
import com.mycompany.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Controller {

    public static boolean cadastrarUsuario(String email, String senha){

        Usuario usuario  = new Usuario();
        boolean commited = false; 
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
            System.err.println("ERRO: [" + e.getMessage() + "]");
            if(em.getTransaction() != null){
                em.getTransaction().rollback();
            }
        }finally{
            em.close();
        }
        return commited;
    }


    public void salvarDefinicao(String objetivo , String objetoEstudo, String perspectiva, String foco, String contexto) {

        Definicao d  = new Definicao();
        d.setConcluido(false);
        d.setContexto(contexto);
        d.setEditvel(true);
        d.setExperimento(null); //VERIFICAR
        d.setFocoQualidade(foco);
        d.setObjEstudo(objetoEstudo);
        d.setObjetivo(objetivo);
        d.setPerspectiva(perspectiva);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();
    }
}
