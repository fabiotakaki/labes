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

    public static List<Experimento> listarExperimentos() {
       SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        boolean commited = false;
        Transaction t = null;
        List<Experimento> list = null;
        try {
            t = session.beginTransaction();
            Query query = session.createQuery("from Experimento"); //Utiliza HQL (Diferente de SQL, mas ...)
            list = query.list();
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
        if(commited){
            return list;
        }
        return null;
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
        } finally {
            session.close();
        }
        return commited;
    }

}
