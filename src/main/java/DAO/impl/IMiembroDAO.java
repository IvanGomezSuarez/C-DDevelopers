package DAO.impl;

import java.io.IOException;
import java.sql.SQLException;

import ongEC.*;

/** Aqui declaramos todos los metodos que nuestros objetos MIEMBRO DAO deberan soportar
 *  En nuestro caso nos limitamos a declarar los topicos metodos CRUD.

 */
public interface IMiembroDAO {

    void createMiembroDAO(Miembros miembrosNuevos) throws IOException;
    Miembro readMiembroDAO();
    void deleteMiembroDAO(Miembro miembro) throws SQLException;
	void updateMiembroDAO(Miembro miembro,int result, int opcioncambiotipomiembro)throws SQLException;
}
