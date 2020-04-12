package ongEC;

/*
 * esta clase contiene la informaciï¿½n de los datos de fechas de los colaboradores
 * 
 * 
 * */

import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;

import ongEC.Miembro;

/**
 *  esta clase contiene la información de los miembros que son colabadores
 *
 * @version 1
 * Yosu, Ivan
 */

public class Colaborador{

	// ATRIBUTOS
	int idColaborador;
	@XmlElement(name = "fechaAltaCol")
	private static Date fechaAlta;
	@XmlElement(name = "fechaBajaCol")
	private static Date fechaBaja;

	//Definicion de los constructores
	

	public Colaborador(Date fechaAlta, Date fechaBaja, String origen, String paisOrigen) {

		super();
		this.idColaborador = idColaborador;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		
		
	}
	public Colaborador() {
		super();
	}

	//Definicion de los gets y los sets

	public int getIdColaborador() {
		return idColaborador;
	}
	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}
	public static Date getFechaAlta() {
		return fechaAlta;
	}
	public static void setFechaAlta(Date fechaAlta) {
		Colaborador.fechaAlta = fechaAlta;
	}
	public static Date getFechaBaja() {
		return fechaBaja;
	}
	public static void setFechaBaja(Date fechaBaja) {
		Colaborador.fechaBaja = fechaBaja;
	}
}
