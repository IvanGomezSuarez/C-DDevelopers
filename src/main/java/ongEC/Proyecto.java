package ongEC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * esta clase contiene la informacón de los Proyectos
 * 
 * 
 * */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.junit.Test;


@XmlRootElement(name = "Proyecto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Proyecto {
	
	// Definicion de Atributos
	@XmlElement(name = "IdProyecto")
	private int idProyecto;
	@XmlElement(name = "FinanciacionAportada")
	private Double financiacionAportada;
	@XmlElement(name = "NombreProyecto")
	private String nombreProyecto;
	@XmlElement(name = "Pais")
	private String pais;
	@XmlElement(name = "Localizacion")
	private String localizacion;
	@XmlElement(name = "Financiador")
	private String financiador;
	@XmlElement(name = "CodigoProyecto")
	private String codigoProyecto;
	@XmlElement(name = "AccionesRealizar")
	private String accionesRealizar;
	@XmlElement(name = "FechaInicio")
	private Date fechaInicio;
	@XmlElement(name = "FechaFin")
	private Date fechaFin;
	@XmlElement(name = "LineaAccion")
	private LineaAccion lineaAccion;
	@XmlElement(name = "SubLineaAccion")
	private List<SubLineaAccion> subLineaAccion;
	@XmlElement(name = "SocioLocal")
	private List<String> socioLocal;
	@XmlElement(name = "MiembrosAsignados")
	private List<Miembros> miembrosAsignados =new ArrayList<Miembros>();
	
	// Definicion de Constructores
	public Proyecto() {
		// Empty constructor
	}
	
	public Proyecto(int idProyecto, String nombreProyecto, String pais, String localizacion, LineaAccion lineaAccion,
			List<SubLineaAccion> subLineaAccion, Date fechaInicio, Date fechaFin, List<String> socioLocal,
			String financiador, Double financiacionAportada, String codigoProyecto, String accionesRealizar,
			List<Miembros> miembrosAsignados) {
		this.idProyecto = idProyecto;
		this.nombreProyecto = nombreProyecto;
		this.pais = pais;
		this.localizacion = localizacion;
		this.lineaAccion = lineaAccion;
		this.subLineaAccion = subLineaAccion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.socioLocal = socioLocal;
		this.financiador = financiador;
		this.financiacionAportada = financiacionAportada;
		this.codigoProyecto = codigoProyecto;
		this.accionesRealizar = accionesRealizar;
		this.miembrosAsignados = miembrosAsignados;
	}
	
	// Definicion de los Getters and Settes
	public int getIdProyecto() {
		return idProyecto;
	}
	
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getLocalizacion() {
		return localizacion;
	}
	
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
	public LineaAccion getLineaAccion() {
		return lineaAccion;
	}
	
	public void setLineaAccion(LineaAccion lineaAccion) {
		this.lineaAccion = lineaAccion;
	}
	
	public List<SubLineaAccion> getSubLineaAccion() {
		return subLineaAccion;
	}
	
	public void setSubLineaAccion(List<SubLineaAccion> subLineaAccion) {
		this.subLineaAccion = subLineaAccion;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public List<String> getSocioLocal() {
		return socioLocal;
	}
	
	public void setSocioLocal(List<String> socioLocal) {
		this.socioLocal = socioLocal;
	}
	
	public String getFinanciador() {
		return financiador;
	}
	
	public void setFinanciador(String financiador) {
		this.financiador = financiador;
	}
	
	public Double getFinanciacionAportada() {
		return financiacionAportada;
	}
	
	public void setFinanciacionAportada(Double financiacionAportada) {
		this.financiacionAportada = financiacionAportada;
	}
	
	public String getCodigoProyecto() {
		return codigoProyecto;
	}
	
	public void setCodigoProyecto(String codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}
	
	public String getAccionesRealizar() {
		return accionesRealizar;
	}
	
	public void setAccionesRealizar(String accionesRealizar) {
		this.accionesRealizar = accionesRealizar;
	}
	
	public List<Miembros> getMiembrosAsignados() {
		return miembrosAsignados;
	}
	
	public void setMiembrosAsignados(List<Miembros> miembrosAsignados) {
		this.miembrosAsignados = miembrosAsignados;
	}
	
	public static Proyecto addProyecto() //Clase que añadira un nuevo proyecto
	{
		//Definimos Atributos
		
		SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
		String antesConversionFecha;
		Date conversionaFecha= new Date(01/01/2020);
		Integer seleccionLineaAccion;
		String dniMiembro;
		int devolucionPosicionMiembro;
		String comprobacionStr="";
		String textoGuardado="";
		
		
		SubLineaAccion subLineaAccion = new SubLineaAccion(); 
		
		List<SubLineaAccion> listaSubLineaAccion = new ArrayList<SubLineaAccion>();
		
		List<String> listaAcciones = new ArrayList<String>();;

		List<String>sociosLocales = new ArrayList<String>();
		
		List<Miembros> miembrosAsignados= new ArrayList<Miembros>();
		
		List<Miembros> miembros= new ArrayList<Miembros>();
		
		LineaAccion linea= new LineaAccion();
		
		Miembros miembrosNuevos= new Miembros();
		
		Proyecto nuevoProyecto= new Proyecto(); //Definicion del nuevo proyecto
		
		LineaAccion nuevaLineaAccion=new LineaAccion(); //Nueva Linea de Accion
		
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		
		//Solicitamos los datos al usuario del nuevo proyecto con sus comprobaciones de errores
		System.out.println("Introduzca el id del proyecto");
		try {
				nuevoProyecto.setIdProyecto(recuperado.nextInt());
			}
			catch(Exception e) {
				System.out.println("No has introducido un entero");
			  return null;
			}
		System.out.println(nuevoProyecto.idProyecto);
		
		System.out.println("Introduzca la financiacion aportada del proyecto");
		try {
			nuevoProyecto.setFinanciacionAportada(recuperado.nextDouble());
		}
		catch(Exception e) {
			System.out.println("No has introducido un importe correcto");
		  return null;
		}
		System.out.println(nuevoProyecto.financiacionAportada);
		System.out.println("Introduzca el Nombre del proyecto");
		textoGuardado=recuperado.next();
		nuevoProyecto.setNombreProyecto(textoGuardado);
		System.out.println(nuevoProyecto.nombreProyecto);
		
		System.out.println("Introduzca el Pais del proyecto");
		textoGuardado=recuperado.next();
		nuevoProyecto.setPais(textoGuardado);
		System.out.println(nuevoProyecto.pais);
		
		System.out.println("Introduzca la localizacion del proyecto");
		nuevoProyecto.setLocalizacion(recuperado.next());
		System.out.println(nuevoProyecto.localizacion);
		
		System.out.println("Introduzca el financiador del proyecto");
		nuevoProyecto.setFinanciador(recuperado.next());
		System.out.println(nuevoProyecto.financiador);
		
		System.out.println("Introduzca el codigo del proyecto");
		nuevoProyecto.setCodigoProyecto(recuperado.next());
		System.out.println(nuevoProyecto.codigoProyecto);
		
		System.out.println("Introduzca las acciones a realizar del proyecto");
		nuevoProyecto.setAccionesRealizar(recuperado.next());
		System.out.println(nuevoProyecto.getAccionesRealizar());
		
		System.out.println("Introduzca la Fecha inicio del proyecto(porfavor introduzca la fecha en el siguiente formato --/--/----)");
		antesConversionFecha=recuperado.next();
		try {
			conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
		} catch (ParseException e) {
			System.out.println("Formato Fecha incorrecto");
			return null;
		}
		nuevoProyecto.setFechaInicio(conversionaFecha);
		System.out.println(nuevoProyecto.fechaInicio);
		
		System.out.println("Introduzca la Fecha Fin del proyecto(porfavor introduzca la fecha en el siguiente formato --/--/----)");
		antesConversionFecha=recuperado.next();
		try {
			conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
		} catch (ParseException e) {
			System.out.println("Formato Fecha incorrecto");
			return null;
		}
		nuevoProyecto.setFechaFin(conversionaFecha);
		System.out.println(nuevoProyecto.fechaFin);
		
		System.out.println("Seleccione la linea de Accion");
		
		listaAcciones=ActualLineasAccion.listActions();
		for (int i = 0;i<listaAcciones.size();i++) {
			System.out.println(listaAcciones.get(i));
		}
		
		try {
			seleccionLineaAccion=recuperado.nextInt();
		} catch (Exception e) {
			System.out.println("Opcion incorrecta: " + e.getMessage());
			return null;
		}
		
		
		if (seleccionLineaAccion!=null) {
			linea.getDescripcionAccion();
			linea.getDefSubLineaAccion();			
			linea.setActualLineasAccion(ActualLineasAccion.devActions(seleccionLineaAccion));
			nuevoProyecto.setLineaAccion(linea);
		}

		System.out.println("Introduzca las sub linea de accion del proyecto(para acabar de meter sublineas escriba exit)");
		while(!comprobacionStr.equals("exit")) {
			subLineaAccion = new SubLineaAccion(); 
			System.out.println("Introduzca la sublinea");		
			comprobacionStr=recuperado.next();
			if(!comprobacionStr.equals("exit")) {
				subLineaAccion.setDescripcion(comprobacionStr);
				listaSubLineaAccion.add(subLineaAccion);
			}
		}
		
		//nuevoProyecto.getLineaAccion().setSubLineaAccion(listaSubLineaAccion);
		//nuevoProyecto.setSubLineaAccion(listaSubLineaAccion);
		nuevoProyecto.getLineaAccion().setSubLineaAccion(listaSubLineaAccion);
		
		comprobacionStr="";
		
		System.out.println("Introduzca los socios locales del proyecto(para acabar de meter socios pulse intro)");
		while(!comprobacionStr.equals("exit")) {		
		System.out.println("Introduzce el Socio Local");
		comprobacionStr=recuperado.next();
		if(!comprobacionStr.equals("exit")) {
			subLineaAccion.setDescripcion(comprobacionStr);
			sociosLocales.add(comprobacionStr);
		}
		}
		
		nuevoProyecto.setSocioLocal(sociosLocales);
		
		comprobacionStr="";
		
		System.out.println("Introduzca los dni de los Miembos asignados al proyecto(para acabar de introducir miembros pulse intro)");
		while(!comprobacionStr.equals("exit")) {
		System.out.println("Introduzce el Dni del miembro");
		comprobacionStr=recuperado.next();
		devolucionPosicionMiembro=miembrosNuevos.comprobarMiembro(comprobacionStr);
		if (devolucionPosicionMiembro!=0) {
			miembros.get(devolucionPosicionMiembro).getDni();
			miembros.get(devolucionPosicionMiembro).getApellido1();
			miembros.get(devolucionPosicionMiembro).getApellido2();
			miembros.get(devolucionPosicionMiembro).getIdMiembro();
			miembros.get(devolucionPosicionMiembro).getNombreMiembro();
			miembros.get(devolucionPosicionMiembro).getPass();
			miembros.get(devolucionPosicionMiembro).getNomUsuario();
			miembros.get(devolucionPosicionMiembro).getTelefono();
		}
		nuevoProyecto.setMiembrosAsignados(miembros);
		}
		return(nuevoProyecto);
	}
	

	public static void modProyecto() { //Clase que modifcara un proyecto	
		int idProyecto=0;
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		System.out.println("Introduce el  id de proyecto que se va a Modificar");
		
		try {
			idProyecto=recuperado.nextInt();
		} catch(Exception e) {
			System.out.println("No has introducido un id de proyecto");
		  return;
		}
		System.out.println("Modificamos el proyecto");
	}
	
    List<Proyecto> proyectos;
    
    public List<Proyecto> getProyectos(){
        return proyectos;
    }

	public List<Proyecto> getProyecto() {
		// TODO Auto-generated method stub
		return null;
	}
}
