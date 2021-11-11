
package br.com.locadora.util;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    
    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
    
    public static void fechaConexao(EntityManager em, PreparedStatement ps){
        try{
            if(ps!= null)
                ps.close();
            fechaConexao(em);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public static void fechaConexao(EntityManager em){
        try{
            if(em!= null)
                em.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
}
