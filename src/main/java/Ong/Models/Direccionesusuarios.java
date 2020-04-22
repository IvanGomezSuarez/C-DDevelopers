/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ivan
 */
@Entity
@Table(name = "direccionesusuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccionesusuarios.findAll", query = "SELECT d FROM Direccionesusuarios d")
    , @NamedQuery(name = "Direccionesusuarios.findByIdDireccion", query = "SELECT d FROM Direccionesusuarios d WHERE d.idDireccion = :idDireccion")
    , @NamedQuery(name = "Direccionesusuarios.findByTipoVia", query = "SELECT d FROM Direccionesusuarios d WHERE d.tipoVia = :tipoVia")
    , @NamedQuery(name = "Direccionesusuarios.findByNumero", query = "SELECT d FROM Direccionesusuarios d WHERE d.numero = :numero")
    , @NamedQuery(name = "Direccionesusuarios.findByPuerta", query = "SELECT d FROM Direccionesusuarios d WHERE d.puerta = :puerta")
    , @NamedQuery(name = "Direccionesusuarios.findByEscalera", query = "SELECT d FROM Direccionesusuarios d WHERE d.escalera = :escalera")
    , @NamedQuery(name = "Direccionesusuarios.findByLocalidad", query = "SELECT d FROM Direccionesusuarios d WHERE d.localidad = :localidad")
    , @NamedQuery(name = "Direccionesusuarios.findByProvincia", query = "SELECT d FROM Direccionesusuarios d WHERE d.provincia = :provincia")
    , @NamedQuery(name = "Direccionesusuarios.findByCp", query = "SELECT d FROM Direccionesusuarios d WHERE d.cp = :cp")
    , @NamedQuery(name = "Direccionesusuarios.findByPais", query = "SELECT d FROM Direccionesusuarios d WHERE d.pais = :pais")})
public class Direccionesusuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDireccion")
    private Integer idDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoVia")
    private String tipoVia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "puerta")
    private String puerta;
    @Size(max = 3)
    @Column(name = "escalera")
    private String escalera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "localidad")
    private String localidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 6)
    @Column(name = "cp")
    private String cp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pais")
    private String pais;
    @OneToMany(mappedBy = "direccion")
    private Collection<Miembros> miembrosCollection;

    public Direccionesusuarios() {
    }

    public Direccionesusuarios(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Direccionesusuarios(Integer idDireccion, String tipoVia, int numero, String puerta, String localidad, String provincia, String pais) {
        this.idDireccion = idDireccion;
        this.tipoVia = tipoVia;
        this.numero = numero;
        this.puerta = puerta;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

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

    @XmlTransient
    public Collection<Miembros> getMiembrosCollection() {
        return miembrosCollection;
    }

    public void setMiembrosCollection(Collection<Miembros> miembrosCollection) {
        this.miembrosCollection = miembrosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccionesusuarios)) {
            return false;
        }
        Direccionesusuarios other = (Direccionesusuarios) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ong.Models.Direccionesusuarios[ idDireccion=" + idDireccion + " ]";
    }
    
}
