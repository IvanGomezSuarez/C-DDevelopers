package ongEC;

import java.sql.Date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBException;
public class AdminAutonom extends IngresoPublico {

	// ATRIBUTOS
	
	String nombreOrganizacion;
	Direccion direccion;
	float importe;
	String descripcion;
	
	// CONSTRUCTORES
	
	public AdminAutonom(String nombreOrganizacion, Direccion direccion, float importe, String descripcion, int idIngreso, GregorianCalendar fechaIngreso) {
		super(fechaIngreso);
		this.nombreOrganizacion = nombreOrganizacion;
		this.direccion = direccion;
		this.importe = importe;
		this.descripcion = descripcion;
	}
	
	public AdminAutonom() {
		super();
	}
	
 
	// MÉTODOS
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
