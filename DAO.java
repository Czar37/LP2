/*package com.sistema.DAO;

import java.util.List;
public interface DAO<T> {
    void save(T t);
    void delete(int id);
    List<T> findAll();
}*/

package com.sistema.DAO;

import com.sistema.Exception.DAOException;

import java.util.List;

public abstract class DAO<T> {
    int idCounter = 0;

    void save(T t){}

    abstract void delete(int id) throws DAOException;
    abstract List<T> findAll();


}

