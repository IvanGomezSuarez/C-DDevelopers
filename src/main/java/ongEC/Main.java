package ongEC;

import DAO.*;
import DAO.impl.DelegacionDAO;
import DAO.impl.MiembroDAO;
import DAO.impl.MySqlMiembroDAO;
import DAO.impl.ProyectoDAO;
import DAO.impl.DAOFactory;
import sql.UtilitySql;
import ongEC.Miembro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import ongEC.Loggin;

/*
 * esta clase es la funcion principal que nos permitira navegar por el menu para realizar las opciones necesarias
 *
 *
 * */
public class Main {
	public static void main() throws IOException, JAXBException, SQLException{

		DAOFactory objetoFactory = DAOFactory.getDAOFactory(DAOFactory.XML);

		MySqlMiembroDAO.incializarXMLdesdeSQL();
		//MySqlMiembroDAOYosu.consultarIdGenerado();
		UtilitySql.generarIdDireccion();
		Miembro miembroNuevo= new Miembro();
		Miembros miembrosNuevos=new Miembros();
		miembrosNuevos=MiembroDAO.readfirst();

		//Comprobamos con una unica clase (para no tener que estar repitiendo codigo) que el caracter es entero

		miembroNuevo=MiembroDAO.addMiembro(miembrosNuevos);
		miembrosNuevos.add(miembroNuevo);
		MiembroDAO.save(miembrosNuevos);
		DAOFactory.getDAOFactory(DAOFactory.MYSQL).getMiembroDAO().createMiembroDAO(miembrosNuevos);
		Loggin.pulsaIntroParaContinuar();
							
					
		objetoFactory.getMiembroDAO().createMiembroDAO(miembrosNuevos);
	}
}


