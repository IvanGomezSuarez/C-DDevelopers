package Ong.Controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.impl.MySqlMiembroDAO;
import Ong.Models.DireccionesUsuario;
import Ong.Models.Miembro;
import Ong.Models.ModeloPrimeraTabla;
import Ong.Models.ModeloSegundaTabla;
import Ong.Models.ModeloTerceraTabla;
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

public class editMiembrosController {
	
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
    void guardarCambios(ActionEvent event) throws ParseException, SQLException {
    	emf = Persistence.createEntityManagerFactory("persistencia2");
    	miembro=new MiembroJpaController(emf);
    	voluntario=new VoluntarioJpaController(emf);
    	colaborador=new ColaboradorJpaController(emf);
    	personal=new PersonalJpaController(emf);
    	direccion=new DireccionesUsuarioJpaController(emf);
    	int idmiembroMAX;
    	int idDireccionMax;
    	DireccionesUsuario direccionNueva = new Ong.Models.DireccionesUsuario();
		Ong.Models.Miembro miembroNuevo=new Ong.Models.Miembro();
		Ong.Models.Personal personalNuevo=new Ong.Models.Personal();
		Ong.Models.MiembroSinRelaciones miembroNuevoSin=new Ong.Models.MiembroSinRelaciones();
		Ong.Models.PersonalSinRelaciones personalNuevoSin=new Ong.Models.PersonalSinRelaciones();
		Ong.Models.ColaboradorSinRelaciones colaboradorNuevoSin=new Ong.Models.ColaboradorSinRelaciones();
		Ong.Models.VoluntarioSinRelaciones voluntarioNuevoSin=new Ong.Models.VoluntarioSinRelaciones();
		List<Miembro> miembros=new ArrayList<Miembro>();
		
		
		idmiembroMAX=MySqlMiembroDAO.consultarIdGenerado()+1;
		miembroNuevoSin.setNombreMiembro(text_Nombre.getText());
		miembroNuevoSin.setApellido1(text_Apellido1.getText());
		miembroNuevoSin.setApellido2(text_Apellido2.getText());
		miembroNuevoSin.setDni(text_Dni.getText());
		miembroNuevoSin.setNombreUsuario(text_Usuario.getText());
		miembroNuevoSin.setTelefono(text_Telefono.getText());
		miembroNuevoSin.setPass(text_Password.getText());
		miembroNuevoSin.setRol(choice_Rol.getSelectionModel().getSelectedItem());

		

		direccionNueva.setCp(text_CP.getText());
		direccionNueva.setEscalera(text_Escalera.getText());
		direccionNueva.setLocalidad(text_Localidad.getText());
		direccionNueva.setNumero(Integer.parseInt(text_Numero.getText()));
		direccionNueva.setPais(text_Pais.getText());
		direccionNueva.setProvincia(text_Provincia.getText());
		direccionNueva.setPuerta(text_Puerta.getText());
		direccionNueva.setTipoVia(text_Via.getText());
		
		idDireccionMax=direccion.create(direccionNueva);
		miembroNuevoSin.setDireccion(idDireccionMax);
		
		idmiembroMAX=miembro.createMiembroSinRelacioens(miembroNuevoSin);
		
		SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
		String antesConversionFecha;
		Date conversionaFecha= new Date(01/01/2020);
    	
    	if(choice_comprobacion_Miembro.getValue().equals("VOLUNTARIO")){
    		String sDateAntes=text_FechaAlta.getText();
    		String sDateAntes1=text_FechaBaja.getText();
    		voluntarioNuevoSin.setIdVoluntario(idmiembroMAX);
    		voluntarioNuevoSin.setFechaAlta(convertirStringaFecha.parse(sDateAntes));
    		voluntarioNuevoSin.setFechaBaja(convertirStringaFecha.parse(sDateAntes1));
    		if (choice_NacionalInternacional.getSelectionModel().getSelectedItem().equals("NACIONAL")) {
    			voluntarioNuevoSin.setOrigen(text_Origen.getText());
    			voluntario.createSinRelaciones(voluntarioNuevoSin);
    		}else {
    			voluntarioNuevoSin.setPaisOrigen(text_Origen.getText());
    			voluntario.createSinRelaciones(voluntarioNuevoSin);
    		}
    		
    	}else if (choice_comprobacion_Miembro.getValue().equals("TRABAJADOR")){
    		String sDateAntes=text_FechaAlta.getText();
    		String sDateAntes1=text_FechaBaja.getText();
    		personalNuevoSin.setIdPersonal(idmiembroMAX);
    		personalNuevoSin.setFechaAlta(convertirStringaFecha.parse(sDateAntes));
    		personalNuevoSin.setFechaBaja(convertirStringaFecha.parse(sDateAntes1));
    		personal.createSinRelaciones(personalNuevoSin);
    		
    	}else {
    		String sDateAntes=text_FechaAlta.getText();
    		String sDateAntes1=text_FechaBaja.getText();
    		colaboradorNuevoSin.setIdColaborador(idmiembroMAX);
    		colaboradorNuevoSin.setFechaAlta(convertirStringaFecha.parse(sDateAntes));
    		colaboradorNuevoSin.setFechaBaja(convertirStringaFecha.parse(sDateAntes1));
    		colaborador.createSinRelaciones(colaboradorNuevoSin);    		
    	}
    	Stage stage = (Stage) button_Cancelar.getScene().getWindow();
    	stage.close();

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

	public void transferMessage(String message) {
		// TODO Auto-generated method stub
		text_Dni.setText(message);
		
		emf= Persistence.createEntityManagerFactory("persistencia2");
		personal= new PersonalJpaController(emf);
    	miembro=new MiembroJpaController(emf);
    	direccion=new DireccionesUsuarioJpaController(emf);
    	voluntario=new VoluntarioJpaController(emf);
    	colaborador=new ColaboradorJpaController(emf);
    	
		List<Ong.Models.PersonalSinRelaciones> listaPersonal = personal.findPersonalEntitiesSin();
    	List<Ong.Models.MiembroSinRelaciones> listaMiembros = miembro.findMiembroEntitiesSin();
    	List<Ong.Models.DireccionesUsuario> listaDirecciones = direccion.findDireccionesUsuarioEntities();
    	List<Ong.Models.VoluntarioSinRelaciones> listaVoluntarios = voluntario.findVoluntarioEntitiesSin();
    	List<Ong.Models.ColaboradorSinRelaciones> listaColaboradores = colaborador.findColaboradorEntitiesSin();
    	int idMiembroActua=0;
		SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
		String antesConversionFecha;
		Date conversionaFecha= new Date(01/01/2020);
		

    	
		for(Ong.Models.MiembroSinRelaciones miembrox : listaMiembros) {
			if(miembrox.getDni().equals(text_Dni.getText())) {
				idMiembroActua=miembrox.getIdMiembro();
				text_Nombre.setText(miembrox.getNombreMiembro());
				text_Apellido1.setText(miembrox.getApellido1());
				text_Apellido2.setText(miembrox.getApellido2());
				text_Dni.setText(miembrox.getDni());
				//ROL?miembrox.getRol()
				text_Telefono.setText(miembrox.getTelefono());
				text_Usuario.setText(miembrox.getNombreUsuario());
				text_Password.setText(miembrox.getPass());
			}
		}
		
		for(Ong.Models.MiembroSinRelaciones miembrox : listaMiembros) {
			for(Ong.Models.DireccionesUsuario direccionesUsuarior : listaDirecciones) {
				if(miembrox.getDireccion()==direccionesUsuarior.getIdDireccion() && miembrox.getIdMiembro()==idMiembroActua) {
					text_CP.setText(direccionesUsuarior.getCp());
					text_Escalera.setText(direccionesUsuarior.getEscalera());
					text_Localidad.setText(direccionesUsuarior.getLocalidad());
					text_Numero.setText(String.valueOf(direccionesUsuarior.getNumero()));
					text_Pais.setText(direccionesUsuarior.getPais());
					text_Provincia.setText(direccionesUsuarior.getProvincia());
					text_Puerta.setText(direccionesUsuarior.getPuerta());
					text_Via.setText(direccionesUsuarior.getTipoVia());
				}			
			}
		}
		
		for(Ong.Models.MiembroSinRelaciones miembrox : listaMiembros) {
			for(Ong.Models.ColaboradorSinRelaciones colaboradorr : listaColaboradores) {
				if(colaboradorr.getIdColaborador()==miembrox.getIdMiembro() && miembrox.getIdMiembro()==idMiembroActua) {
					java.sql.Date sDate = new java.sql.Date(colaboradorr.getFechaAlta().getTime());
					java.sql.Date sDate2 = new java.sql.Date(colaboradorr.getFechaBaja().getTime());
					text_FechaBaja.setText(colaboradorr.getFechaBaja().toString());
					text_FechaAlta.setText(colaboradorr.getFechaAlta().toString());
					
					
				}
			}
		}
		
		for(Ong.Models.MiembroSinRelaciones miembrox : listaMiembros) {
			for(Ong.Models.VoluntarioSinRelaciones voluntarior : listaVoluntarios) {
				if(voluntarior.getIdVoluntario()==miembrox.getIdMiembro() && miembrox.getIdMiembro()==idMiembroActua) {
					java.sql.Date sDate = new java.sql.Date(voluntarior.getFechaAlta().getTime());
					java.sql.Date sDate2 = new java.sql.Date(voluntarior.getFechaBaja().getTime());
					if (!(voluntarior.getOrigen().isEmpty())) {
						text_FechaBaja.setText(voluntarior.getFechaBaja().toString());
						text_FechaAlta.setText(voluntarior.getFechaAlta().toString());
					}else {
						text_FechaBaja.setText(voluntarior.getFechaBaja().toString());
						text_FechaAlta.setText(voluntarior.getFechaAlta().toString());
					}
					
				}
			}			
		}		
		for(Ong.Models.MiembroSinRelaciones miembrox : listaMiembros) {
			for(Ong.Models.PersonalSinRelaciones personalr : listaPersonal) {
				if(personalr.getIdPersonal()==miembrox.getIdMiembro() && miembrox.getIdMiembro()==idMiembroActua) {
					java.sql.Date sDate = new java.sql.Date(personalr.getFechaAlta().getTime());
					java.sql.Date sDate2 = new java.sql.Date(personalr.getFechaBaja().getTime());
					//tabla2.add(new ModeloSegundaTabla(miembrox.getNombreUsuario(),miembrox.getPass(),sDate,sDate2,""));
					text_FechaBaja.setText(personalr.getFechaBaja().toString());
					text_FechaAlta.setText(personalr.getFechaAlta().toString());
				}
				
			}
		}	
	}
}
