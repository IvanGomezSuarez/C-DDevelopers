package DAO.impl;

import java.io.IOException;

import ongEC.*;

/** Aqui declaramos todos los metodos que nuestros objetos MIEMBRO DAO deberan soportar
 *  En nuestro caso nos limitamos a declarar los topicos metodos CRUD.

 */
public interface IMiembroDAO {

    void createMiembroDAO(Miembros miembrosNuevos) throws IOException;
    Miembro readMiembroDAO();
    boolean updateMiembroDAO(Miembro pMiembro);
    boolean deleteMiembroDAO(Miembro pMiembro);
}
