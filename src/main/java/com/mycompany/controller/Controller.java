package com.mycompany.controller;
import com.mycompany.model.Definicao;
import com.mycompany.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Controller {

	public void cadastrarPessoa(String senha , String nome) {

		Usuario usuario  = new Usuario();
                usuario.setNomeUsuario(nome);
                usuario.setSenha(senha);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}

	public Usuario selectUser(String usuario){
		Usuario usuario  = new Usuario();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();

		Query query = em
        .createQuery("select u from Usuario as u "+
          "where u.userName = :usuario");
	    query.setParameter("usuario", usuario);

	    List<Usuario> lista = query.getResultList();

		em.close();

		return lista.get(0);

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
