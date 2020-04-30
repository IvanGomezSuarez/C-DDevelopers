/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
    private TableView tablaMiembros;
    
    @FXML
    private TableView tablaMiembros2;
    
    @FXML
    private TableView direccion;
    
    @FXML
    private ListView listaMiembros;
    
    @FXML
    private Button alta;
    
    @FXML
    private Button editar;
    
    @FXML
    private Button delete;
    
    @FXML
    private MenuButton menu;
    
    @FXML
    private void altaMiembro(ActionEvent event ) throws IOException {
      
    }    
    
    @FXML
    private void editarMiembro(ActionEvent event ) throws IOException {
      
    }    
    
    @FXML
    private void deleteMiembro(ActionEvent event ) throws IOException {
      
    }    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
