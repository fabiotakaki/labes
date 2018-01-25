/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistences;

import com.mycompany.configs.HibernateUtil;
import com.mycompany.model.Experimento;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Rogerio
 */
public class ExperimentoPersistence {

    private static final Logger LOGGER = Logger.getLogger(ExperimentoPersistence.class.getName());

    private ExperimentoPersistence() {
        // default constructor
    }

    public static boolean save(Experimento experimento) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        boolean commited = false;
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.save(experimento);
            t.commit();
            commited = true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "ERRO: [{0}]", e.getMessage());
            if (t != null && !t.wasCommitted()) {
                t.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        return commited;
    }

    public static List<Experimento> listarExperimentos(Integer idUsuario) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Experimento> listaExperimentos = null;
        try {
            Query q = session.createQuery("from Experimento where criador_id= :idUsuario");
            q.setParameter("idUsuario", idUsuario);
            List resultList = q.list();
            listaExperimentos = (List<Experimento>) resultList;
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, "ERRO: [{0}]", e.getMessage());
            throw e;
        } finally {
            session.close();
        }
        return listaExperimentos;
    }
    
    // Busca um exerimento pelo id
    public static Experimento getExperimento(Integer idExperimento){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        Query q = session.createQuery("from Experimento where experimentoID = :idExperimento");
        q.setParameter("idExperimento", idExperimento);
        
        List queryResult = q.list();
        
        if(queryResult.isEmpty())
            return null;
        return (Experimento) queryResult.get(0);
    }
    
    public static boolean update(Experimento experimento) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        boolean commited = false;
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.update(experimento);
            t.commit();
            commited = true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "ERRO: [{0}]", e.getMessage());
            if (t != null && !t.wasCommitted()) {
                t.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        return commited;
    }

}
