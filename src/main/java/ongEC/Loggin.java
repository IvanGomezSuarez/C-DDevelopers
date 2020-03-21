package ongEC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

	private String usuario;
	private String pass;
	
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
	public Loggin(String nombreUsuario, String password, String usuario, String pass) throws JAXBException {
		super(nombreUsuario, password);
		this.usuario = usuario;
		this.pass = pass;
	}
	
	

	// metodos
	
	public void loggin() throws IOException, JAXBException {
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String respuestaNombre;
		String respuestaPass;
    	System.out.println("\n***************************");
    	System.out.println(" LOGGIN");
    	System.out.println("***************************");
    	
        System.out.println("Introduce tu nombre de usuario:");
        respuestaNombre = br.readLine();
        System.out.println("Introduce tu nombre contraseña");
        respuestaPass = br.readLine();
        		  
        		  
        if (nuevaRespuesta.equalsIgnoreCase("s")) {
        	iniciaSesion();
      	}
        		  
	}
	
	
	
	
	
	
	
}











