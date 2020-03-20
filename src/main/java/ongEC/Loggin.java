package ongEC;

import javax.xml.bind.JAXBException;



/**
 * Esta clase permite hacer el loggin a un miembro, no tiene atributos propios, solo un método que chequea los datos que haya en la clase miembros
 * 
 * @author Ivan.
 * @version 1.0
 *
 */

public class Loggin extends Miembros {


	//atributos

	private String rol;
	
	// constructor
	
	/**
	 * Constructor que crea un nuevo objeto Loggin sin inicializar sus campos.
	 * 
	 * @throws JAXBException si se produce una excepción de tipo JAXB.
	 */
	public Loggin() throws JAXBException {
		super();
	}
	
	
	/**
	 * Constructor que crea un nuevo objeto Admin inicializando sus campos.
	 * 
	 * @param nombreUsuario recoge el nombre de usuario para comprobar luego con la clase padre
	 * @param password recoge el password que ha de coincidir con la del nombreUsuario de la clase padre
	 *
	 */
	public Loggin(String nombreUsuario, String password) throws JAXBException {
		super(nombreUsuario, password);
	}
	
	

	// metodos

	private static void logginCheck () {
			
	}
}
