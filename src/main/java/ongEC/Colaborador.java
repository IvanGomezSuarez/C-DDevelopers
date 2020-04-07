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

public class Colaborador{

	// ATRIBUTOS
	int idColaborador;
	private Date fechaAlta;
	private Date fechaBaja;
	
	
	//Definicion de los constructores
	
	public Colaborador(int idColaborador, Date fechaAlta, Date fechaBaja) {
		super();
		this.idColaborador = idColaborador;
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

	public int getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}
}
