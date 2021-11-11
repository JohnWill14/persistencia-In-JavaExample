
package br.com.locadora.dao;

import br.com.locadora.repository.Dao;
import br.com.locadora.util.JpaUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract  class DaoGeneric<T, L> implements Dao<T, L>{

   private final Class<T> persistentClass;

    public DaoGeneric() {
        this.persistentClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    @Override
    public void add(T object) {
        EntityManager em= null;
        
        try{
        em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            JpaUtil.fechaConexao(em);
        }
    }

    @Override
    public void replace(T object) {
        EntityManager em= null;
        
        try{
        em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            JpaUtil.fechaConexao(em);
        }
    }

    @Override
    public List<T> findAll() {
      EntityManager em= null;
      List<T> objetos;
      
      try{
        em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("Select o from "+persistentClass.getSimpleName()+" o");
        objetos = query.getResultList();
        em.getTransaction().commit();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            JpaUtil.fechaConexao(em);
        }
      
      return objetos;
    }

    @Override
    public T findById(L id) {
     EntityManager em= null;
      T objeto;
      
      try{
        em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        objeto = em.find(persistentClass, id);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            JpaUtil.fechaConexao(em);
        }
      
      return objeto;
    }

    @Override
    public void deleta(L id) {
     EntityManager em= null;
      
      try{
        em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        T objeto = em.find(persistentClass, id);
        em.remove(objeto);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            JpaUtil.fechaConexao(em);
        }
      
    }

}
