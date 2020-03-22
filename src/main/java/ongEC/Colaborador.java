package ongEC;

// IMPORTS

import java.sql.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBException;
import ongEC.Miembros;

/**
 * Esta clase representa a los colaboradores de la ONG
 *
 * @version 1
 * Yosu, Ivan
 */

public class Colaborador extends Miembros {

	// ATRIBUTOS
	
	Date fechaAlta;
	Date fechaBaja;

	/**
	 * Constructor que crea un nuevo objeto Loggin sin inicializar sus campos.
	 *
	 * @throws JAXBException si se produce una excepci�n de tipo JAXB.
	 */
	
	public Colaborador(String idMiembro, String nombreMiembro, String nombreUsuario, String password, String apellido1,
			String apellido2, String dni, String pais, String ciudad, String direccion, String telefono, Date fechaAlta,
			Date fechaBaja) {
		super(idMiembro, nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, pais, ciudad, direccion,
				telefono);
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}

	public Colaborador(String idMiembro, String nombreMiembro, String nombreUsuario, String password, String apellido1,
			String apellido2, String dni, String pais, String ciudad, String direccion, String telefono) {
		super(idMiembro, nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, pais, ciudad, direccion,
				telefono);
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
