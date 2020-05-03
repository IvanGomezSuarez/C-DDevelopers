/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Views;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import Ong.Controllers.MiembrosJpaController;
import Ong.Models.Miembros;
import Ong.Models.MiembrosFX;
import javax.persistence.EntityManager;
import javax.xml.bind.JAXBException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import ongEC.Main;


/**
 * FXML Controller class, este es el controlador de la vista
 *
 * @author Ivan
 */
public class MiembrosController  {

    /**
     * Initializes the controller class.
     * 
     */
    private static final String PREFIX = "( ";
    private static final String POSTFIX = " )";
    public static MiembrosJpaController Service;
    public static List<Miembros> listMiembros;
    
    //cremos un entity Manager em
	EntityManager em;
	
	ObservableList<MiembrosFX> data;
    @FXML
    private ListView listaMiembros;
    
    //tabla miembros y sus columnas
    @FXML
    private TableView<MiembrosFX> tablaMiembros;
    @FXML
    private TableColumn<MiembrosFX, Number> idMemberCol;
    @FXML
    private TableColumn<MiembrosFX, String> nameMemberCol;
    @FXML
    private TableColumn<MiembrosFX, String> firstApellCol;
    @FXML
    private TableColumn<MiembrosFX, String> secondApellCol;
    @FXML
    private TableColumn<MiembrosFX, String> dniCol;
    @FXML
    private TableColumn<MiembrosFX, String> rolCol;
    @FXML
    private TableColumn<MiembrosFX, String> telCol;

    
    // tabla miembros 2 y sus columnas
    
   /* @FXML
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
   */
    @FXML
    private Button alta;
    
    @FXML
    private Button editar;
    
    @FXML
    private Button delete;
    
   /* @FXML
    private MenuButton menu;
    */

    
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
    
	public void initialize(URL url, ResourceBundle rb) {
    	
    	em = MainController.emf.createEntityManager();
        List<MiembrosFX> lst = em.createQuery("Select m FROM MiembrosFX m").getResultList();
        data = FXCollections.observableArrayList();
        // copiar datos de JPA a JFX Beans
        for (MiembrosFX lst1 : lst) {
        	data.add(new MiembrosFX(lst1.getIdMiembro(), lst1.getNombreMiembro(), lst1.getApellido1(), lst1.getApellido2(), lst1.getDni(), lst1.getRol(),
        			lst1.getTelefono(), lst1.getNombreUsuario(), lst1.getPass()));
        	
        }
        tablaMiembros.setItems(data);
        tablaMiembros.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        idMemberCol.setCellValueFactory(cell -> cell.getValue().getIdMiembroProperty());
        nameMemberCol.setCellValueFactory(cell -> cell.getValue().getNombreMiembroProperty());
        firstApellCol.setCellValueFactory(cell -> cell.getValue().getApellido1Property());
        secondApellCol.setCellValueFactory(cell -> cell.getValue().getApellido2Property());
        dniCol.setCellValueFactory(cell -> cell.getValue().getDniProperty());
        rolCol.setCellValueFactory(cell -> cell.getValue().getRolProperty());
        telCol.setCellValueFactory(cell -> cell.getValue().getTelefonoProperty());
        
        
    }
    
  
}
     

