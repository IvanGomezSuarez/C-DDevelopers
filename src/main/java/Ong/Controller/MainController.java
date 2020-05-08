/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Controller;

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
 * @author Usuario
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
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
