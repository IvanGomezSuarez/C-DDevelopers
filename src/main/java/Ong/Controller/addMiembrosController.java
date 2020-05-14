package Ong.Controller;

import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addMiembrosController {
	
	ObservableList<String> listaRol=FXCollections.observableArrayList("ADMINISTRADOR", "MIEMBRO");
	ObservableList<String> listaTipoMiembros=FXCollections.observableArrayList("TRABAJADOR", "COLABORADOR","VOLUNTARIO");
	ObservableList<String> seleccionNacionalInternacional=FXCollections.observableArrayList("NACIONAL", "INTERNACIONAL");
	
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
    private ChoiceBox<String> choice_Rol;

    @FXML
    private ChoiceBox<String> choice_NacionalInternacional;

    @FXML
    private ChoiceBox<String> choice_Miembro;
    
    @FXML
    private Text etiquetaVoluntario;
    
    @FXML
    private Text etiquetaOrigen;
    
    @FXML
    private ComboBox<String> choice_comprobacion_Miembro;

    @FXML
    void boton_Cancelar(ActionEvent event) {
    	Stage stage = (Stage) button_Cancelar.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void guardarCambios(ActionEvent event) {
    	
    	

    }
    

    @FXML
    void seleccionTipoMiembro(MouseEvent event) {
    	
    }
    @FXML
    private void comprobacion_Miembro(ActionEvent event) {
    	System.out.println(choice_comprobacion_Miembro.getValue());
    	if(choice_comprobacion_Miembro.getValue().equals("TRABAJADOR")){
    		text_Origen.setVisible(true);
        	etiquetaOrigen.setVisible(true);
        	etiquetaVoluntario.setVisible(true);
        	choice_NacionalInternacional.setVisible(true);
    	}else {
    		text_Origen.setVisible(false);
        	etiquetaOrigen.setVisible(false);
        	etiquetaVoluntario.setVisible(false);
        	choice_NacionalInternacional.setVisible(false);
    	}
    	
    }

    
    @FXML
    private void initialize() {
    	choice_Rol.setItems(listaRol);
    	choice_Miembro.setItems(listaTipoMiembros);
    	choice_Miembro.setVisible(false);
    	text_Origen.setVisible(false);
    	etiquetaOrigen.setVisible(false);
    	etiquetaVoluntario.setVisible(false);
    	choice_comprobacion_Miembro.setItems(listaTipoMiembros);
    	choice_NacionalInternacional.setItems(seleccionNacionalInternacional);
    	choice_NacionalInternacional.setVisible(false);
    	choice_NacionalInternacional.hide();
    }
    
}
