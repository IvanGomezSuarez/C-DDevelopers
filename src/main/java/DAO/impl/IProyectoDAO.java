package DAO.impl;


import DAO.impl.*;
import ongEC.*;
public interface IProyectoDAO {
    void createOngDAO(ONG pONG);
    ONG readOngDAO();
    boolean updateOngDAO(ONG pONG);
    boolean deleteOngDAO(ONG pONG);
}
