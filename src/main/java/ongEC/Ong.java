package ongEC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

import javax.xml.bind.annotation.*;

import ongEC.Delegaciones;



/**
* esta clase permite gestionar contiene la informaci�n de la ong, nos permitir� crear delegaciones, as� como borrarlas
* tb nos permitir� crear proyectos y dar de alta a miembros
*/
@XmlRootElement(name = "ong")
@XmlAccessorType(XmlAccessType.NONE)

public class Ong {
	@XmlAttribute(name = "nombreOng")
	private String nombreOng;
	
	@XmlAttribute(name = "cifOng")
	private String cifOng;
		
	
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
	 * no implemento los metodos a�adir delegaci�n, borrarla o modificarla por el tema del DAO y DAO factory, que en 
	 * teoria son capas donde no se junta el c�digo estandard con las acciones sobre la base de datos
	 * 
	 */

	// m�todo para dar de alta una delegaci�n
	
	static void addDelegacion() throws IOException, JAXBException {
		Delegaciones newDelegacion = new Delegaciones();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nIntroduce el nombre de la delegaci�n: ");
		newDelegacion.setNomDelegacion(br.readLine());
		System.out.println("\nIntroduce el ID de la delegaci�n: ");
		newDelegacion.setIdDelegacion(br.readLine());
		System.out.println("\nIntroduce el tel�fono de la delegaci�n: ");
		newDelegacion.setTelefono(br.readLine());
		System.out.println("\nIntroduce el CIP de la delegacion: ");
		newDelegacion.setCip(br.readLine());
		
		AltaDelegacion(newDelegacion);
		
	}


	private static void AltaDelegacion(Delegaciones newDelegacion) {
		// TODO Auto-generated method stub
		
	}


	public Object getOngs() {
		// TODO Auto-generated method stub
		return null;
	}


	public static void printDelegaciones() {
		// TODO Auto-generated method stub
		
	}


	public static void delDelegacion() {
		// TODO Auto-generated method stub
		
	}
		
}
