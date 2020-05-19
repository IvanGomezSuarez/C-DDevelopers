package Ong.Controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Ivan
 */
public class FXMain extends Application {
	
	private final Image imageOng = new Image("/images/ong.jpg");
	private final BorderPane container = new BorderPane();
	
	public static EntityManagerFactory emf;

    @Override
    public void start(Stage  stage) throws IOException {
    	emf = Persistence.createEntityManagerFactory("persistencia");
    	Parent root = FXMLLoader.load(getClass().getResource("/Ong/Views/main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Bienvenido a EntreCulturas");
        stage.getIcons().add(new Image("/images/ong.jpg"));
        ImageView imageView = new ImageView();
        imageView.setImage(imageOng);
        imageView.setFitHeight(240);
        imageView.setFitWidth(320);
        container.getChildren().add(imageView);
        stage.show();
        
        stage.setOnCloseRequest(e ->{
        	emf.close();
        	Platform.exit();
        	System.exit(0);
        });
  
    }

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        launch(args);
    }
}
