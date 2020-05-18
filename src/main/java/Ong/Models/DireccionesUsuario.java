package Ong.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the direccionesUsuarios database table.
 * 
 */
@Entity
@Table(name="direccionesUsuarios")
@NamedQuery(name="DireccionesUsuario.findAll", query="SELECT d FROM DireccionesUsuario d")
public class DireccionesUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDireccion")
	private int idDireccion=0;
	
	private String cp;
	private String escalera;
	private String localidad;
	private int numero;
	private String pais;
	private String provincia;
	private String puerta;
	private String tipoVia;
				
//	@Id
//	@GeneratedValue(strategy=GenerationType.TABLE)
//@Column(name = "idDireccion")
	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	
	@Column(name = "cp")	
	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}
	
	@Column(name = "escalera")
	public String getEscalera() {
		return this.escalera;
	}

	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}
	
	@Column(name = "localidad")
	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@Column(name = "numero")
	public int getNumero() {
		return this.numero;
	}	

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Column(name = "pais")
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Column(name = "provincia")
	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Column(name = "puerta")
	public String getPuerta() {
		return this.puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	
	@Column(name = "tipoVia")
	public String getTipoVia() {
		return this.tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}	

}