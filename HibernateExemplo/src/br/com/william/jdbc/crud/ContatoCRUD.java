
package br.com.william.jdbc.crud;

import br.com.william.jdbc.model.Contato;
import br.com.william.jdbc.util.HibernateUtil;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ContatoCRUD {
    
    
    
    
    public void save(Contato contato){
        EntityManager em = HibernateUtil.getEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(contato);
            em.getTransaction().commit();
            HibernateUtil.fechaEntityManager(em);
        }catch(Exception e){
            System.out.println("ERRO ao inserir - "+e.getMessage());
        }
    }
    
    public void replace(Contato contato){
        EntityManager em = HibernateUtil.getEntityManager();
        
        try{
            em.getTransaction().begin();
            em.merge(contato);
            em.getTransaction().commit();
            HibernateUtil.fechaEntityManager(em);
        }catch(Exception e){
            System.out.println("ERRO ao atualizar - "+e.getMessage());
        }
    }
    
    public void delete(Contato contato){
        EntityManager em = HibernateUtil.getEntityManager();
        
        try{
            em.getTransaction().begin();
            Contato contatoFromBank = em.find(Contato.class, contato.getCodigo());
            em.remove(contatoFromBank);
            em.getTransaction().commit();
            HibernateUtil.fechaEntityManager(em);
        }catch(Exception e){
            System.out.println("ERRO ao deletar - "+e.getMessage());
        }
    }
    
     public Contato findByName(String name){
           List<Contato> contatos =getAll();
         
         return contatos.stream()
                 .filter(c -> c.getNome().equals(name))
                 .findFirst()
                 .orElse(null);
     }
    
     public List<Contato> getAll(){
        EntityManager em = HibernateUtil.getEntityManager();
        List<Contato> contatos = null;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT c from Contato c", Contato.class);
            contatos = query.getResultList();
            em.getTransaction().commit();
            HibernateUtil.fechaEntityManager(em);
        }catch(Exception e){
            System.out.println("ERRO ao listar - "+e.getMessage());
        }finally{
            return contatos;
        }
    }
     
    public static void main(String[] args) {
        ContatoCRUD cRUD = new ContatoCRUD();
        
        Contato c1 = new Contato();
        
        c1.setNome("JOHN WILLIAM");
        c1.setEmail("johnwill.v.2017@gmail.com");
        c1.setTelefone("(73) 6727-2372");
        c1.setObservacao("hdfhdfdf");
        c1.setDataCadastro(new Date(2021, 10, 25));
        
         
        Contato c2 = new Contato();
        
        c2.setNome("YUYU");
        c2.setEmail("yuyu@gmail.com");
        c2.setTelefone("(77) 4554-2343");
        c2.setObservacao("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        c2.setDataCadastro(new Date(2021, 10, 25));
        
        cRUD.save(c1);
        cRUD.save(c2);
        
        System.out.println(cRUD.getAll());
        
        HibernateUtil.fechaEntityManager(HibernateUtil.getEntityManager());
        
    }
    
    
}
