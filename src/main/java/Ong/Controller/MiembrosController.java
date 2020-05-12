package Ong.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import ongEC.Voluntario;
import Ong.Controller.VoluntarioJpaController;
import Ong.Controller.exceptions.NonexistentEntityException;
import Ong.Controller.MiembroJpaController;
import Ong.Controller.ColaboradorJpaController;
import Ong.Controller.PersonalJpaController;
import Ong.Controller.DireccionesUsuarioJpaController;
import Ong.Models.Miembro;
import Ong.Controller.MiembroJpaController;
import Ong.Models.ModeloPrimeraTabla;
import Ong.Models.ModeloSegundaTabla;
import Ong.Models.ModeloTerceraTabla;

public class MiembrosController {
	//Lista observable de Usuarios para la columna DNI
	ObservableList list=FXCollections.observableArrayList();
	//Lista observable de Usuarios para la busqueda de datos
	ObservableList listUsuarios=FXCollections.observableArrayList();
	//Lista observable de la primera tabla con la misma forma
	ObservableList<ModeloPrimeraTabla> tabla1=FXCollections.observableArrayList();
	//Lista observable de la tercera tabla con la misma forma
	ObservableList<ModeloSegundaTabla> tabla2=FXCollections.observableArrayList();
	//Lista observable de la tercera tabla con la misma forma
	ObservableList<ModeloTerceraTabla> tabla3=FXCollections.observableArrayList();
    public static EntityManagerFactory emf;
    
	private VoluntarioJpaController voluntario;
	private ColaboradorJpaController colaborador;
	private MiembroJpaController miembro;
	private PersonalJpaController personal;
	private DireccionesUsuarioJpaController direccion;
	
    @FXML
    private TableView<ModeloPrimeraTabla> primeraTabla;
    @FXML
    private TableColumn<ModeloPrimeraTabla, Integer> col_Id;
    @FXML
    private TableColumn<ModeloPrimeraTabla, String> col_Nombre;
    @FXML
    private TableColumn<ModeloPrimeraTabla, String> col_1Apellido;
    @FXML
    private TableColumn<ModeloPrimeraTabla, String> col_2Apellido;
    @FXML
    private TableColumn<ModeloPrimeraTabla, String> col_Dni;
    @FXML
    private TableColumn<ModeloPrimeraTabla, String> col_Rol;
    @FXML
    private TableColumn<ModeloPrimeraTabla, String> col_Telefono;
    
    
    @FXML
    private TableView<ModeloSegundaTabla> segundaTabla;
    @FXML
    private TableColumn<ModeloSegundaTabla, String> col_nombreUsuario;
    @FXML
    private TableColumn<ModeloSegundaTabla, Integer> col_Password;
    @FXML
    private TableColumn<ModeloSegundaTabla, String> col_FechaAlta;
    @FXML
    private TableColumn<ModeloSegundaTabla, String> col_FechaBaja;
    @FXML
    private TableColumn<ModeloSegundaTabla, String> col_paisOrigenPais;

    @FXML
    private TableView<ModeloTerceraTabla> terceraTabla;
    @FXML
    private TableColumn<ModeloTerceraTabla, String> col_Via;
    @FXML
    private TableColumn<ModeloTerceraTabla, Integer> col_N;
    @FXML
    private TableColumn<ModeloTerceraTabla, String> col_Piso;
    @FXML
    private TableColumn<ModeloTerceraTabla, String> col_Puerta;
    @FXML
    private TableColumn<ModeloTerceraTabla, String> col_Localidad;
    @FXML
    private TableColumn<ModeloTerceraTabla, String> col_Provincia;
    @FXML
    private TableColumn<ModeloTerceraTabla, String> col_CP;
    @FXML
    private TableColumn<ModeloTerceraTabla, String> col_Pais;
    

	@FXML
	private ListView<Ong.Models.Voluntario> listaRellenar;
	
