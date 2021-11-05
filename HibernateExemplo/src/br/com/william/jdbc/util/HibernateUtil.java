
package br.com.william.jdbc.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    
    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public static void fechaEntityManagerFactory( EntityManagerFactory emf){
        if(emf!=null)
            emf.close();
    }
    
    
    public static void fechaEntityManager( EntityManager em){
        if(em!=null)
            em.close();
    }
    
    
}
