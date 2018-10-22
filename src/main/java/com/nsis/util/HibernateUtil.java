package com.nsis.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

   private static final SessionFactory sessionFactory;

   static {
       try {
           // Crée la SessionFactory en chargeant automatiquement le fichier hibernate.cfg.xml
           sessionFactory = new Configuration().configure().buildSessionFactory();
       } catch (HibernateException ex) {
           throw new RuntimeException("Problème de configuration : " + ex.getMessage(), ex);
       }
   }

   public static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
/**
 * Ouvre une nouvelle Session
 * @return la session courrante
 * @throws HibernateException
 */
   public static Session currentSession() throws HibernateException {
        Session s = (Session) threadLocal.get();
       
       // Ouvre une nouvelle Session, si ce Thread n'en a aucune
       if (s == null) {
            s = sessionFactory.openSession();
            threadLocal.set(s);
       }
       return s;
   }

  
   
   /**
    * Ferme la session courrante
    * @throws HibernateException
    */
   public static void closeSession() throws HibernateException {
     Session session = threadLocal.get();
     threadLocal.set(null);

     if (session != null) {
     try {
     session.close();
     } finally {
     session = null;
     }

     }
   }
}