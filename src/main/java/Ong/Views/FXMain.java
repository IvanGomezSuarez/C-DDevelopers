/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ong.Views;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javafx.stage.Stage;


/**
 *
 * @author Usuario
 */
public class FXMain extends Application {
    
    private final Image imageOng = new Image("/images/ong.jpg");
    private final BorderPane container = new BorderPane();
	
    public static EntityManagerFactory emf;
    
    @Override
    public void start(Stage primaryStage) throws IOException {  
        emf = Persistence.createEntityManagerFactory("persistencia");
    	Parent root = FXMLLoader.load(getClass().getResource("/Ong/Views/main.fxml"));
        
        Scene scene = new Scene(root);
//        String css = FXMain.class.getResource("myCss.css").toExternalForm();
//        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bienvenido a EntreCulturas");
        primaryStage.getIcons().add(new Image("/images/ong.jpg"));
        //Image image = new Image(getClass().getResourceAsStream("/images/ong.jpg")); 
        // A?ado imagen de fondo a la ventana PERO NO CONSIGO QUE SALGA
        ImageView imageView = new ImageView();
        //imageView.setImage(imageOng);
        imageView.setFitHeight(240);
        imageView.setFitWidth(320);
        container.getChildren().add(imageView);
//        primaryStage.show();
//        
//        primaryStage.setOnCloseRequest(e ->{
//        	emf.close();
//        	Platform.exit();
//        	System.exit(0);
//        });       
//        
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//           @Override
//           public void handle(ActionEvent event) {
//               System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
