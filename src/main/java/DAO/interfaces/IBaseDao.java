package DAO.interfaces;

import java.util.List;

import javax.xml.bind.JAXBException;

public interface IBaseDao<T> {
    List<T> getAll(); 
    void save(T t) throws JAXBException;
    void update(T t);
    void delete(T t);
}
