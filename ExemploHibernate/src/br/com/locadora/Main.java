
package br.com.locadora;

import br.com.locadora.dao.CategoriaDaoImpl;
import br.com.locadora.model.Categoria;
import br.com.locadora.repository.CategoriaDao;
import br.com.locadora.util.JpaUtil;
import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        CategoriaDao dao = new CategoriaDaoImpl();
        
        Categoria c = new Categoria(null, "ola");
        
        dao.add(c);

        System.out.println(dao.findAll());
    }
}
