package Ong.Controllers;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Ivan
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage  stage) throws IOException {

      Parent root = FXMLLoader.load(getClass().getResource("/Ong/Views/main.fxml"));
        
        Scene scene = new Scene(root);
        
        //String css = FXMain.class.getResource("myCss.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Bienvenido a EntreCulturas");
        stage.getIcons().add(new Image("/images/ong.jpg"));
        stage.show();
  
    }

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        launch(args);
    }
    
}
