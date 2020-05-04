package Ong.Models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idDireccion;

	private String cp;

	private String escalera;

	private String localidad;

	private int numero;

	private String pais;

	private String provincia;

	private String puerta;

	private String tipoVia;

	//bi-directional many-to-one association to Miembro
	@OneToMany(mappedBy="direccionesUsuario")
	private List<Miembro> miembros;

	public DireccionesUsuario() {
	}

	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getEscalera() {
		return this.escalera;
	}

	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPuerta() {
		return this.puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getTipoVia() {
		return this.tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public List<Miembro> getMiembros() {
		return this.miembros;
	}

	public void setMiembros(List<Miembro> miembros) {
		this.miembros = miembros;
	}

	public Miembro addMiembro(Miembro miembro) {
		getMiembros().add(miembro);
		miembro.setDireccionesUsuario(this);

		return miembro;
	}

	public Miembro removeMiembro(Miembro miembro) {
		getMiembros().remove(miembro);
		miembro.setDireccionesUsuario(null);

		return miembro;
	}

}