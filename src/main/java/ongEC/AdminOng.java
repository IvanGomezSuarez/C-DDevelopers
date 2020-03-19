

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

/**
 * Esta clase representa a la persona encargada de crear los proyectos, modificarlos y eliminarlos
 * también lo mismo con las delegaciones
 * 
 * @version 1
 *
 */
public class AdminOng extends Miembros {
	
	// CAMPOS
	
	private String rootPass;
	private DAOFactory xmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
	private DAO<Proyecto> ProyectoDAO = (XMLTrabajadorDAO) xmlDAOFactory.getProyectoDAO();
	private DAO<Delegaciones> DelegacionesDAO = (XMLDelegacionDAO) xmlDAOFactory.getDelegacionesDAO();
	
	
	// CONSTRUCTORES
	
	/**
	 * Constructor que crea un nuevo objeto Admin sin inicializar sus campos.
	 * 
	 * @throws JAXBException si se produce una excepción de tipo JAXB.
	 */
	public AdminOng() throws JAXBException {
		super();
	}


	/**
	 * Constructor que crea un nuevo objeto AdminOng inicializando sus campos.
	 * 
	 */
	public AdminOng(String nombre, String pass) throws JAXBException {
		super(nombre, apellidos, id, email, telefono, direccion, delegacionAsignada, antiguedad, proyectosAsignados);
		this.rootPass = pass;
	}


	// METODOS
	
	/**
	 * Metodo accesor de lectura que nos da la password del admin.
	 * 
	 * @return Nos devuelve la password del admin. 
	 */
	public String getRootPass() {
		return rootPass;
	}

	/**
	 * Metodo accesor de escritura que asigna la password del admin.
	 * 
	 * @param rootPass password del admin. 
	 */
	public void setRootPass(String rootPass) {
		this.rootPass = rootPass;
	}

	/**
	 * Metodo que genera el menu de acciones que puede realizar el admin
	 * en la aplicacion cuando inicia sesion.
	 */
	@Override
	public void abrirSesion() throws IOException, JAXBException {
		    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int respuestaOpcion = 0;
		Integer[] opcionesValidas = {1, 2, 3, 4, 5};
  	    String respuestaNuevaAccion;
		
    	System.out.println("\n***************************");
    	System.out.println(" Opciones de administrador");
    	System.out.println("***************************");
    	
        do {
        	
        	System.out.println("\nPor favor, introduce el número de la acción que deseas realizar: ");
        	System.out.println("1 - Dar de alta un trabajador");
        	System.out.println("2 - Imprimir listado de trabajadores");
        	System.out.println("3 - Dar de alta una delegación");
        	System.out.println("4 - Imprimir listado delegaciones");
        	System.out.println("5 - Salir");
        	
        	try {
        		respuestaOpcion = Integer.parseInt(br.readLine());
            } catch(NumberFormatException nfe) {
                System.out.println("Los caracteres introducidos no son válidos.");
            }
        	
        } while (!Arrays.asList(opcionesValidas).contains(respuestaOpcion));
        
        switch(respuestaOpcion) {
        
           case 1:
        	  darAltaTrabajador();

        	  do {
        		  
        		  do {
        			  System.out.println("¿Deseas dar de alta otro trabajador? (S/N)");
            		  respuestaNuevaAccion = br.readLine();
        		  } while (!respuestaNuevaAccion.equalsIgnoreCase("s") && !respuestaNuevaAccion.equalsIgnoreCase("n"));
        		  
        		  if (respuestaNuevaAccion.equalsIgnoreCase("s")) {
        			  darAltaTrabajador();
      				}
        		  
        	  } while (!respuestaNuevaAccion.equalsIgnoreCase("n"));
        	  
        	  abrirSesion();
        	  
              break;
           
           case 2:
           	  imprimirListadoTrabajadores();
           	  abrirSesion();
              break;
              
           case 3:
         	  darAltaDelegacion();
         	  
        	  do {
        		  
        		  do {
        			  System.out.println("¿Deseas dar de alta otra delegación? (S/N)");
            		  respuestaNuevaAccion = br.readLine();
        		  } while (!respuestaNuevaAccion.equalsIgnoreCase("s") && !respuestaNuevaAccion.equalsIgnoreCase("n"));
        		  
        		  if (respuestaNuevaAccion.equalsIgnoreCase("s")) {
        			  darAltaDelegacion();
      				}
        		  
        	  } while (!respuestaNuevaAccion.equalsIgnoreCase("n"));
        	  
        	  abrirSesion();
         	  
               break;
               
           case 4:
        	   imprimirListadoDelegaciones();
        	   abrirSesion();
        	   
               break;
              
           case 5:
        	   System.out.println("La sesión se ha cerrado con éxito.");
        	   System.exit(0);
        	   
               break;
        }
    
	}

