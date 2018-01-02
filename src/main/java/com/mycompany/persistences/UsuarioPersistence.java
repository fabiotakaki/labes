/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistences;

import com.mycompany.configs.HibernateUtil;
import com.mycompany.model.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sidious
 */
public class UsuarioPersistence {

    private static final Logger LOGGER = Logger.getLogger(UsuarioPersistence.class.getName());

    public static boolean save(Usuario usuario) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        boolean commited = false;
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.save(usuario);
            t.commit();
            commited = true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "ERRO: [{0}]", e.getMessage());
            if (t != null && !t.wasCommitted()) {
                t.rollback();
            }
        } finally {
            session.close();
        }
        return commited;
    }

    public static Usuario login(String email, String senha) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Query q = session.createQuery("from Usuario where userName = :email and senha = :senha");
        q.setParameter("email", email);
        q.setParameter("senha", senha);
        List queryResult = q.list();
        //LOGGER.log(Level.INFO, String.valueOf(queryResult));
        session.close();

        //System.out.println(queryResult.size());
        if (queryResult.size() > 1 || queryResult.isEmpty()) {
            return null;
        }
        return (Usuario) queryResult.get(0);
    }
    
    public static Usuario getUsuario(Integer idUsuario){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        Query q = session.createQuery("from Usuario where id = :idUsuario");
        q.setParameter("idUsuario", idUsuario);
        
        List queryResult = q.list();
        
        if(queryResult.isEmpty())
            return null;
        return (Usuario) queryResult.get(0);
    }
}
