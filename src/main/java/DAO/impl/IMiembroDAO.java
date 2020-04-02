package DAO.impl;


import DAO.impl.*;
import ongEC.*;

@SuppressWarnings("unused")
public interface IMiembroDAO {
    void createMiembroDAO(Miembro pMiembro);
    Miembro readMiembroDAO();
    boolean updateMiembroDAO(Miembro pMiembro);
    boolean deleteMiembroDAO(Miembro pMiembro);
}