	/**
	 * Metodo que permite al empleado consultar el listado de proyectos
	 * en los que esta trabajando la ONG y realizar una serie de acciones.
	 */
	@Override
	public void consultarProyectos(ListadoProyectos lp) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Metodo que permite al administrador consultar el listado
	 * de trabajadores de la ONG.
	 * 
	 * @throws JAXBException si se produce una excepción de tipo JAXB.
	 */
	public void imprimirListadoTrabajadores() throws JAXBException {
		trabajadorDAO.obtenerTodos();
	}
	
	/**
	 * Metodo que permite al administrador consultar el listado
	 * de delegaciones de la ONG.
	 * 
	 * @throws JAXBException si se produce una excepción de tipo JAXB.
	 */
	public void imprimirListadoDelegaciones() throws JAXBException {
		delegacionDAO.obtenerTodos();
	}
	
	/**
	 * Metodo que permite al empleado introducir por consola los
	 * datos de alta de un nuevo trabajador.
	 * 
	 * @throws IOException si se produce un error de entrada/salida.
	 * @throws JAXBException si se produce una excepción de tipo JAXB.
	 */
	private void darAltaTrabajador() throws IOException, JAXBException {
		Trabajador nuevoTrabajador = new Trabajador();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nIntroduce el nombre del trabajador: ");
		nuevoTrabajador.setNombre(br.readLine());
		System.out.println("\nIntroduce los apellidos del trabajador: ");
		nuevoTrabajador.setApellidos(br.readLine());
		System.out.println("\nIntroduce el ID del trabajador: ");
		nuevoTrabajador.setId(br.readLine());
		System.out.println("\nIntroduce el email del trabajador: ");
		nuevoTrabajador.setEmail(br.readLine());
		System.out.println("\nIntroduce el teléfono del trabajador: ");
        try {
        	String numero = br.readLine();
        	validarNumeroTelefono(numero);
        	nuevoTrabajador.setTelefono(numero);
        } catch (TelefonoNoValidoException e) {
        	System.out.println("Número no válido, podrá modificarlo más adelante"); 
        	nuevoTrabajador.setTelefono("000000000");
        }
		Date date = new Date();
		nuevoTrabajador.setAntiguedad(date);
		Random random = new Random();
		String pass = String.format("%06d", random.nextInt(1000000));
		nuevoTrabajador.setPass(pass);
		trabajadorDAO.crearNuevo(nuevoTrabajador);
		
	}
	
	/**
	 * Metodo que permite al empleado introducir por consola los
	 * datos de alta de una nueva delegacion.
	 * 
	 * @throws IOException si se produce un error de entrada/salida.
	 * @throws JAXBException si se produce una excepción de tipo JAXB.
	 */
	private void darAltaDelegacion() throws IOException, JAXBException {
		Delegacion nuevaDelegacion = new Delegacion();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nIntroduce el nombre de la delegación: ");
		nuevaDelegacion.setNombreDelegacion(br.readLine());
		System.out.println("\nIntroduce el ID de la delegación: ");
		nuevaDelegacion.setIdDelegacion(br.readLine());
		System.out.println("\nIntroduce el teléfono de la delegación: ");
        try {
        	String numero = br.readLine();
        	validarNumeroTelefono(numero);
        	nuevaDelegacion.setTelefono(numero);
        } catch (TelefonoNoValidoException e) {
        	System.out.println("Número no válido, podrá modificarlo más adelante"); 
        	nuevaDelegacion.setTelefono("000000000");
        }
		System.out.println("\nEs sede central (S/N): ");
		if (br.readLine().equalsIgnoreCase("s")) {
			nuevaDelegacion.setIsSedeCentral(true);
		} else {
			nuevaDelegacion.setIsSedeCentral(false);			
		}
		
		delegacionDAO.crearNuevo(nuevaDelegacion);
		
	}
	
	/**
	 * Metodo que valida si el numero de telefono introducido es correcto.
	 * 
	 * @param numero Numero de telefono introducido.
	 */
	private void validarNumeroTelefono(String numero) {
		final String regexStr = "^(\\+34|0034|34)?[6789]\\d{8}$";
		if (!Pattern.matches(regexStr, numero)) {
			throw new TelefonoNoValidoException(numero);
		}
	}

}
