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

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Clase para crear las propiedades
 * @author Ivan
 */

public class MiembrosFX {

    private SimpleIntegerProperty idMiembro;

    private SimpleStringProperty nombreMiembro;

    private SimpleStringProperty nombreUsuario;

    private SimpleStringProperty apellido1;

    private SimpleStringProperty apellido2;

    private SimpleStringProperty dni;

    private SimpleStringProperty rol;

    private SimpleStringProperty telefono;
  
    private Colaborador colaborador;

    private Personal personal;

    private Voluntario voluntario;

    private Direccionesusuarios direccion;

	private SimpleStringProperty pass;

    public MiembrosFX() {
    }

    public MiembrosFX(Integer idMiembro) {
        this.idMiembro =  new SimpleIntegerProperty(idMiembro);
    }

    public MiembrosFX(Integer idMiembro, String nombreMiembro, String nombreUsuario, String pass, String apellido1, String apellido2, String dni, String rol, String telefono) {
        this.idMiembro =  new SimpleIntegerProperty(idMiembro);
        this.nombreMiembro = new SimpleStringProperty (nombreMiembro);
        this.nombreUsuario = new SimpleStringProperty (nombreUsuario);
        this.pass = new SimpleStringProperty (pass);
        this.apellido1 = new SimpleStringProperty (apellido1);
        this.apellido2 = new SimpleStringProperty (apellido2);
        this.dni = new SimpleStringProperty (dni);
        this.rol = new SimpleStringProperty (rol);
        this.telefono = new SimpleStringProperty (telefono);
    }

    public Integer getIdMiembro() {
        return idMiembro.get();
    }
    
    public SimpleIntegerProperty getIdMiembroProperty() {
        return idMiembro;
    }

    public void setIdMiembro(Integer idMiembro) {
        this.idMiembro = new SimpleIntegerProperty(idMiembro);
    }

    public String getNombreMiembro() {
        return nombreMiembro.get();
    }   
    
    public SimpleStringProperty getNombreMiembroProperty() {
        return nombreMiembro;
    }
    
    

    public void setNombreMiembro(String nombreMiembro) {
        this.nombreMiembro = new SimpleStringProperty(nombreMiembro);
    }

    public String getNombreUsuario() {
        return nombreUsuario.get();
    }
    
    public SimpleStringProperty getNombreUsuarioProperty() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
    }

    public String getPass() {
        return pass.get();
    }

    public SimpleStringProperty getPassProperty() {
        return pass;
    }
    
    public void setPass(String pass) {
        this.pass = new SimpleStringProperty(pass);
    }

    public String getApellido1() {
        return apellido1.get();
    }
    
    public SimpleStringProperty getApellido1Property() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = new SimpleStringProperty(apellido1);
    }

    public String getApellido2() {
        return apellido2.get();
    }
    
    public SimpleStringProperty getApellido2Property() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = new SimpleStringProperty(apellido2);
    }

    public String getDni() {
        return dni.get();
    }
    
    public SimpleStringProperty getDniProperty() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = new SimpleStringProperty(dni);
    }

    public String getRol() {
        return rol.get();
    }
    
    public SimpleStringProperty getRolProperty() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = new SimpleStringProperty(rol);
    }

    public String getTelefono() {
        return telefono.get();
    }
    
    public SimpleStringProperty getTelefonoProperty() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = new SimpleStringProperty(telefono);
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


    
}
