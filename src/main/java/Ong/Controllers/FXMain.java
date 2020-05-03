package Ong.Controllers;

import java.io.IOException;
import javafx.application.Application;
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
	

    @Override
    public void start(Stage  stage) throws IOException {
    	
    	
    	Parent root = FXMLLoader.load(getClass().getResource("/Ong/Views/main.fxml"));
        Scene scene = new Scene(root);
        //String css = FXMain.class.getResource("myCss.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Bienvenido a EntreCulturas");
        stage.getIcons().add(new Image("/images/ong.jpg"));
        //Image image = new Image(getClass().getResourceAsStream("/images/ong.jpg")); 
        // A�ado imagen de fondo a la ventana PERO NO CONSIGO QUE SALGA
        ImageView imageView = new ImageView();
        imageView.setImage(imageOng);
        imageView.setFitHeight(240);
        imageView.setFitWidth(320);
        container.getChildren().add(imageView);
      
        stage.show();
  
    }

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        launch(args);
    }
    
}
