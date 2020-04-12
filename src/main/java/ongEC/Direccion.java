package ongEC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Esta clase representa el concepto de direccion
 * 
 *
 */
public class Direccion {
	
	//ATRIBUTOS
	int idDireccion;
	String tipoVia;
	int numero;
	String puerta;
	String escalera;
	String localidad;
	String provincia;
	String cp;
	String pais;
	
// CONSTRUCTORES
	

	public Direccion(int idDireccion, String tipoVia, int numero, String puerta, String escalera, String localidad,
			String provincia, String cp, String pais) {
		super();
		this.idDireccion = idDireccion;
		this.tipoVia = tipoVia;
		this.numero = numero;
		this.puerta = puerta;
		this.escalera = escalera;
		this.localidad = localidad;
		this.provincia = provincia;
		this.cp = cp;
		this.pais = pais;
	}
	
	public Direccion() {
	}

	// METODOS
	
	public String getTipoVia() {
		return tipoVia;
	}
	
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getPuerta() {
		return puerta;
	}
	
	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	
	public String getEscalera() {
		return escalera;
	}
	
	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getCp() {
		return cp;
	}
	
	public void setCp(String cp) {
		this.cp = cp;
	}
		
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public static Direccion addDireccion() throws IOException {
		Direccion newdireccion=new Direccion();
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\nIntroduce la Via: ");
		newdireccion.setTipoVia(br.readLine());
		System.out.println("\nIntroduce el Numero: ");
		newdireccion.setNumero(recuperado.nextInt());
		System.out.println("\nIntroduce la Puerta: ");
		newdireccion.setPuerta(br.readLine());
		System.out.println("\nIntroduce la Escalera: ");
		newdireccion.setEscalera(br.readLine());
		System.out.println("\nIntroduce la Localidad: ");
		newdireccion.setLocalidad(br.readLine());
		System.out.println("\nIntroduce la Provincia: ");
		newdireccion.setProvincia(br.readLine());
		System.out.println("\nIntroduce el codigo postal: ");
		newdireccion.setCp(br.readLine());
		System.out.println("\nIntroduce el Pais: ");
		newdireccion.setPais(br.readLine());
		return (newdireccion);
	}
	public static Direccion updateDireccion(int direccion) throws IOException {
		Direccion newdireccion=new Direccion();
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		newdireccion.setIdDireccion(direccion);
		System.out.println("\nIntroduce la Via: ");
		newdireccion.setTipoVia(br.readLine());
		System.out.println("\nIntroduce el Numero: ");
		newdireccion.setNumero(recuperado.nextInt());
		System.out.println("\nIntroduce la Puerta: ");
		newdireccion.setPuerta(br.readLine());
		System.out.println("\nIntroduce la Escalera: ");
		newdireccion.setEscalera(br.readLine());
		System.out.println("\nIntroduce la Localidad: ");
		newdireccion.setLocalidad(br.readLine());
		System.out.println("\nIntroduce la Provincia: ");
		newdireccion.setProvincia(br.readLine());
		System.out.println("\nIntroduce el codigo postal: ");
		newdireccion.setCp(br.readLine());
		System.out.println("\nIntroduce el Pais: ");
		newdireccion.setPais(br.readLine());
		return (newdireccion);
	}
	
}
