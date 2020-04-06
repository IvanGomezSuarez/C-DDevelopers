package DAO.impl;

import ongEC.*;

/** Aquí declaramos todos los métodos que nuestros objetos MIEMBRO DAO deberán soportar
 *  En nuestro caso nos limitamos a declarar los típicos métodos CRUD.

 */
public interface IMiembroDAO {

    void createMiembroDAO(Miembro pMiembro);
    Miembro readMiembroDAO();
    boolean updateMiembroDAO(Miembro pMiembro);
    boolean deleteMiembroDAO(Miembro pMiembro);
}
