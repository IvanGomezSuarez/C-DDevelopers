package DAO.impl;

import ongEC.*;

/** Aqui declaramos todos los metodos que nuestros objetos MIEMBRO DAO deberan soportar
 *  En nuestro caso nos limitamos a declarar los topicos metodos CRUD.

 */
public interface IMiembroDAO {

    void createMiembroDAO(Miembro pMiembro);
    Miembro readMiembroDAO();
    boolean updateMiembroDAO(Miembro pMiembro);
    boolean deleteMiembroDAO(Miembro pMiembro);
}