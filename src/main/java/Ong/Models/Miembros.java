/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan
 */
@Entity
@Table(name = "miembros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Miembros.findAll", query = "SELECT m FROM Miembros m")
    , @NamedQuery(name = "Miembros.findByIdMiembro", query = "SELECT m FROM Miembros m WHERE m.idMiembro = :idMiembro")
    , @NamedQuery(name = "Miembros.findByNombreMiembro", query = "SELECT m FROM Miembros m WHERE m.nombreMiembro = :nombreMiembro")
    , @NamedQuery(name = "Miembros.findByNombreUsuario", query = "SELECT m FROM Miembros m WHERE m.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Miembros.findByPass", query = "SELECT m FROM Miembros m WHERE m.pass = :pass")
    , @NamedQuery(name = "Miembros.findByApellido1", query = "SELECT m FROM Miembros m WHERE m.apellido1 = :apellido1")
    , @NamedQuery(name = "Miembros.findByApellido2", query = "SELECT m FROM Miembros m WHERE m.apellido2 = :apellido2")
    , @NamedQuery(name = "Miembros.findByDni", query = "SELECT m FROM Miembros m WHERE m.dni = :dni")
    , @NamedQuery(name = "Miembros.findByRol", query = "SELECT m FROM Miembros m WHERE m.rol = :rol")
    , @NamedQuery(name = "Miembros.findByTelefono", query = "SELECT m FROM Miembros m WHERE m.telefono = :telefono")})
public class Miembros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMiembro")
    private Integer idMiembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nombreMiembro")
    private String nombreMiembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "pass")
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "apellido1")
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "apellido2")
    private String apellido2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "rol")
    private String rol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telefono")
    private String telefono;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "miembros")
    private Colaborador colaborador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "miembros")
    private Personal personal;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "miembros")
    private Voluntario voluntario;
    @JoinColumn(name = "direccion", referencedColumnName = "idDireccion")
    @ManyToOne
    private Direccionesusuarios direccion;

    public Miembros() {
    }

    public Miembros(Integer idMiembro) {
        this.idMiembro = idMiembro;
    }

    public Miembros(Integer idMiembro, String nombreMiembro, String nombreUsuario, String pass, String apellido1, String apellido2, String dni, String rol, String telefono) {
        this.idMiembro = idMiembro;
        this.nombreMiembro = nombreMiembro;
        this.nombreUsuario = nombreUsuario;
        this.pass = pass;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.rol = rol;
        this.telefono = telefono;
    }

    public Integer getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(Integer idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getNombreMiembro() {
        return nombreMiembro;
    }

    public void setNombreMiembro(String nombreMiembro) {
        this.nombreMiembro = nombreMiembro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public Direccionesusuarios getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccionesusuarios direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMiembro != null ? idMiembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miembros)) {
            return false;
        }
        Miembros other = (Miembros) object;
        if ((this.idMiembro == null && other.idMiembro != null) || (this.idMiembro != null && !this.idMiembro.equals(other.idMiembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ong.Models.Miembros[ idMiembro=" + idMiembro + " ]";
    }
    
}
