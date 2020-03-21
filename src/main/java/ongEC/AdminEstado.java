package ongEC;

//imports

import java.util.GregorianCalendar;

import javax.xml.bind.JAXBException;

// DECLARACION DE LA CLASE, HEREDA DE INGRESO PUBLICO

/**
 * Esta clase representa a la persona encargada de crear los proyectos, modificarlos y eliminarlos
 * también lo mismo con las delegaciones
 * 
 * @version 1
 * Yosu, Ivan
 */

public class AdminEstado extends IngresoPublico{

	
	// ATRIBUTOS
	
	String nombreOrganizacion;
	Direccion direccion;
	float importe;
	String descripcion;
	
	// CONSTRUCTORES
	
	/**
	 * Constructor que crea un nuevo objeto AdminEstado sin inicializar sus campos.
	 */
	
	public AdminEstado() throws JAXBException{
		super();
	}
	

	/**
	 * Constructor que crea un nuevo objeto AdminOng inicializando sus campos.
	 * @param nombreOrganiacion el nombre de la entidad que dona
	 * @param direccion atributo que contiene una lista con los campos a rellenar
	 * @param importe cuantía de la donacion
	 * @param descripcion el concepto de la donacion
	 * @param idIngreso identificador de ingreso de la clase padre
	 * @param fechaIngreso fecha en la que se produce el ingreso, atributo de la clase padre
	 */
	
	
	public AdminEstado(String nombreOrganizacion, Direccion direccion, float importe, String descripcion, int idIngresoPublico, GregorianCalendar fechaIngreso) throws JAXBException {
		super(idIngresoPublico, fechaIngreso, administracionesEstatales, administracionesAutonomicas, administracionesLocales, unionEuropea, idIngresoPublico, fechaIngreso);
		this.nombreOrganizacion = nombreOrganizacion;
		this.direccion = direccion;
		this.importe = importe;
		this.descripcion = descripcion;
	}


	
	
	
	
	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}
	
	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public float getImporte() {
		return importe;
	}
	
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
