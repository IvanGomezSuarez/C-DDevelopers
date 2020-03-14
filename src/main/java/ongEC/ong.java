package ongEC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;


/**
* esta clase permite gestionar contiene la información de la ong, nos permitirá crear delegaciones, así como borrarlas
* tb nos permitirá crear proyectos y dar de alta a miembros
*/


public class Ong {
	private String nombreOng;
	private String cifOng;
	//private direccionOng Direccion;
	
	
	
	// constructor
	
	/**
	 * creacion de nuevo objeto con atributos no inicialiados
	 */
	public Ong() {
		super();
	}
	
	
	/**
	 * este constructor crea objeto e inicialia los atributos.
	 * @param cifOng 
	 */
	public Ong(String nombreOng, String cifOng) {
		super();
		this.nombreOng = nombreOng;
		this.cifOng = cifOng;
	}

	// metodos

	public String getNombreOng() {
		return nombreOng;
	}

	public void setNombreOng(String nombreOng) {
		this.nombreOng = nombreOng;
	}

	public String getCifOng() {
		return cifOng;
	}

	public void setCifOng(String cifOng) {
		this.cifOng = cifOng;
	}
	
	/**
	 * no implemento los metodos añadir delegación, borrarla o modificarla por el tema del DAO y DAO factory, que en 
	 * teoria son capas donde no se junta el código estandard con las acciones sobre la base de datos
	 * 
	 */

	// método para dar de alta una delegación
	
	private void addDelegacion() {
}
	
	// dar de alta un proyecto
	private void addProyecto() {
}
	
	// borrar proyecto
	private void delProyecto() {
}
	
	// borrar delegacion
	private void delDelegacion() {
}
	

}
