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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
	

    @FXML
    private ImageView imageOng;
    
    
    @FXML
    private Button btnAcceso;
   

    @FXML
    private void handleButtonAction(ActionEvent event ) throws IOException {
      Parent parent = FXMLLoader.load(getClass().getResource("/Ong/Views/miembros.fxml"));
    	Stage stage = new Stage();
    	Scene scene = new Scene(parent);
    	stage.setTitle("Gestion de miembros de EntreCulturas");
    	stage.getIcons().add(new Image("/images/ong.jpg"));
    	stage.show();

    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


}
    
