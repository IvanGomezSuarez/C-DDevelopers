package Ong.Controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
	private VoluntarioJpaController voluntario;
	private ColaboradorJpaController colaborador;
	private MiembroJpaController miembro;
	private PersonalJpaController personal;
	private DireccionesUsuarioJpaController direccion;
	public static EntityManagerFactory emf;
	
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
    private TextField text_Via;

    @FXML
    private TextField text_Numero;

    @FXML
    private TextField text_Puerta;

    @FXML
    private TextField text_Escalera;

    @FXML
    private TextField text_Localidad;

    @FXML
    private TextField text_Provincia;

    @FXML
    private TextField text_CP;

    @FXML
    private TextField text_Pais;

    
    @FXML
    private ComboBox<String> choice_comprobacion_Miembro;

    @FXML
    void boton_Cancelar(ActionEvent event) {
    	Stage stage = (Stage) button_Cancelar.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void guardarCambios(ActionEvent event) {
    	emf = Persistence.createEntityManagerFactory("persistencia2");
    	miembro=new MiembroJpaController(emf);
    	voluntario=new VoluntarioJpaController(emf);
    	colaborador=new ColaboradorJpaController(emf);
    	personal=new PersonalJpaController(emf);
    	direccion=new DireccionesUsuarioJpaController(emf);
    	
    	Ong.Models.DireccionesUsuario direccionNueva = new Ong.Models.DireccionesUsuario();
		Ong.Models.Miembro miembroNuevo=new Ong.Models.Miembro();
		Ong.Models.Personal personalNuevo=new Ong.Models.Personal();
		
		miembroNuevo.setNombreMiembro(text_Nombre.getText());
		miembroNuevo.setApellido1(text_Apellido1.getText());
		miembroNuevo.setApellido2(text_Apellido2.getText());
		miembroNuevo.setDni(text_Dni.getText());
		miembroNuevo.setNombreUsuario(text_Usuario.getText());
		miembroNuevo.setTelefono(text_Telefono.getText());
		miembroNuevo.setPass(text_Password.getText());
		miembroNuevo.setRol(choice_Rol.getTypeSelector());

		direccionNueva.setIdDireccion(5);
		direccionNueva.setCp(text_CP.getText());
		direccionNueva.setEscalera(text_Escalera.getText());
		direccionNueva.setLocalidad(text_Localidad.getText());
		direccionNueva.setNumero(Integer.parseInt(text_Numero.getText()));
		direccionNueva.setPais(text_Pais.getText());
		direccionNueva.setProvincia(text_Provincia.getText());
		direccionNueva.setPuerta(text_Puerta.getText());
		direccionNueva.setTipoVia(text_Via.getText());
    	
    	if(choice_comprobacion_Miembro.getValue().equals("VOLUNTARIO")){
    		
    	}else if (choice_comprobacion_Miembro.getValue().equals("TRABAJADOR")){
    		personalNuevo.setFechaAlta(text_FechaAlta.getText());
    		personalNuevo.setFechaBaja(text_FechaBaja.getText());
    		
    		direccion.create(direccionNueva);
    	}else {
    		
    	}

    }
    

    @FXML
    void seleccionTipoMiembro(MouseEvent event) {
    	
    }
    @FXML
    private void comprobacion_Miembro(ActionEvent event) {
    	System.out.println(choice_comprobacion_Miembro.getValue());
    	if(choice_comprobacion_Miembro.getValue().equals("VOLUNTARIO")){
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
