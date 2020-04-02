package DAO.impl;

import DAO.impl.*;
import ongEC.*;

public interface IDelegacionDAO {
    void createOngDAO(ONG pONG);
    ONG readOngDAO();
    boolean updateOngDAO(ONG pONG);
    boolean deleteOngDAO(ONG pONG);
}
