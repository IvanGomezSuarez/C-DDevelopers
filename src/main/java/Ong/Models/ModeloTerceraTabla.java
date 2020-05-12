package Ong.Models;

public class ModeloTerceraTabla {
	String Via,Piso,Puerta,Localidad,Provincia,CP,Pais;
	int numero;
	
	public ModeloTerceraTabla(String via, int numero, String piso, String puerta, String localidad, String provincia,
			String cP, String pais) {
		super();
		Via = via;
		this.numero = numero;
		Piso = piso;
		Puerta = puerta;
		Localidad = localidad;
		Provincia = provincia;
		CP = cP;
		Pais = pais;
	}
	public String getVia() {
		return Via;
	}
	public void setVia(String via) {
		Via = via;
	}
	public String getPiso() {
		return Piso;
	}
	public void setPiso(String piso) {
		Piso = piso;
	}
	public String getPuerta() {
		return Puerta;
	}
	public void setPuerta(String puerta) {
		Puerta = puerta;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getCP() {
		return CP;
	}
	public void setCP(String cP) {
		CP = cP;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
