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
    public void start(Stage stage) throws IOException {
       /* Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        */
        
        Parent root = FXMLLoader.load(getClass().getResource("/Ong/views/main.fxml"));
        
     /*   stage.setMaxHeight(600);
        stage.setMaxWidth(900);
        stage.setFullScreen(false);
        stage.setMaximized(false);
        double width = 1200;
        double height = 800;
*/

        Scene scene = new Scene(root);
        stage.setScene(scene);
       // stage.setTitle("ONG Resource Planner");
       // stage.getIcons().add(new Image("/images/ong.png"));
        stage.show();
        
        
       /* StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        launch(args);
    }
    
}
