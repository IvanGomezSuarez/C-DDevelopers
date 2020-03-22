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


	/**
	 * Constructor que crea un nuevo objeto Loggin sin inicializar sus campos.
	 *
	 * @throws JAXBException si se produce una excepci�n de tipo JAXB.
	 */


	public Colaborador(int idMiembro,Date fechaAlta, Date fechaBaja) throws JAXBException {
		super(idMiembro, fechaAlta, fechaBaja);
	}




}
