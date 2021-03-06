package DAO.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
import ongEC.Delegaciones;
import ongEC.LineaAccion;
import ongEC.Miembro;
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

	public static void update(Proyectos t, Miembros m) throws IOException {
		// TODO Auto-generated method stub
		int idProyecto=0;
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		String comprobacionStr="";
		SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
		String antesConversionFecha;
		Date conversionaFecha= new Date(01/01/2020);
		List<String> listaAcciones = new ArrayList<String>();
		Integer seleccionLineaAccion;
		LineaAccion linea= new LineaAccion();
		SubLineaAccion subLineaAccion = new SubLineaAccion(); 
		List<SubLineaAccion> listaSubLineaAccion = new ArrayList<SubLineaAccion>();
		List<String>sociosLocales = new ArrayList<String>();
		int recuperadoInt;
		Miembro miembrosNuevos= new Miembro();
		List<Miembro> miembro= new ArrayList<Miembro>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Miembro miembroAgregar=new Miembro();
		List<Miembro> miembrosAsignados= new ArrayList<Miembro>();
		
		System.out.println("Introduce el  id de proyecto que se va a modificar");
		
		try {
			idProyecto=recuperado.nextInt();
		} catch(Exception e) {
			System.out.println("No has introducido un id de proyecto");
		  return;
		}
		if(t.getProyecto()!=null) {
		for (int i = 0;i<t.getProyecto().size();i++) {
			if (t.getProyecto().get(i).getIdProyecto()==idProyecto){											
				while(!comprobacionStr.equals("exit")) {
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
					if(comprobacionStr.equals("1"))
					{
						System.out.println("Introduzca el id del proyecto");
						recuperadoInt=recuperado.nextInt();
						for (int x = 0;x<t.getProyecto().size();x++) {
							if (t.getProyecto().get(x).getIdProyecto()==(recuperadoInt)){
								System.out.println("\n ID REPETIDO ");
								return;
							}
						}
						try {
							t.getProyecto().get(i).setIdProyecto(recuperadoInt);
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
						t.getProyecto().get(i).setNombreProyecto(br.readLine());
					}
					if(comprobacionStr.equals("4"))
					{
						System.out.println("Introduzca el Pais del proyecto");
						t.getProyecto().get(i).setPais(br.readLine());
					}
					if(comprobacionStr.equals("5"))
					{
						System.out.println("Introduzca la localizacion del proyecto");
						t.getProyecto().get(i).setLocalizacion(br.readLine());
					}
					if(comprobacionStr.equals("6"))
					{
						System.out.println("Introduzca el financiador del proyecto");
						t.getProyecto().get(i).setFinanciador(br.readLine());
					}
					if(comprobacionStr.equals("7"))
					{
						System.out.println("Introduzca el codigo del proyecto");
						t.getProyecto().get(i).setCodigoProyecto(br.readLine());
					}
					if(comprobacionStr.equals("8"))
					{
						System.out.println("Introduzca las acciones a realizar del proyecto");
						t.getProyecto().get(i).setAccionesRealizar(br.readLine());
					}
					if(comprobacionStr.equals("9"))
					{
						System.out.println("Introduzca la Fecha inicio del proyecto(porfavor introduzca la fecha en el siguiente formato --/--/----)");
						antesConversionFecha=br.readLine();
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
						antesConversionFecha=br.readLine();
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
							comprobacionStr=br.readLine();
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
						comprobacionStr=br.readLine();
						if(!comprobacionStr.equals("exit")) {
							subLineaAccion.setDescripcion(comprobacionStr);
							sociosLocales.add(comprobacionStr);
						}
						}
						
						t.getProyecto().get(i).setSocioLocal(sociosLocales);
					}
					if(comprobacionStr.equals("14"))
					{
						System.out.println("Introduzca los IDS de los Miembos asignados al proyecto(para acabar de introducir miembros pulse intro)");
						while(!comprobacionStr.equals("exit")) {
							System.out.println("Introduzce el ID del miembro");
							comprobacionStr=br.readLine();
							for (int j = 0;j<m.getMiembro().size();j++) {
								if (m.getMiembro().get(j).getIdMiembro().equals(comprobacionStr)){
									miembroAgregar=m.getMiembro().get(j);
									miembrosAsignados.add(miembroAgregar);
								}					
							}		
						}
						t.getProyecto().get(i).setMiembrosAsignados(miembrosAsignados);
					}
				}
			}
		}
	}else {
		System.out.println("Archivo Vacio");
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
		
			if(t.getProyecto()!=null){
				for (int i = 0;i<t.getProyecto().size();i++) {
				if (t.getProyecto().get(i).getIdProyecto()==idProyecto){
				System.out.println(t.getProyecto().get(i).getIdProyecto());
				t.getProyecto().remove(i);
				System.out.println("Borrado con exito");
				}
			}
		}else {
			System.out.println("Archivo Vacio");
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
		for(int x = 0; x < proyecto.getMiembrosAsignados().size(); x++) {
			System.out.println("Nombre :" + proyecto.getMiembrosAsignados().get(x).getNombreMiembro());
			System.out.println("Apellido 1 :" + proyecto.getMiembrosAsignados().get(x).getApellido1());
			System.out.println("Apellido 2 :" + proyecto.getMiembrosAsignados().get(x).getApellido2());
		}
		System.out.println("==============================================");	
	}
	
	private static void printProyectos(Proyectos proyectos) {
		if(proyectos.getProyecto()!=null){
			for(int i = 0; i < proyectos.getProyecto().size(); i++) {
				printProyecto(proyectos.getProyecto().get(i), i);
			}
		}else {		
		System.out.println("Archivo Vacio");			
		}
	}
	public static Proyecto addProyecto(Proyectos t,Miembros m) throws IOException //Clase que a�adira un nuevo proyecto�
	{
		//Definimos Atributos
		
		SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
		String antesConversionFecha;
		Date conversionaFecha= new Date(01/01/2020);
		Integer seleccionLineaAccion;
		String dniMiembro;
		int devolucionPosicionMiembro;
		String comprobacionStr="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Miembro miembroAgregar=new Miembro();
		
		SubLineaAccion subLineaAccion = new SubLineaAccion(); 
		
		List<SubLineaAccion> listaSubLineaAccion = new ArrayList<SubLineaAccion>();
		
		List<String> listaAcciones = new ArrayList<String>();;

		List<String>sociosLocales = new ArrayList<String>();
		
		List<Miembro> miembrosAsignados= new ArrayList<Miembro>();
		
		List<Miembro> miembro= new ArrayList<Miembro>();
		
		LineaAccion linea= new LineaAccion();
		
		Miembro miembrosNuevos= new Miembro();
		
		Proyecto nuevoProyecto= new Proyecto(); //Definicion del nuevo proyecto
		
		LineaAccion nuevaLineaAccion=new LineaAccion(); //Nueva Linea de Accion
		
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		
		//Solicitamos los datos al usuario del nuevo proyecto con sus comprobaciones de errores
		System.out.println("Introduzca el ID del proyecto");
		
		try {
				nuevoProyecto.setIdProyecto(recuperado.nextInt());
			}
			catch(Exception e) {
				System.out.println("No has introducido un entero");
			  return null;
			}
		if (t.getProyecto()!=null) {
			for (int x = 0;x<t.getProyecto().size();x++) {
				if (t.getProyecto().get(x).getIdProyecto()==(nuevoProyecto.getIdProyecto())){
					System.out.println("\n ID REPETIDO ");
					return null;
				}
			}
		}
		System.out.println("Introduzca la financiacion aportada del proyecto");
		try {
			nuevoProyecto.setFinanciacionAportada(recuperado.nextDouble());
		}
		catch(Exception e) {
			System.out.println("No has introducido un importe correcto");
		  return null;
		}
		
		System.out.println("Introduzca el Nombre del proyecto");
		nuevoProyecto.setNombreProyecto(br.readLine());
		
		System.out.println("Introduzca el Pais del proyecto");
		nuevoProyecto.setPais(br.readLine());
		
		System.out.println("Introduzca la localizacion del proyecto");
		nuevoProyecto.setLocalizacion(br.readLine());
		
		System.out.println("Introduzca el financiador del proyecto");
		nuevoProyecto.setFinanciador(br.readLine());
		
		System.out.println("Introduzca el codigo del proyecto");
		nuevoProyecto.setCodigoProyecto(br.readLine());
		
		System.out.println("Introduzca las acciones a realizar del proyecto");
		nuevoProyecto.setAccionesRealizar(br.readLine());
		System.out.println(nuevoProyecto.getAccionesRealizar());
		
		System.out.println("Introduzca la Fecha inicio del proyecto(porfavor introduzca la fecha en el siguiente formato --/--/----)");
		antesConversionFecha=br.readLine();
		try {
			conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
		} catch (ParseException e) {
			System.out.println("Formato Fecha incorrecto");
			return null;
		}
		nuevoProyecto.setFechaInicio(conversionaFecha);
		
		System.out.println("Introduzca la Fecha Fin del proyecto(porfavor introduzca la fecha en el siguiente formato --/--/----)");
		antesConversionFecha=br.readLine();
		try {
			conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
		} catch (ParseException e) {
			System.out.println("Formato Fecha incorrecto");
			return null;
		}
		nuevoProyecto.setFechaFin(conversionaFecha);
		
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
			comprobacionStr=br.readLine();
			if(!comprobacionStr.equals("exit")) {
				subLineaAccion.setDescripcion(comprobacionStr);
				listaSubLineaAccion.add(subLineaAccion);
			}
		}
		nuevoProyecto.getLineaAccion().setSubLineaAccion(listaSubLineaAccion);
		
		comprobacionStr="";
		
		System.out.println("Introduzca los socios locales del proyecto(para acabar de meter socios pulse intro)");
		while(!comprobacionStr.equals("exit")) {		
		System.out.println("Introduzce el Socio Local");
		comprobacionStr=br.readLine();
		if(!comprobacionStr.equals("exit")) {
			subLineaAccion.setDescripcion(comprobacionStr);
			sociosLocales.add(comprobacionStr);
		}
		}	
		nuevoProyecto.setSocioLocal(sociosLocales);	
		comprobacionStr="";		
		System.out.println("Introduzca los dni de los Miembos asignados al proyecto(para acabar de introducir miembros pulse intro)");
		while(!comprobacionStr.equals("exit")) {
			System.out.println("Introduzce el ID del miembro");
			comprobacionStr=br.readLine();
			for (int j = 0;j<m.getMiembro().size();j++) {
				if (m.getMiembro().get(j).getIdMiembro().equals(comprobacionStr)){
					miembroAgregar=m.getMiembro().get(j);
					miembrosAsignados.add(miembroAgregar);
				}					
			}		
		}

		nuevoProyecto.setMiembrosAsignados(miembrosAsignados);
		return(nuevoProyecto);
		}
	
	public static Proyectos readfirst() {
		// TODO Auto-generated method stub
		 try {
		        JAXBContext context = JAXBContext.newInstance(Proyectos.class);
		        Unmarshaller unmarshaller = context.createUnmarshaller();
		        Proyectos proyectos = (Proyectos) unmarshaller.unmarshal(new File("src/main/resources/Proyecto.xml"));
		        return(proyectos);
		      } catch (JAXBException e) {
		        // TODO Auto-generated catch block
		    	  System.out.println("No hay ningun registro");
		        e.printStackTrace();
		      }
		return null;
	}
}
    
