/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.configs;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author sidious
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final Logger LOGGER = Logger.getLogger(HibernateUtil.class.getName());

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            LOGGER.log(Level.SEVERE, "ERRO: [{0}]", ex.getMessage());
            //System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