	@FXML
    void cargarDatos(MouseEvent event) {
		tabla1.clear();
		tabla2.clear();
		tabla3.clear();
		//Definicion de priemra tabla de campos
		col_Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
		col_Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
		col_1Apellido.setCellValueFactory(new PropertyValueFactory<>("apellido1"));
		col_2Apellido.setCellValueFactory(new PropertyValueFactory<>("apellido2"));
		col_Dni.setCellValueFactory(new PropertyValueFactory<>("Dni"));
		col_Rol.setCellValueFactory(new PropertyValueFactory<>("Rol"));
		col_Telefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
		
		//Definicion de la segunda tabla de campos
		col_nombreUsuario.setCellValueFactory(new PropertyValueFactory<>("NombreUsuario"));
		col_Password.setCellValueFactory(new PropertyValueFactory<>("Password"));
		col_FechaAlta.setCellValueFactory(new PropertyValueFactory<>("FechaAlta"));
		col_FechaBaja.setCellValueFactory(new PropertyValueFactory<>("FechaBaja"));
		col_paisOrigenPais.setCellValueFactory(new PropertyValueFactory<>("PaisOrigenPais"));
		
		//Definicion de tercera tabla de campos
		col_Via.setCellValueFactory(new PropertyValueFactory<>("Via"));
		col_N.setCellValueFactory(new PropertyValueFactory<>("Numero"));
		col_Piso.setCellValueFactory(new PropertyValueFactory<>("Piso"));
		col_Puerta.setCellValueFactory(new PropertyValueFactory<>("Puerta"));
		col_Localidad.setCellValueFactory(new PropertyValueFactory<>("Localidad"));
		col_Provincia.setCellValueFactory(new PropertyValueFactory<>("Provincia"));
		col_CP.setCellValueFactory(new PropertyValueFactory<>("CP"));
		col_Pais.setCellValueFactory(new PropertyValueFactory<>("Pais"));
		
		listUsuarios=listaRellenar.getSelectionModel().getSelectedItems();
		List<Miembro> listaMiembros = miembro.findMiembroEntities();
		
		SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
		String antesConversionFecha;
		Date conversionaFecha= new Date(01/01/2020);
		
		for(Miembro miembro : listaMiembros) {
			if(miembro.getDni().equals(String.valueOf(listUsuarios.get(0)))) {
				tabla1.add(new ModeloPrimeraTabla(miembro.getIdMiembro(),miembro.getNombreMiembro(),miembro.getApellido1(),miembro.getApellido2(),miembro.getDni(),miembro.getRol(),miembro.getTelefono()));
				tabla3.add(new ModeloTerceraTabla(miembro.getDireccionesUsuario().getTipoVia(),miembro.getDireccionesUsuario().getNumero(),miembro.getDireccionesUsuario().getEscalera(),miembro.getDireccionesUsuario().getPuerta(),miembro.getDireccionesUsuario().getLocalidad(),miembro.getDireccionesUsuario().getProvincia(),miembro.getDireccionesUsuario().getCp(),miembro.getDireccionesUsuario().getPais()));
				if(!(miembro.getVoluntario()==null)) {
					java.sql.Date sDate = new java.sql.Date(miembro.getVoluntario().getFechaAlta().getTime());
					java.sql.Date sDate2 = new java.sql.Date(miembro.getVoluntario().getFechaBaja().getTime());
					if (!(miembro.getVoluntario().getOrigen().isEmpty())) {
						tabla2.add(new ModeloSegundaTabla(miembro.getNombreUsuario(),miembro.getPass(),sDate,sDate2,miembro.getVoluntario().getOrigen()));
					}else {
						tabla2.add(new ModeloSegundaTabla(miembro.getNombreUsuario(),miembro.getPass(),sDate,sDate2,miembro.getVoluntario().getPaisOrigen()));
					}
						
				}else if (!(miembro.getColaborador()==null)) {
					java.sql.Date sDate = new java.sql.Date(miembro.getColaborador().getFechaAlta().getTime());
					java.sql.Date sDate2 = new java.sql.Date(miembro.getColaborador().getFechaBaja().getTime());
					tabla2.add(new ModeloSegundaTabla(miembro.getNombreUsuario(),miembro.getPass(),sDate,sDate2,""));					
				}else {
					java.sql.Date sDate = new java.sql.Date(miembro.getPersonal().getFechaAlta().getTime());
					java.sql.Date sDate2 = new java.sql.Date(miembro.getPersonal().getFechaBaja().getTime());
					tabla2.add(new ModeloSegundaTabla(miembro.getNombreUsuario(),miembro.getPass(),sDate,sDate2,""));		
				}
			}
		primeraTabla.setItems(tabla1);
		segundaTabla.setItems(tabla2);
		terceraTabla.setItems(tabla3);
		}
    }

