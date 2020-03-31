package ongEC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta clase representa el conceoti de direccion
 * 
 * @version 1
 * Yosu
 *
 */
public class Direccion {
	
	String tipoVia;
	int numero;
	int puerta;
	int escalera;
	String localidad;
	String provincia;
	String cp;
	
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
	
	public int getPuerta() {
		return puerta;
	}
	
	public void setPuerta(int puerta) {
		this.puerta = puerta;
	}
	
	public int getEscalera() {
		return escalera;
	}
	
	public void setEscalera(int escalera) {
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
	
	public Direccion(String tipoVia, int numero, int puerta, int escalera, String localidad, String provincia,
			String cp) {
		super();
		this.tipoVia = tipoVia;
		this.numero = numero;
		this.puerta = puerta;
		this.escalera = escalera;
		this.localidad = localidad;
		this.provincia = provincia;
		this.cp = cp;
	}
	
	public Direccion() {
		super();
	}
	
	public static Direccion addDireccion() throws IOException {
		Direccion newdireccion=new Direccion();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nIntroduce la TipoVia: ");
		newdireccion.setTipoVia(br.readLine());
		System.out.println("\nIntroduce la Puerta: ");
		newdireccion.setPuerta(br.read());
		System.out.println("\nIntroduce la Escalera: ");
		newdireccion.setEscalera(br.read());
		System.out.println("\nIntroduce la Localidad: ");
		newdireccion.setLocalidad(br.readLine());
		System.out.println("\nIntroduce la Provincia: ");
		newdireccion.setProvincia(br.readLine());
		System.out.println("\nIntroduce el codigo postal: ");
		newdireccion.setCp(br.readLine());
		return (newdireccion);
	}
	
}
