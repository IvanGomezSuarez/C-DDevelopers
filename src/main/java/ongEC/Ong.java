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

import ongEC.Delegacion;



/**
* esta clase permite gestionar contiene la información de la ong, nos permitirá crear delegaciones, así como borrarlas
* tb nos permitirá crear proyectos y dar de alta a miembros
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
	
}
