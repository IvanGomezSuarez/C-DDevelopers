package ongEC;


//IMPORTS
import javax.xml.bind.JAXBException;
import java.util.GregorianCalendar;

/**
 * Esta clase representa los ingresos que se consiguen a través de los diversos organismos
 * publico o privados
 * @version 1
 * Ivan
 */

//DECLARACIÓN DE LA CLASE

public class Ingreso {
	
	//ATRIBUTOS
	private int idIngreso;
	private java.util.GregorianCalendar fechaRecepcionIngreso;
	
	
	//CONSTRUCTORES
	
	/**
	 * este constructor crea objeto INGRESO  pero NO inicialia los atributos.
	 * @param idIngreso identifica el ingreso
	 * @param fechaRecepcionIngreso para conocer la fecha en la cual se recibe un ingreso
	 */
	
	public Ingreso() throws JAXBException {
		super();
	}
	

	public Ingreso(int idIngreso, java.util.GregorianCalendar fechaRecepcionIngreso) throws JAXBException{
		
		this.setIdIngreso(idIngreso);
		this.setFechaIngreso(fechaRecepcionIngreso);
	}
	
	
	
	//METODOS

	private void addIngresoPublico() {
}
	
	private void addIngresoPrivado() {
}
	
	
	private void delIngresoPublico() {
}
	
	
	private void delIngresoPrivado() {
}



	public java.util.GregorianCalendar getFechaIngreso() {
		return fechaRecepcionIngreso;
	}



	public void setFechaIngreso(java.util.GregorianCalendar fechaIngreso) {
		this.fechaRecepcionIngreso = fechaIngreso;
	}



	public int getIdIngreso() {
		return idIngreso;
	}



	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}
}