    @FXML
    void altaMiembro(ActionEvent event) {

    }

    @FXML
    void deleteMiembro(ActionEvent event) throws NonexistentEntityException {
    	Integer i=(Integer) primeraTabla.getColumns().get(0).getCellData(0);
    	System.out.println(primeraTabla.getColumns().get(0).getCellData(0));
    	miembro=new MiembroJpaController(emf);
    	voluntario=new VoluntarioJpaController(emf);
    	colaborador=new ColaboradorJpaController(emf);
    	personal=new PersonalJpaController(emf);
    	direccion=new DireccionesUsuarioJpaController(emf);
    	try {
    		voluntario.destroy(i);
    	}catch(Exception e) {
    		
    	}
    	try {
    	colaborador.destroy(i);
    	}catch(Exception e) {
    		
    	}
    	
    	try {
    		personal.destroy(i);
    	}catch(Exception e) {
    	}
    	miembro.destroy(i);
    	direccion.destroy(i);
    }

    @FXML
    void editarMiembro(ActionEvent event) {
    	

    }

    @FXML
    void listarContratados(ActionEvent event) {
    	list.clear();
    	listaRellenar.getItems().clear();    
    	emf = Persistence.createEntityManagerFactory("persistencia2");
    	personal= new PersonalJpaController(emf);
    	miembro=new MiembroJpaController(emf);
    	List<Ong.Models.Personal> listaPersonal = personal.findPersonalEntities();
    	List<Ong.Models.Miembro> listaMiembros = miembro.findMiembroEntities();
    	//list.add(listaVoluntarios.get(1).getIdVoluntario());
    	for(int i=0;i<listaPersonal.size();i++) {
    		for(int x=0;x<listaMiembros.size();x++) {
    			if (listaMiembros.get(x).getIdMiembro()==listaPersonal.get(i).getIdPersonal()) {
    				list.add(listaMiembros.get(x).getDni());
    			}
    		}
    		
    	}
    	listaRellenar.getItems().addAll(list);
    	listaPersonal.clear();
    }

    @FXML
    void listarMiembros(ActionEvent event) {
    	//
    	list.clear();
    	listaRellenar.getItems().clear();    
    	emf = Persistence.createEntityManagerFactory("persistencia2");
    	colaborador= new ColaboradorJpaController(emf);
    	miembro=new MiembroJpaController(emf);
    	List<Ong.Models.Colaborador> listaColaboradores = colaborador.findColaboradorEntities();
    	List<Ong.Models.Miembro> listaMiembros = miembro.findMiembroEntities();
    	//list.add(listaVoluntarios.get(1).getIdVoluntario());
    	for(int i=0;i<listaColaboradores.size();i++) {
    		for(int x=0;x<listaMiembros.size();x++) {
    			if (listaMiembros.get(x).getIdMiembro()==listaColaboradores.get(i).getIdColaborador()) {
    				list.add(listaMiembros.get(x).getDni());
    			}
    		}
    		
    	}
    	listaRellenar.getItems().addAll(list);
    	listaMiembros.clear();	

    }

    @FXML
    void listarVoluntarios(ActionEvent event) {
    	list.clear();
    	listaRellenar.getItems().clear();    
    	emf = Persistence.createEntityManagerFactory("persistencia2");
    	voluntario= new VoluntarioJpaController(emf);
    	miembro=new MiembroJpaController(emf);
    	List<Ong.Models.Voluntario> listaVoluntarios = voluntario.findVoluntarioEntities();
    	List<Ong.Models.Miembro> listaMiembros = miembro.findMiembroEntities();
    	//list.add(listaVoluntarios.get(1).getIdVoluntario());
    	for(int i=0;i<listaVoluntarios.size();i++) {
    		for(int x=0;x<listaMiembros.size();x++) {
    			if (listaMiembros.get(x).getIdMiembro()==listaVoluntarios.get(i).getIdVoluntario()) {
    				list.add(listaMiembros.get(x).getDni());
    			}
    		}
    		
    	}
    	listaRellenar.getItems().addAll(list);
    	listaVoluntarios.clear();	
    }

}
