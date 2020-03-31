package ongEC;

/*
 * esta clase contiene la informaci�n de los datos de fechas de los colaboradores
 * 
 * 
 * */

import java.sql.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBException;
import ongEC.Miembro;

/**
 *  esta clase contiene la informaci�n de los datos de fechas de los colaboradores
 *
 * @version 1
 * Yosu, Ivan
 */

public class Colaborador extends Miembro {

	// ATRIBUTOS
	
	private Date fechaAlta;
	private Date fechaBaja;
	
	
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
	
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
}
