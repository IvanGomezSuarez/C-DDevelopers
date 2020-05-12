package Ong.Models;

import java.sql.Date;

public class ModeloSegundaTabla {
	String NombreUsuario,Password,PaisOrigenPais;
	Date FechaAlta,FechaBaja;
	
	
	public ModeloSegundaTabla(String nombreUsuario, String password,Date fechaAlta,
			Date fechaBaja, String paisOrigenPais ) {
		super();
		NombreUsuario = nombreUsuario;
		Password = password;
		FechaAlta = fechaAlta;
		FechaBaja = fechaBaja;
		PaisOrigenPais = paisOrigenPais;
	}
	
	public String getNombreUsuario() {
		return NombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPaisOrigenPais() {
		return PaisOrigenPais;
	}
	public void setPaisOrigenPais(String paisOrigenPais) {
		PaisOrigenPais = paisOrigenPais;
	}
	public Date getFechaAlta() {
		return FechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		FechaAlta = fechaAlta;
	}
	public Date getFechaBaja() {
		return FechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		FechaBaja = fechaBaja;
	}	
}
