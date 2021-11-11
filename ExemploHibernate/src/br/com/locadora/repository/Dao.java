
package br.com.locadora.repository;

import java.util.List;

public interface Dao<T, L> {
    void add(T object);
    void replace(T object);
    void deleta(L id);
    List<T> findAll();
    T findById(L id);
}
