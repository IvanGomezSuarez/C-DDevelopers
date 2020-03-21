package ongEC;

import java.sql.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBException;

/**
 * Esta clase representa los ingresos que se consiguen a través de entes publicos
 * herede de la clase Ingreso
 * @version 1
 * Yosu, Ivan
 */

// declaracion de la clase que hereda de ingreso


public class IngresoPublico extends Ingreso {

	int idIngresoPublico;
	GregorianCalendar fechaIngreso;
	
	AdminEstado administracionesEstatales;
	AdminAutonom administracionesAutonomicas;
	AdminLocal administracionesLocales;
	UE unionEuropea;
	
	//CONSTRUCTORES
	
	/**
	 * este constructor crea objeto IngresoPublico  pero NO inicialia los atributos.
	 *  
	 */
	
	public IngresoPublico() throws JAXBException {
		super();
	}	
	
	/**
	 * este constructor crea objeto IngresoPublico e inicialia los atributos.
	 * @param idIngresoPublico
	 * @param fechaIngreso
	 * @param AdminEstado
	 * @param AdminAutonom
	 * @param AdminLocal
	 * @param UE
	 * @param idIngreso
	 * @param fechaRecepcionIngreso
	 *  
	 */
	
	public IngresoPublico(int idIngresoPublico, GregorianCalendar fechaIngreso, AdminEstado administracionesEstatales,
			AdminAutonom administracionesAutonomicas, AdminLocal administracionesLocales, UE unionEuropea, int idIngreso, GregorianCalendar fechaRecepcionIngreso) throws JAXBException {
		super(idIngreso, fechaRecepcionIngreso);
		this.idIngresoPublico = idIngresoPublico;
		this.fechaIngreso = fechaIngreso;
		this.administracionesEstatales = administracionesEstatales;
		this.administracionesAutonomicas = administracionesAutonomicas;
		this.administracionesLocales = administracionesLocales;
		this.unionEuropea = unionEuropea;
	}


	//MÉTODOS
	
	public int getIdIngreso() {
		return idIngresoPublico;
	}

	public void setIdIngreso(int idIngreso) {
		this.idIngresoPublico = idIngreso;
	}

	public GregorianCalendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(GregorianCalendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	
	public AdminEstado getAdministracionesEstatales() {
		return administracionesEstatales;
	}

	public void setAdministracionesEstatales(AdminEstado administracionesEstatales) {
		this.administracionesEstatales = administracionesEstatales;
	}

	public AdminAutonom getAdministracionesAutonomicas() {
		return administracionesAutonomicas;
	}

	public void setAdministracionesAutonomicas(AdminAutonom administracionesAutonomicas) {
		this.administracionesAutonomicas = administracionesAutonomicas;
	}

	public AdminLocal getAdministracionesLocales() {
		return administracionesLocales;
	}

	public void setAdministracionesLocales(AdminLocal administracionesLocales) {
		this.administracionesLocales = administracionesLocales;
	}

	public UE getUnionEuropea() {
		return unionEuropea;
	}

	public void setUnionEuropea(UE unionEuropea) {
		this.unionEuropea = unionEuropea;
	}
	
	
}
