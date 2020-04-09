package ongEC;

/*
 * esta clase contiene la informaciï¿½n de los datos de fechas de los colaboradores
 * 
 * 
 * */

import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBException;
import ongEC.Miembro;

/**
 *  esta clase contiene la información de los miembros que son colabadores
 *
 * @version 1
 * Yosu, Ivan
 */

public class Colaborador extends Miembro {

	// ATRIBUTOS
	
	private static Date fechaAlta;
	private static Date fechaBaja;
	
	
	//Definicion de los constructores
	
	public Colaborador(Date fechaAlta, Date fechaBaja) {
		super();
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}
	
	public Colaborador() {
		super();
	}

	//Definicion de los gets y los sets
	
	public static Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public static Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
}
