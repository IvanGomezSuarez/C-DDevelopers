package Ong.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addMiembrosController {

    @FXML
    private Button button_Guardar;

    @FXML
    private Button button_Cancelar;

    @FXML
    private TextField text_Nombre;

    @FXML
    private TextField text_Apellido1;

    @FXML
    private TextField text_Apellido2;

    @FXML
    private TextField text_Dni;

    @FXML
    private TextField text_Telefono;

    @FXML
    private TextField text_Usuario;

    @FXML
    private TextField text_Password;

    @FXML
    private TextField text_FechaAlta;

    @FXML
    private TextField text_FechaBaja;

    @FXML
    private TextField text_Origen;

    @FXML
    private ChoiceBox<String> choice_tipoMiembro;
    

    @FXML
    private ChoiceBox<?> choice_origenSeleccion;

    @FXML
    private ChoiceBox<?> choice_Rol;

    @FXML
    void boton_Cancelar(ActionEvent event) {
    	Stage stage = (Stage) button_Cancelar.getScene().getWindow();
    	stage.close();
    	

    }

    @FXML
    void guardarCambios(ActionEvent event) {
    	

    }

}
