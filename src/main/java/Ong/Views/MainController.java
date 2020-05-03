/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
   
public static EntityManagerFactory emf;
    @FXML
    private void handleButtonAction(ActionEvent event ) throws IOException {
        emf= Persistence.createEntityManagerFactory("persistencia");
        //	con este método cargamos el form de gestión de miembros
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ong/Views/miembros.fxml"));
    	Parent root = loader.load();
    	MiembrosController controlador = loader.getController();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.initModality(Modality.APPLICATION_MODAL);
    	stage.setTitle("Gestion de miembros de EntreCulturas");
    	stage.getIcons().add(new Image("/images/ong.jpg"));
    	stage.setScene(scene);
    	stage.showAndWait();
        
        stage.setOnCloseRequest(e ->{
        emf.close();
        Platform.exit();
        System.exit(0);
        });
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


}
    
