package DAO.hibernate.interfaces;

import java.util.List;

public interface IBaseDao<T> {
    T merge(T t);
    void persist(T t);
    void remove(T t);
    List<T> getAll(); 
}
