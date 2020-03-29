package ongEC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import ongEC.Main;
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

	private static final String ivan = null;
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
/*	
	public static void loggin() throws IOException, JAXBException {
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String respuestaNombre;
		String respuestaPass;
    	System.out.println("\n*******");
    	System.out.println(" LOGGIN");
    	System.out.println("*********");
    	
        System.out.println("Introduce tu nombre de usuario:");
        respuestaNombre = br.readLine();
        System.out.println("Introduce tu nombre contraseña");
        respuestaPass = br.readLine();
        		  
        		  
        if (respuestaPass == ivan) {
        	Main.opcionesMenuPrincipal();
      	}
        		  
	}
	*/
	
public static void loggin() throws IOException, JAXBException {
		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	int respuesta = 0;
    	Integer[] opcionesValidas = {1, 2, 3};
    	
    	System.out.println("****************************");
    	System.out.println(" Bienvenido a Entreculturas");
    	System.out.println("****************************");
    	
        do {
        	System.out.println("\nPor favor, introduce el número de la acción que deseas realizar: ");
        	System.out.println("1 - Iniciar sesión como miembro de entreculturas");
        	System.out.println("2 - Iniciar sesión como administrador de entreculturas");
        	System.out.println("3 - Salir");
        	
        	try {
        		respuesta = Integer.parseInt(br.readLine());
            } catch(NumberFormatException nfe) {
                System.out.println("Los caracteres introducidos no son válidos.");
            }
        	
        } while (!Arrays.asList(opcionesValidas).contains(respuesta));
        
        switch(respuesta) {
           case 1:
        	  Main main = new Main();
    		  String respuestaNombre;
    		  String respuestaPass;
              System.out.println("Introduce tu nombre de usuario:");
              respuestaNombre = br.readLine();
              System.out.println("Introduce tu nombre contraseña");
              respuestaPass = br.readLine();
              		    
              if (respuestaPass == ivan) {
              	Main.opcionesMenuPrincipal();
            	}
              break;
           
         case 2:
        	  Miembros miembros = new Miembros();
        	  Miembros.abrirSesion();
              break;
            
           case 3:
        	  System.out.println("La sesión se ha cerrado con éxito.");
        	  System.exit(0);
              break;
        }
    }
}






