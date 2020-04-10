package ongEC;

//21/03/2020 falta implementar métodos todavia
//IMPORTS
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Esta clase representa los ingresos que se consiguen a través de los diversos organismos
 * publico o privados
 * @version 1
 * Ivan
 */

//DECLARACIÓN DE LA CLASE

@XmlRootElement(name = "Ingreso")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ingreso {
	
	//ATRIBUTOS
	@XmlElement(name = "IdIngreso")
	private int idIngreso;
	//private java.util.GregorianCalendar fechaRecepcionIngreso;
	@XmlElement(name = "FechaRecepcionIngreso")
	private Date fechaRecepcionIngreso;
	
	//CONSTRUCTORES
	
	/**
	 * este constructor crea objeto INGRESO  pero NO inicialia los atributos.
	 * @param idIngreso identifica el ingreso
	 * @param fechaRecepcionIngreso para conocer la fecha en la cual se recibe un ingreso
	 *
	 */
	
	public Ingreso() throws JAXBException {
		super();
	}
	

	public Ingreso(int idIngreso, Date fechaRecepcionIngreso) throws JAXBException{
		
		this.setIdIngreso(idIngreso);
		this.setFechaIngreso(fechaRecepcionIngreso);
	}
	
	
	
	//METODOS

	public static void addIngresoPublico() throws JAXBException {
		
		IngresoPublico ingresoPublico= new IngresoPublico();
		
	    Direccion direccion=new Direccion();
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		
		SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
		String antesConversionFecha;
		Date conversionaFecha= new Date(01/01/2020);
		
		ingresoPublico.setDireccion(direccion);
		
		System.out.println("Introduzca el id del Ingreso Publico");
		try {
			ingresoPublico.setIdIngreso(recuperado.nextInt());
		} catch (Exception e) {
			System.out.println("Formato Entero incorrecto");
			return;
		}
		
		System.out.println("Introduzca la fecha del Ingreso(porfavor introduzca la fecha en el siguiente formato --/--/----)");
		antesConversionFecha=recuperado.next();
		try {
			conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
		} catch (ParseException e) {
			System.out.println("Formato Fecha incorrecto");
			return;
		}
		ingresoPublico.setFechaIngreso(conversionaFecha);
		
		System.out.println("Introduzca el nombre de la organizacion");
		ingresoPublico.setNombreOrganizacion(recuperado.next());
		
		System.out.println("Introduzca la Via");
		ingresoPublico.direccion.setTipoVia(recuperado.next());
		
		System.out.println("Introduzca el numero");
		try {
			ingresoPublico.direccion.setNumero(recuperado.nextInt());
		} catch (Exception e) {
			System.out.println("Formato Entero incorrecto");
			return;
		}
		
		System.out.println("Introduzca la puerta");
		try {
			ingresoPublico.direccion.setPuerta(recuperado.next());
		} catch (Exception e) {
			System.out.println("Formato Entero incorrecto");
			return;
		}
		
		System.out.println("Introduzca la escalera");
		try {
			ingresoPublico.direccion.setEscalera(recuperado.next());
		} catch (Exception e) {
			System.out.println("Formato Entero incorrecto");
			return;
		}
		
		System.out.println("Introduzca la localidad");
		ingresoPublico.direccion.setLocalidad(recuperado.next());
		
		System.out.println("Introduzca la privincia");
		ingresoPublico.direccion.setProvincia(recuperado.next());
		
		System.out.println("Introduzca el CP");
		ingresoPublico.direccion.setCp(recuperado.next());
		
		System.out.println("Introduzca el importe");
		try {
			ingresoPublico.setImporte(recuperado.nextFloat());
		} catch (Exception e) {
			System.out.println("Formato Entero incorrecto");
			return;
		}
			
		System.out.println("Introduzca la descripcion");
		ingresoPublico.setDescripcion(recuperado.next());
		
		System.out.println("Insertar en el DAO");
	
		
}
	
	public static void addIngresoPrivado() throws JAXBException {
		
		IngresoPrivado ingresoPrivado=new IngresoPrivado();
	    Direccion direccion=new Direccion();
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		
		SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
		String antesConversionFecha;
		Date conversionaFecha= new Date(01/01/2020);
		
		ingresoPrivado.setDireccion(direccion);
		
		System.out.println("Introduzca el id del Ingreso Privado");
		try {
			ingresoPrivado.setIdIngreso(recuperado.nextInt());
		} catch (Exception e) {
			System.out.println("Formato Entero incorrecto");
			return;
		}
		
		System.out.println("Introduzca la fecha del Ingreso(porfavor introduzca la fecha en el siguiente formato --/--/----)");
		antesConversionFecha=recuperado.next();
		try {
			conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
		} catch (ParseException e) {
			System.out.println("Formato Fecha incorrecto");
			return;
		}
		ingresoPrivado.setFechaIngreso(conversionaFecha);
		
		System.out.println("Introduzca el nombre de la organizacion");
		ingresoPrivado.setNombreOrganizacion(recuperado.next());
		
		System.out.println("Introduzca la Via");
		ingresoPrivado.direccion.setTipoVia(recuperado.next());
		
		System.out.println("Introduzca el numero");
		try {
			ingresoPrivado.direccion.setNumero(recuperado.nextInt());
		} catch (Exception e) {
			System.out.println("Formato Entero incorrecto");
			return;
		}
		
		System.out.println("Introduzca la puerta");
		try {
			ingresoPrivado.direccion.setPuerta(recuperado.next());
		} catch (Exception e) {
			System.out.println("Formato Entero incorrecto");
			return;
		}
		
		System.out.println("Introduzca la escalera");
		try {
			ingresoPrivado.direccion.setEscalera(recuperado.next());
		} catch (Exception e) {
			System.out.println("Formato Entero incorrecto");
			return;
		}
		
		System.out.println("Introduzca la localidad");
		ingresoPrivado.direccion.setLocalidad(recuperado.next());
		
		System.out.println("Introduzca la privincia");
		ingresoPrivado.direccion.setProvincia(recuperado.next());
		
		System.out.println("Introduzca el CP");
		ingresoPrivado.direccion.setCp(recuperado.next());
		
		System.out.println("Introduzca el importe");
		try {
			ingresoPrivado.setImporte(recuperado.nextFloat());
		} catch (Exception e) {
			System.out.println("Formato Entero incorrecto");
			return;
		}
			
		System.out.println("Introduzca la descripcion");
		ingresoPrivado.setDescripcion(recuperado.next());
		
		System.out.println("Insertar en el DAO");
	}
	
	
	public static void delIngresoPublico() {
		System.out.println("Borrar en el DAO publico");
	}
	
	
	public static void delIngresoPrivado() {
		System.out.println("Borrar en el DAO privado");
	}
	
	public static void modIngresoPublico() {
		System.out.println("Modificar en el DAO publico");
	}

	public static void modIngresoPrivado() {
	System.out.println("Modificar en el DAO privado");
	}


	public java.util.Date getFechaIngreso() {
		return fechaRecepcionIngreso;
	}



	public void setFechaIngreso(Date conversionaFecha) {
		this.fechaRecepcionIngreso = conversionaFecha;
	}



	public int getIdIngreso() {
		return idIngreso;
	}



	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}
}
