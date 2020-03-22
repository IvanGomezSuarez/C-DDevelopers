package ongEC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
/*
 * esta clase contiene la informaciï¿½n de los Proyectos
 * 
 * 
 * */

public class Proyecto {
	
	//Definicion de Atributos
	
	int idProyecto;
	
	static Double financiacionAportada;
	
	String nombreProyecto;
	String pais;
	String localizacion;
	String financiador;	
	String codigoProyecto;
	String AccionesRealizar;
	
	Date fechaInicio;
	Date fechaFin;
	
	LineaAccion lineaAccion;
	
	List<SubLineaAccion> subLineaAccion;
	List<String> socioLocal;
	List<Miembros> miembrosAsignados =new ArrayList<Miembros>();
	
	//Definicion de Constructores
	
	public Proyecto(int idProyecto, String nombreProyecto, String pais, String localizacion, LineaAccion lineaAccion,
			List<SubLineaAccion> subLineaAccion, Date fechaInicio, Date fechaFin, List<String> socioLocal,
			String financiador, Double financiacionAportada, String codigoProyecto, String accionesRealizar,
			List<Miembros> miembrosAsignados) {
		super();
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
		AccionesRealizar = accionesRealizar;
		this.miembrosAsignados = miembrosAsignados;
	}

	public Proyecto() {
		super();
	}
	
	//Definicion de los Getters and Settes
	
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
		return AccionesRealizar;
	}
	
	public void setAccionesRealizar(String accionesRealizar) {
		AccionesRealizar = accionesRealizar;
	}
	
	public List<Miembros> getMiembrosAsignados() {
		return miembrosAsignados;
	}
	
	public void setMiembrosAsignados(List<Miembros> miembrosAsignados) {
		this.miembrosAsignados = miembrosAsignados;
	}
	public static void addProyecto() //Clase que añadira un nuevo proyecto
	{

		SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
		String antesConversionFecha;
		Date conversionaFecha= new Date(01/01/2020);
		Integer seleccionLineaAccion;
		String dniMiembro;
		int devolucionPosicionMiembro;
		
		SubLineaAccion subLineaAccion = new SubLineaAccion(); 
		
		List<SubLineaAccion> listaSubLineaAccion = new ArrayList<SubLineaAccion>();
		
		List<String> listaAcciones = new ArrayList<String>();;

		List<String>sociosLocales = new ArrayList<String>();
		
		List<Miembros> miembrosAsignados= new ArrayList<Miembros>();
		
		List<Miembros> miembros= new ArrayList<Miembros>();
		
		
		Miembros miembrosNuevos= new Miembros();
		
		
		Proyecto nuevoProyecto= new Proyecto(); //Definicion del nuevo proyecto
		
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		
		Integer comprobacionExisteMiembro;
		
		System.out.println("Introduzca el id del proyecto");
		nuevoProyecto.setIdProyecto(recuperado.nextInt());
		System.out.println(nuevoProyecto.idProyecto);
		
		System.out.println("Introduzca la financiacion aportada del proyecto");
		nuevoProyecto.setFinanciacionAportada(recuperado.nextDouble());
		System.out.println(nuevoProyecto.financiacionAportada);
		
		System.out.println("Introduzca el Nombre del proyecto");
		nuevoProyecto.setNombreProyecto(recuperado.next());
		System.out.println(nuevoProyecto.nombreProyecto);
		
		System.out.println("Introduzca el Pais del proyecto");
		nuevoProyecto.setPais(recuperado.next());
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
		System.out.println(nuevoProyecto.AccionesRealizar);
		
		System.out.println("Introduzca la Fecha inicio del proyecto");
		antesConversionFecha=recuperado.next();
		try {
			conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nuevoProyecto.setFechaInicio(conversionaFecha);
		System.out.println(nuevoProyecto.fechaInicio);
		
		System.out.println("Introduzca la Fecha Fin del proyecto");
		antesConversionFecha=recuperado.next();
		try {
			conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nuevoProyecto.setFechaFin(conversionaFecha);
		System.out.println(nuevoProyecto.fechaFin);
		
		System.out.println("Seleccione la linea de Accion");
		
		listaAcciones=ActualLineasAccion.listActions();
		for (int i = 0;i<listaAcciones.size();i++) {
			System.out.println(listaAcciones.get(i));
		}
	
		seleccionLineaAccion=recuperado.nextInt();
		
		
		if (seleccionLineaAccion!=null) {			
			nuevoProyecto.lineaAccion.setActualLineasAccion(ActualLineasAccion.devActions(seleccionLineaAccion));
		}
		
		System.out.println("Introduzca las sub linea de accion del proyecto(para acabar de meter sublineas pulse intro)");
		while(recuperado!=null) {
		System.out.println("Introduzca la sublinea");
		subLineaAccion.setDescripcion(recuperado.next());
		listaSubLineaAccion.add(subLineaAccion);
		}
		nuevoProyecto.setSubLineaAccion(listaSubLineaAccion);
		
		System.out.println("Introduzca los socios locales del proyecto(para acabar de meter socios pulse intro)");
		while(recuperado!=null) {
		System.out.println("Introduzce el Socio Local");
		sociosLocales.add(recuperado.next());
		}		
		nuevoProyecto.setSocioLocal(sociosLocales);
		
		System.out.println("Introduzca los dni de los Miembos asignados al proyecto(para acabar de introducir miembros pulse intro)");
		while(recuperado!=null) {
		System.out.println("Introduzce el Dni del miembro");
		dniMiembro=recuperado.next();
		devolucionPosicionMiembro=miembrosNuevos.comprobarMiembro(dniMiembro);
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
		}
		nuevoProyecto.setMiembrosAsignados(miembros);
	}
}
