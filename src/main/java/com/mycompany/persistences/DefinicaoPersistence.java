/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistences;

import com.mycompany.configs.HibernateUtil;
import com.mycompany.model.Definicao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Gi Benvenuto
 */
public class DefinicaoPersistence {
    private static final Logger LOGGER = Logger.getLogger(DefinicaoPersistence.class.getName());

    public static boolean save(Definicao definicao) {
        LOGGER.log(Level.WARNING, "Scope: Persistence");
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        boolean commited = false;
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.save(definicao);
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
    
    public static Definicao getUsuario(Integer idExperimento){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        Query q = session.createQuery("from Definicao where experimentoID = :idExperimento");
        q.setParameter("idExperimento", idExperimento);
        
        List queryResult = q.list();
        
        if(queryResult.isEmpty())
            return null;
        return (Definicao) queryResult.get(0);
    }

}
