package DAO.impl;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;

import ongEC.ActualLineasAccion;
import ongEC.LineaAccion;
import ongEC.Miembros;
import ongEC.Proyecto;
import ongEC.Proyectos;
import ongEC.SubLineaAccion;

public class ProyectoDAO{
  
	public static List<Proyecto> getAll() {
		// TODO Auto-generated method stub
		 try {
		        JAXBContext context = JAXBContext.newInstance(Proyectos.class);
		        Unmarshaller unmarshaller = context.createUnmarshaller();
		        Proyectos proyectos = (Proyectos) unmarshaller.unmarshal(new File("src/main/resources/Proyecto.xml"));
		        printProyectos(proyectos);
		      } catch (JAXBException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      }
		return null;
	}

	public static void save( Proyectos t) {
		// TODO Auto-generated method stub
		try {
			File file = new File("src/main/resources/Proyecto.xml");
			JAXBContext contexto = JAXBContext.newInstance(t.getClass());
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(t, file);
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void update(Proyectos t) {
		// TODO Auto-generated method stub
		int idProyecto=0;
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		String comprobacionStr="";
		
		System.out.println("Introduce el  id de proyecto que se va a modificar");
		
		try {
			idProyecto=recuperado.nextInt();
		} catch(Exception e) {
			System.out.println("No has introducido un id de proyecto");
		  return;
		}	
		for (int i = 0;i<t.getProyecto().size();i++) {
			
			SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
			String antesConversionFecha;
			Date conversionaFecha= new Date(01/01/2020);
			List<String> listaAcciones = new ArrayList<String>();
			Integer seleccionLineaAccion;
			LineaAccion linea= new LineaAccion();
			SubLineaAccion subLineaAccion = new SubLineaAccion(); 
			List<SubLineaAccion> listaSubLineaAccion = new ArrayList<SubLineaAccion>();
			List<String>sociosLocales = new ArrayList<String>();
			int devolucionPosicionMiembro;
			Miembros miembrosNuevos= new Miembros();
			List<Miembros> miembros= new ArrayList<Miembros>();
			
			
			if (t.getProyecto().get(i).getIdProyecto()==idProyecto){
								
				System.out.println("Selecciona la opcion que quieres modificar(para salir introduzca exit)");
				System.out.println("1.IdProyecto");
				System.out.println("2.Financiacion aportada");
				System.out.println("3.Nombre de Proyecto");
				System.out.println("4.Pais");
				System.out.println("5.Localizacion");
				System.out.println("6.Financiador");
				System.out.println("7.Codigo de Proyecto");
				System.out.println("8.Acciones a Realizar");
				System.out.println("9.FechaIncio");
				System.out.println("10.FechaFin");
				System.out.println("11.Linea de Accion");
				System.out.println("12.Sub Linea de Accion");
				System.out.println("13.Socios Locales");
				System.out.println("14.Miembros Asignados");
				
				comprobacionStr=recuperado.next();
				
				while(!comprobacionStr.equals("exit")) {
					if(comprobacionStr.equals("1"))
					{
						System.out.println("Introduzca el id del proyecto");
						try {
								t.getProyecto().get(i).setIdProyecto(recuperado.nextInt());
							}
							catch(Exception e) {
								System.out.println("No has introducido un entero");
							  return;
							}
					}
					if(comprobacionStr.equals("2"))
					{
						System.out.println("Introduzca la financiacion aportada del proyecto");
						try {
							t.getProyecto().get(i).setFinanciacionAportada(recuperado.nextDouble());
						}
						catch(Exception e) {
							System.out.println("No has introducido un importe correcto");
						  return;
						}
					}
					if(comprobacionStr.equals("3"))
					{
						System.out.println("Introduzca el Nombre del proyecto");
						t.getProyecto().get(i).setNombreProyecto(recuperado.next());
					}
					if(comprobacionStr.equals("4"))
					{
						System.out.println("Introduzca el Pais del proyecto");
						t.getProyecto().get(i).setPais(recuperado.next());
					}
					if(comprobacionStr.equals("5"))
					{
						System.out.println("Introduzca la localizacion del proyecto");
						t.getProyecto().get(i).setLocalizacion(recuperado.next());
					}
					if(comprobacionStr.equals("6"))
					{
						System.out.println("Introduzca el financiador del proyecto");
						t.getProyecto().get(i).setFinanciador(recuperado.next());
					}
					if(comprobacionStr.equals("7"))
					{
						System.out.println("Introduzca el codigo del proyecto");
						t.getProyecto().get(i).setCodigoProyecto(recuperado.next());
					}
					if(comprobacionStr.equals("8"))
					{
						System.out.println("Introduzca las acciones a realizar del proyecto");
						t.getProyecto().get(i).setAccionesRealizar(recuperado.next());
					}
					if(comprobacionStr.equals("9"))
					{
						System.out.println("Introduzca la Fecha inicio del proyecto(porfavor introduzca la fecha en el siguiente formato --/--/----)");
						antesConversionFecha=recuperado.next();
						try {
							conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
						} catch (ParseException e) {
							System.out.println("Formato Fecha incorrecto");
							return;
						}
						t.getProyecto().get(i).setFechaInicio(conversionaFecha);
					}
					if(comprobacionStr.equals("10"))
					{
						System.out.println("Introduzca la Fecha Fin del proyecto(porfavor introduzca la fecha en el siguiente formato --/--/----)");
						antesConversionFecha=recuperado.next();
						try {
							conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
						} catch (ParseException e) {
							System.out.println("Formato Fecha incorrecto");
							return;
						}
						t.getProyecto().get(i).setFechaFin(conversionaFecha);
					}
					if(comprobacionStr.equals("11"))
					{
						System.out.println("Seleccione la linea de Accion");
						
						listaAcciones=ActualLineasAccion.listActions();
						for (int x = 0;x<listaAcciones.size();x++) {
							System.out.println(listaAcciones.get(x));
						}
						
						try {
							seleccionLineaAccion=recuperado.nextInt();
						} catch (Exception e) {
							System.out.println("Opcion incorrecta: " + e.getMessage());
							return;
						}
						
						
						if (seleccionLineaAccion!=null) {
							linea.getDescripcionAccion();
							linea.getDefSubLineaAccion();			
							linea.setActualLineasAccion(ActualLineasAccion.devActions(seleccionLineaAccion));
							t.getProyecto().get(i).setLineaAccion(linea);
						}
					}
					if(comprobacionStr.equals("12"))
					{
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
						t.getProyecto().get(i).getLineaAccion().setSubLineaAccion(listaSubLineaAccion);
					}
					if(comprobacionStr.equals("13"))
					{
						System.out.println("Introduzca los socios locales del proyecto(para acabar de meter socios pulse intro)");
						while(!comprobacionStr.equals("exit")) {		
						System.out.println("Introduzce el Socio Local");
						comprobacionStr=recuperado.next();
						if(!comprobacionStr.equals("exit")) {
							subLineaAccion.setDescripcion(comprobacionStr);
							sociosLocales.add(comprobacionStr);
						}
						}
						
						t.getProyecto().get(i).setSocioLocal(sociosLocales);
					}
					if(comprobacionStr.equals("14"))
					{
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
						t.getProyecto().get(i).setMiembrosAsignados(miembros);
						}
					}
				}
			}
		}
		return;
	}

	public static void delete(Proyectos t) {
		// TODO Auto-generated method stub
		int idProyecto=0;
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		
		System.out.println("Introduce el  id de proyecto que se va a borrar");
		
		try {
			idProyecto=recuperado.nextInt();
		} catch(Exception e) {
			System.out.println("No has introducido un id de proyecto");
		  return;
		}
		
		for (int i = 0;i<t.getProyecto().size();i++) {
			if (t.getProyecto().get(i).getIdProyecto()==idProyecto){
			System.out.println(t.getProyecto().get(i).getIdProyecto());
			t.getProyecto().remove(i);
			System.out.println("Borrado con exito");
			}
		}
		return;
	}
	
	private static void printProyecto(Proyecto proyecto, int i) {
		System.out.println("Proyecto " + i + ":");
		System.out.println(proyecto.getIdProyecto());
		System.out.println(proyecto.getFinanciacionAportada());
		System.out.println(proyecto.getNombreProyecto());
		System.out.println(proyecto.getPais());
		System.out.println(proyecto.getLocalizacion());
		System.out.println(proyecto.getFinanciador());
		System.out.println(proyecto.getCodigoProyecto());
		System.out.println(proyecto.getAccionesRealizar());
		System.out.println(proyecto.getFechaInicio());
		System.out.println(proyecto.getFechaFin());
		System.out.println(proyecto.getLineaAccion().getActualLineasAccion());		
		for(int x = 0; x < proyecto.getLineaAccion().getSubLineaAccion().size(); x++) {
			System.out.println(proyecto.getLineaAccion().getSubLineaAccion().get(x).getDescripcion());
		}
		for(int x = 0; x < proyecto.getSocioLocal().size(); x++) {
			System.out.println(proyecto.getSocioLocal().get(x));
		}		
		System.out.println(proyecto.getMiembrosAsignados());
		System.out.println("==============================================");	
	}
	
	private static void printProyectos(Proyectos proyectos) {
		for(int i = 0; i < proyectos.getProyecto().size(); i++) {
			printProyecto(proyectos.getProyecto().get(i), i);
		}
	}
	
	private static Proyecto setupProyecto() {
		Proyecto proyecto = new Proyecto();
		proyecto.setIdProyecto(26);
		proyecto.setFinanciacionAportada(25.0);
		proyecto.setNombreProyecto("nombreProyecto");
		proyecto.setPais("pais");
		proyecto.setLocalizacion("localizacion");
		proyecto.setFinanciador("financiador");
		proyecto.setCodigoProyecto("codigoProyecto");
		proyecto.setAccionesRealizar("accionesRealizar");
		proyecto.setFechaInicio(new Date());
		proyecto.setFechaFin(new Date());
		proyecto.setLineaAccion(new LineaAccion());
		proyecto.setSubLineaAccion(new ArrayList<SubLineaAccion>());
		proyecto.setSocioLocal(new ArrayList<String>());
		proyecto.setMiembrosAsignados(new ArrayList<Miembros>());
		return proyecto;
	}
	
	private static Proyectos setupProyectos() {
		Proyectos proyectos = new Proyectos();
		Proyecto proyecto1 = setupProyecto();
		Proyecto proyecto2 = setupProyecto();
		proyecto2.setIdProyecto(5);
		proyectos.add(proyecto1);
		proyectos.add(proyecto2);
		return proyectos;
	}
}
