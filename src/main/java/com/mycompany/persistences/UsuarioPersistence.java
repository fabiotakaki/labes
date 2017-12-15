/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistences;

import com.mycompany.configs.HibernateUtil;
import com.mycompany.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sidious
 */
public class UsuarioPersistence {

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
            System.out.println("ERRO: " + e.getMessage() + " --- ");
            if (t != null && !t.wasCommitted()) {
                t.rollback();
            }
        } finally {
            session.close();
        }
        return commited;
    }
}
