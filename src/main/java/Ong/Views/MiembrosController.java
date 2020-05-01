/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Views;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import DAO.impl.MiembroDAO;
import DAO.impl.MySqlMiembroDAO;
import DAO.impl.ProyectoDAO;
import DAO.impl.DAOFactory;
import sql.UtilitySql;
import ongEC.Miembro;

import javax.persistence.Persistence;
import javax.xml.bind.JAXBException;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import ongEC.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ongEC.Loggin;
import ongEC.Main;
import ongEC.Loggin;

/**
 * FXML Controller class, este es el controlador de la vista
 *
 * @author Ivan
 */
public class MiembrosController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
	
    @FXML
    private ListView listaMiembros;
    
    //tabla miembros y sus columnas
    @FXML
    private TableView<Member> tablaMiembros;
    @FXML
    private TableColumn<Member, Integer> idMemberCol;
    @FXML
    private TableColumn<Member, String> nameMemberCol;
    @FXML
    private TableColumn<Member, String> firstApellCol;
    @FXML
    private TableColumn<Member, String> secondApellCol;
    @FXML
    private TableColumn<Member, String> dniCol;
    @FXML
    private TableColumn<Member, String> rolCol;
    @FXML
    private TableColumn<Member, String> telCol;

    
    // tabla miembros 2 y sus columnas
    
    @FXML
    private TableView<Member> tablaMiembros2;
    @FXML
    private TableColumn<Member, Integer> userNameCol;
    @FXML
    private TableColumn<Member, String> passCol;
    @FXML
    private TableColumn<Member, Date> dateAltaCol;
    @FXML
    private TableColumn<Member, Date> dateBajaCol;
    @FXML
    private TableColumn<Member, String> paisOrigenCol;
   
    
    // tabla direcciones y sus columnas
    
    @FXML
    private TableView<Member> direccion;
    @FXML
    private TableColumn<Member, Integer> viaCol;
    @FXML
    private TableColumn<Member, String> numberCol;
    @FXML
    private TableColumn<Member, String> pisoCol;
    @FXML
    private TableColumn<Member, String> puertaCol;
    @FXML
    private TableColumn<Member, String> localidadCol;
    @FXML
    private TableColumn<Member, String> provinciaCol;
    @FXML
    private TableColumn<Member, String> cpCol;
    @FXML
    private TableColumn<Member, String> paisCol;
    
    @FXML
    private Button alta;
    
    @FXML
    private Button editar;
    
    @FXML
    private Button delete;
    
    @FXML
    private MenuButton menu;
    
    @FXML
    private void altaMiembro(ActionEvent event ) throws IOException, JAXBException, SQLException {
    	Main.main();

    }    
    
    @FXML
    private void editarMiembro(ActionEvent event ) throws IOException {
      
    }    
    
    @FXML
    private void deleteMiembro(ActionEvent event ) throws IOException {
      
    }    
    
    private static void InitTable (Persistence presistencia) {
    	
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    /*
     * data class
     */
    static final class Member extends RecursiveTreeObject<Member> {
        final IntegerProperty id;
        final StringProperty nombre;
        final StringProperty apellido1;
        final StringProperty apellido2;
        final StringProperty dni;
        final StringProperty rol;
        final StringProperty telefono;
        final StringProperty nombreUsuario;
        final StringProperty pass;
        final StringProperty fechaAlta;
        final StringProperty fechaBaja;
        final StringProperty paisOrigen;
        final StringProperty via;
        final StringProperty numero;
        final StringProperty piso;
        final StringProperty puerta;
        final StringProperty localidad;
        final StringProperty provincia;
        final StringProperty cp;
        final StringProperty pais;


        Member(Integer id, String nombre, String apellido1,
               String apellido2, String dni,
               String rol, String telefono,
               String nombreUsuario, String pass, String fechaAlta, String fechaBaja,
               String paisOrigen, String via, String numero, String piso, String puerta, String localidad,
               String provincia, String cp, String pais) {

            
			this.id = new SimpleIntegerProperty((id));
            this.nombre = new SimpleStringProperty(nombre);
            this.apellido1 = new SimpleStringProperty(apellido1);
            this.apellido2 = new SimpleStringProperty(apellido2);
            this.dni = new SimpleStringProperty(dni);
            this.rol = new SimpleStringProperty(rol);
            this.telefono = new SimpleStringProperty(telefono);
            this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
            this.pass = new SimpleStringProperty(pass);
            this.fechaAlta = new SimpleStringProperty(fechaAlta);
            this.fechaBaja = new SimpleStringProperty(fechaBaja);
            this.paisOrigen = new SimpleStringProperty(paisOrigen);
            this.via = new SimpleStringProperty(via);
            this.numero = new SimpleStringProperty((numero));
            this.piso = new SimpleStringProperty(piso);
            this.puerta = new SimpleStringProperty(puerta);
            this.localidad = new SimpleStringProperty(localidad);
            this.provincia = new SimpleStringProperty(provincia);
            this.cp = new SimpleStringProperty(cp);
            this.pais = new SimpleStringProperty(pais);
            
        }

        public Member(int id){
            
			this.id = new SimpleIntegerProperty((id));
            this.nombre = new SimpleStringProperty("\"NOMBRE\"");
            this.apellido1 = new SimpleStringProperty("\"#1 APELLIDO\"");
            this.apellido2 = new SimpleStringProperty("\"#2 APELLIDO\"");
            this.dni = new SimpleStringProperty("\"DNI\"");
            this.rol = new SimpleStringProperty("\"ROL\"");
            this.telefono = new SimpleStringProperty("\"#\"");
            this.nombreUsuario = new SimpleStringProperty("\"NOMBRE USUARIO\"");
            this.pass = new SimpleStringProperty();
            this.fechaAlta = new SimpleStringProperty("\"FECHA ALTA\"");
            this.fechaBaja = new SimpleStringProperty("\"FECHA BAJA\"");
            this.paisOrigen = new SimpleStringProperty("\"PAIS ORIGEN\"");
            this.via = new SimpleStringProperty("\"VIA\"");
            this.numero = new SimpleStringProperty("\"NUMERO\"", null);
            this.piso = new SimpleStringProperty("\"PISO\"");
            this.puerta = new SimpleStringProperty("\"PUERTA\"");
            this.localidad = new SimpleStringProperty("\"LOCALIDAD\"");
            this.provincia = new SimpleStringProperty("\"PROVINCIA\"");
            this.cp = new SimpleStringProperty("\"CP\"");
            this.pais = new SimpleStringProperty("\"PAIS\"");
        }

        IntegerProperty idProperty() { return id; }
        StringProperty nombreProperty() { return nombre; }
        StringProperty apellido1Property() { return apellido1; }
        StringProperty apellido2Property() { return apellido2; }
        StringProperty dniProperty() { return dni; }
        StringProperty rolNumberProperty() { return rol; }
        StringProperty telefonoProperty() { return telefono; }
        StringProperty nombreUsuarioProperty() { return nombreUsuario; }
        StringProperty passProperty() { return pass; }
        StringProperty fechaAltaProperty() { return fechaAlta; }
        StringProperty fechaBajaProperty() { return fechaBaja; }
        StringProperty paisOrigenProperty() { return paisOrigen; }
        StringProperty viaProperty() { return via; }
        StringProperty numeroProperty() { return numero; }
        StringProperty pisoProperty() { return piso; }
        StringProperty puertaAltaProperty() { return puerta; }
        StringProperty localidadProperty() { return localidad; }
        StringProperty provinciaProperty() { return provincia; }
        StringProperty cpProperty() { return cp; }
        StringProperty paisProperty() { return pais; }

    }
    
}
