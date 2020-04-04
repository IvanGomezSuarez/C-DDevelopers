package ongEC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import ongEC.Main;
import javax.xml.bind.JAXBException;

import DAO.impl.DelegacionDAO;
import DAO.impl.MiembroDAO;



/**
 * Esta clase permite hacer el loggin a un miembro
 * 
 *
 */

public class Loggin extends Miembro {


	// ATRIBUTOS

	private static final String ivan = null;
	private String usuario;
	private String pass;
	static Delegacion nuevaDelegacion= new Delegacion();
	static Delegaciones nuevasDelegaciones=new Delegaciones();
	static Miembros miembrosAnteriores=new Miembros();

	
	// CONSTRUCTORES
	
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
	
	

	// METODOS

	
public static void loggin() throws IOException, JAXBException {
		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	int respuesta = 0;
    	Integer[] opcionesValidas = {1, 2, 3};
    	nuevasDelegaciones=DelegacionDAO.readfirst();
    	miembrosAnteriores=MiembroDAO.readfirst();
    	System.out.println("****************************");
    	System.out.println(" Bienvenido a Entreculturas");
    	System.out.println("****************************");
    	
        do {
        	nuevasDelegaciones=DelegacionDAO.readfirst();
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
              		    
              if (respuestaPass.equals("ivan")) {
            	  System.out.println("Buscando miembro...");
            	  System.out.println("Miembro encontrado Buenas" + " " + respuestaNombre);
              	return;
            	}else {
            		 System.out.println("Miembro no encontrado");
            		 Loggin.loggin();
            	}
              break;
           
         case 2:
        	  abrirSesion();
              break;
            
           case 3:
        	  System.out.println("La sesión se ha cerrado con éxito.");
        	  System.exit(0);
              break;
        }
    }

public static void abrirSesion() throws IOException, JAXBException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	int respuestaOpcion = 0;
	Integer[] opcionesValidas = {1, 2, 3, 4, 5};
	String respuestaNuevaAccion;


	System.out.println("\n************************");
	System.out.println(" Opciones de Administrador");
	System.out.println("**************************");

	do {

		System.out.println("\nPor favor, introduce el número de la acción que deseas realizar: ");
		System.out.println("1 - Dar de alta una delegacion");
		System.out.println("2 - Imprimir listado de delegaciones");
		System.out.println("3 - Dar de baja una delegacion");
		System.out.println("4 - Modificar una delegacion");
		System.out.println("5 - Salir");

		try {
			respuestaOpcion = Integer.parseInt(br.readLine());
		} catch(NumberFormatException nfe) {
			System.out.println("Los caracteres introducidos no son válidos.");
		}

	} while (!Arrays.asList(opcionesValidas).contains(respuestaOpcion));

	switch(respuestaOpcion) {

	case 1:
		
		nuevaDelegacion=DelegacionDAO.addDelegacion(nuevasDelegaciones);
		nuevasDelegaciones.add(nuevaDelegacion);
		do {

			do {
				System.out.println("¿Deseas dar de alta otra delegacion? (S/N)");
				respuestaNuevaAccion = br.readLine();
			} while (!respuestaNuevaAccion.equalsIgnoreCase("s") && !respuestaNuevaAccion.equalsIgnoreCase("n"));

			if (respuestaNuevaAccion.equalsIgnoreCase("s")) {
				nuevaDelegacion=DelegacionDAO.addDelegacion(nuevasDelegaciones);
				nuevasDelegaciones.add(nuevaDelegacion);
			}else {
				DelegacionDAO.save(nuevasDelegaciones);
			}

		} while (!respuestaNuevaAccion.equalsIgnoreCase("n"));

		abrirSesion();

		break;

	case 2:
		DelegacionDAO.getAll();
		abrirSesion();
		break;
		
		
	case 3:
		DelegacionDAO.delete(nuevasDelegaciones);
		DelegacionDAO.save(nuevasDelegaciones);
		abrirSesion();
		break;	
		

	case 4:
		DelegacionDAO.update(nuevasDelegaciones);
		DelegacionDAO.save(nuevasDelegaciones);
		abrirSesion();
		break;
	
	case 5:
		System.out.println("La sesión se ha cerrado con éxito.");
		System.exit(0);
		break;
	}
	
}

public static void pulsaIntroParaContinuar() {

    String tecla;
    Scanner teclado = new Scanner(System.in);
    System.out.println("Presione Enter para continuar...");

    try {

        tecla = teclado.nextLine();

    }

    catch(Exception e)

    {}

}
}



