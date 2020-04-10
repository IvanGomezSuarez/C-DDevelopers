package DAO.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import ongEC.Colaborador;
import ongEC.Direccion;
import ongEC.Internacional;
import ongEC.Miembro;
import ongEC.Miembros;
import ongEC.Nacional;
import ongEC.Personal;
import ongEC.Voluntario;

public class MiembroDAO{
  
	public static List<Miembro> getAll() {
		// TODO Auto-generated method stub
		 try {
		        JAXBContext context = JAXBContext.newInstance(Miembros.class);
		        Unmarshaller unmarshaller = context.createUnmarshaller();
		        Miembros miembros = (Miembros) unmarshaller.unmarshal(new File("src/main/resources/Miembros.xml"));
		        printMiembros(miembros);
		      } catch (JAXBException e) {
		        // TODO Auto-generated catch block
		    	  System.out.println("No hay ningun registro");
		        e.printStackTrace();
		      }
		return null;
	}

	public static void save(Miembros t) {
		// TODO Auto-generated method stub
		try {
			File file = new File("src/main/resources/Miembros.xml");
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

	public static void update(Miembros t) throws IOException, SQLException {
		// TODO Auto-generated method stub
		String idProyecto="";
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		String comprobacionStr="";
		int seleccion;
		
		System.out.println("Introduce el ID miembro que se va a modificar");
		
		try {
			idProyecto=recuperado.next();
		} catch(Exception e) {
			System.out.println("No has introducido un id de miembro");
		  return;
		}	
		if(t.getMiembro()!=null) {
		for (int i = 0;i<t.getMiembro().size();i++) {
			
				if (t.getMiembro().get(i).getIdMiembro().equals(idProyecto)){											
					while(!comprobacionStr.equals("exit")) {
						System.out.println("Selecciona la opcion que quieres modificar(para salir introduzca exit)");
						System.out.println("1.Idmiembro");
						System.out.println("2.Nombre");
						System.out.println("3.Apellido1");
						System.out.println("4.Apellido2");
						System.out.println("5.DNI");
						System.out.println("6.Direccion");
						System.out.println("7.Rol");
						System.out.println("8.Telefono");
						System.out.println("9.Usuario");
						System.out.println("10.Contraseña");
						System.out.println("11.Tipo Usuario");
						comprobacionStr=recuperado.next();
						if(comprobacionStr.equals("1"))
						{
							System.out.println("Introduzca el id del Miembro");
							comprobacionStr=recuperado.next();
							for (int x = 0;x<t.getMiembro().size();x++) {
								if (t.getMiembro().get(x).getIdMiembro()==(comprobacionStr)){
									System.out.println("\n ID REPETIDO ");
									return;
								}
							}
							try {
									t.getMiembro().get(i).setIdMiembro(recuperado.next());
								}
								catch(Exception e) {
									System.out.println("No has introducido un String");
								  return;
								}
						}
						if(comprobacionStr.equals("2"))
						{
							System.out.println("Introduzca el Nombre");
							try {
								t.getMiembro().get(i).setNombreMiembro(recuperado.next());
							}
							catch(Exception e) {
								System.out.println("No has introducido un String");
							  return;
							}
						}
						if(comprobacionStr.equals("3"))
						{
							System.out.println("Introduzca el Apellido 1");
							t.getMiembro().get(i).setApellido1(recuperado.next());
						}
						if(comprobacionStr.equals("4"))
						{
							System.out.println("Introduzca el Apellido 2");
							t.getMiembro().get(i).setApellido2(recuperado.next());
						}
						if(comprobacionStr.equals("5"))
						{
							System.out.println("Introduzca el DNI");
							t.getMiembro().get(i).setDni(recuperado.next());
						}
						if(comprobacionStr.equals("6"))
						{
							System.out.println("Introduzca la direccion");
							t.getMiembro().get(i).setDireccion(Direccion.addDireccion());
						}
						if(comprobacionStr.equals("7"))
						{
							System.out.println("\nIntroduce el Rol del usuario: ");
							System.out.println("\n1.Usuario Normal: ");
							System.out.println("\n2.Usuario Admin: ");
							seleccion=recuperado.nextInt();
							if (seleccion==1) {
								t.getMiembro().get(i).setRol("Normal");
							}else if (seleccion==2) {
								t.getMiembro().get(i).setRol("Admin");
							}else {
								System.out.println("Opcion No valida ");
							}
						}
						if(comprobacionStr.equals("8"))
						{
							System.out.println("Introduzca el Telefono");
							t.getMiembro().get(i).setTelefono(recuperado.next());
						}
						if(comprobacionStr.equals("9"))
						{
							System.out.println("Introduzca el Usuario");
							t.getMiembro().get(i).setNombreUsuario(recuperado.next());
						}
						if(comprobacionStr.equals("10"))
						{
							System.out.println("Introduzca la Contraseña");
							t.getMiembro().get(i).setPassword(recuperado.next());
						}
						if(comprobacionStr.equals("11"))
						{
							System.out.println("\nIntroduce el Tipo de usuario que va a ser: ");
							System.out.println("\n1.Persona Contratada: ");
							System.out.println("\n2.Voluntario: ");
							System.out.println("\n3.Colaborador: ");
							seleccion=recuperado.nextInt();
							if (seleccion==1) {
								t.getMiembro().get(i).setPersonal(addPersonal());
							}else if (seleccion==2) {
								t.getMiembro().get(i).setVoluntario(addVoluntario());
							}else if (seleccion==3) {
								t.getMiembro().get(i).setColaborador(addColaborador());
							}else
								System.out.println("Opcion No valida ");
						}
					}
					System.out.println("Despues del while actualizamos"+ i);
					MySqlMiembroDAOYosu.updateMiembroDAOMysql(t.getMiembro().get(i));
				}
			}
		}else {
		System.out.println("Archivo Vacio");
		}
}

	public static void delete(Miembros t) {
		// TODO Auto-generated method stub
		String idMiembro="";
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		
		System.out.println("Introduce el  id del miembro que se va a borrar");
		
		try {
			idMiembro=recuperado.next();
		} catch(Exception e) {
			System.out.println("No has introducido un id de miembro");
		  return;
		}
		if(t.getMiembro()!=null) {
			for (int i = 0;i<t.getMiembro().size();i++) {
				if (t.getMiembro().get(i).getIdMiembro().equals(idMiembro)){
					System.out.println(t.getMiembro().get(i).getIdMiembro());
					t.getMiembro().remove(i);
					System.out.println("Borrado con exito");
				}
			}
		}else {
			System.out.println("Archivo Vacio");			
		}
		return;
	}
	
	private static void printMiembro(Miembro miembro, int i) {
		System.out.println("IdMiembro " + i + ":"+ miembro.getIdMiembro());
		System.out.println("Nombre:" + miembro.getNombreMiembro());
		System.out.println("Apellido1:" + miembro.getApellido1());
		System.out.println("Apellido2;"+ miembro.getApellido2());
		System.out.println("Dni:"+ Miembro.getDni());
		System.out.println("Via:"+ miembro.getDireccion().getTipoVia());
		System.out.println("Puerta:"+ miembro.getDireccion().getPuerta());
		System.out.println("Escalera::"+ miembro.getDireccion().getEscalera());
		System.out.println("Localidad:"+ miembro.getDireccion().getLocalidad());
		System.out.println("Provincia:"+ miembro.getDireccion().getProvincia());
		System.out.println("Pais:"+ miembro.getDireccion().getPais());
		System.out.println("CP:"+ miembro.getDireccion().getCp());
		System.out.println("Rol:"+ miembro.getRol());
		System.out.println("Telefono;"+ miembro.getTelefono());
		System.out.println("Nombre usuario:"+ miembro.getNombreUsuario());
		System.out.println("Nombre Contraseña:"+ miembro.getPassword());
		if(miembro.getVoluntario()!=null) {
			System.out.println("Fecha Alta:"+ miembro.getVoluntario().getFechaAlta());
			System.out.println("Fecha Baja:"+ miembro.getVoluntario().getFechaBaja());
			if(miembro.getVoluntario().getNacional()!=null) {
				System.out.println("Tipo de Voluntario:"+ miembro.getVoluntario().getNacional().getOrigen());
			}else {
				System.out.println("Tipo de Voluntario:"+ miembro.getVoluntario().getInternacional().getPaisOrigen());
			}
		}else if (miembro.getColaborador()!=null) {
			System.out.println("Fecha Alta::"+ miembro.getColaborador().getFechaAlta());
			System.out.println("Fecha Baja:"+ miembro.getColaborador().getFechaBaja());
		}else if(miembro.getPersonal()!=null){
			System.out.println("Fecha Alta:"+ miembro.getPersonal().getFechaAlta());
			System.out.println("Fecha Baja:"+ miembro.getPersonal().getFechaBaja());
		}	
		System.out.println("==============================================");	
	}
	
	private static void printMiembros(Miembros miembros) {
		
		if(miembros.getMiembro()!=null) {
			for(int i = 0; i < miembros.getMiembro().size(); i++) {
				printMiembro(miembros.getMiembro().get(i), i);
			}
		}else{
			System.out.println("Archivo Vacio");			
		}
	}
	
	public static Miembros readfirst() {
		// TODO Auto-generated method stub
		 try {
		        JAXBContext context = JAXBContext.newInstance(Miembros.class);
		        Unmarshaller unmarshaller = context.createUnmarshaller();
		        Miembros miembros = (Miembros) unmarshaller.unmarshal(new File("src/main/resources/Miembros.xml"));
		        return(miembros);
		      } catch (JAXBException e) {
		        // TODO Auto-generated catch block
		    	  System.out.println("No hay ningun registro");
		        e.printStackTrace();
		      }
		return null;
	}
	
	public static Miembro addMiembro(Miembros t) throws IOException, JAXBException {
		Miembro nuevoMiembro = new Miembro();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		int seleccion;
		
		
		System.out.println("\nIntroduce el ID del miembro: ");
		nuevoMiembro.setIdMiembro(br.readLine());
		if(t.getMiembro()!=null) {
		for (int i = 0;i<t.getMiembro().size();i++) {
			if (t.getMiembro().get(i).getIdMiembro().equals(nuevoMiembro.getIdMiembro())){
				System.out.println("\n ID REPETIDO ");
				return null;
			}
		}
		}
		System.out.println("\nIntroduce el nombre del miembro: ");
		nuevoMiembro.setNombreMiembro(br.readLine());
		System.out.println("\nIntroduce el primer apellido del miembro: ");
		nuevoMiembro.setApellido1(br.readLine());
		System.out.println("\nIntroduce el segundo apellido del trabajador: ");
		nuevoMiembro.setApellido2(br.readLine());
		System.out.println("\nIntroduce el DNI del miembro: ");
		nuevoMiembro.setDni(br.readLine());
		System.out.println("\nIntroduce la direccion de su domicilio: ");
		nuevoMiembro.setDireccion(Direccion.addDireccion());
		System.out.println("\nIntroduce el numero de movil del miembro: ");
		nuevoMiembro.setTelefono(br.readLine());
		System.out.println("\nIntroduce el nombre que desee como usuario: ");
		nuevoMiembro.setNombreUsuario(br.readLine());
		System.out.println("\nIntroduce tu contraseña: ");
		nuevoMiembro.setPassword(br.readLine());
		System.out.println("\nIntroduce el Rol del usuario: ");
		System.out.println("\n1.Usuario Normal: ");
		System.out.println("\n2.Usuario Admin: ");
		seleccion=recuperado.nextInt();
		if (seleccion==1) {
			nuevoMiembro.setRol("Normal");
		}else if (seleccion==2) {
			nuevoMiembro.setRol("Admin");
		}else {
			System.out.println("Opcion No valida ");
		}
		System.out.println("\nIntroduce el Tipo de usuario que va a ser: ");
		System.out.println("\n1.Persona Contratada: ");
		System.out.println("\n2.Voluntario: ");
		System.out.println("\n3.Colaborador: ");
		seleccion=recuperado.nextInt();
		if (seleccion==1) {
			nuevoMiembro.setPersonal(addPersonal());
		}else if (seleccion==2) {
			nuevoMiembro.setVoluntario(addVoluntario());
		}else if (seleccion==3) {
			nuevoMiembro.setColaborador(addColaborador());
		}else
			System.out.println("Opcion No valida ");
		
		return nuevoMiembro;

	}
	
	public static Personal addPersonal() throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Personal personal=new Personal();
			SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
			String antesConversionFecha;
			Date conversionaFecha= new Date(01/01/2020);
			
			System.out.println("Introduzca la Fecha De alta del Contrato(porfavor introduzca la fecha en el siguiente formato --/--/----)");
			antesConversionFecha=br.readLine();
			try {
				conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
			} catch (ParseException e) {
				System.out.println("Formato Fecha incorrecto");
				return null;
			}
			personal.setFechaAlta(conversionaFecha);
			
			System.out.println("Introduzca la Fecha Fin del Contrato(porfavor introduzca la fecha en el siguiente formato --/--/----)");
			antesConversionFecha=br.readLine();
			try {
				conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
			} catch (ParseException e) {
				System.out.println("Formato Fecha incorrecto");
				return null;
			}		
			personal.setFechaBaja(conversionaFecha);
			return(personal);
		}
		
	public static Colaborador addColaborador() throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Colaborador colaborador=new Colaborador();
			SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
			String antesConversionFecha;
			Date conversionaFecha= new Date(01/01/2020);
			
			System.out.println("Introduzca la Fecha De alta del Colaborador(porfavor introduzca la fecha en el siguiente formato --/--/----)");
			antesConversionFecha=br.readLine();
			try {
				conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
			} catch (ParseException e) {
				System.out.println("Formato Fecha incorrecto");
				return null;
			}
			colaborador.setFechaAlta(conversionaFecha);
			
			System.out.println("Introduzca la Fecha Fin estimada del Colaborador(porfavor introduzca la fecha en el siguiente formato --/--/----)");
			antesConversionFecha=br.readLine();
			try {
				conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
			} catch (ParseException e) {
				System.out.println("Formato Fecha incorrecto");
				return null;
			}		
			colaborador.setFechaBaja(conversionaFecha);
			return(colaborador);
		}
	
	public static Voluntario addVoluntario() throws IOException {
		
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Voluntario voluntario=new Voluntario();
		SimpleDateFormat convertirStringaFecha = new SimpleDateFormat("dd/MM/yyyy");
		String antesConversionFecha;
		Date conversionaFecha= new Date(01/01/2020);
		int seleccion;
		Nacional nacional=new Nacional();
		Internacional internacional=new Internacional();
		
		System.out.println("Introduzca la Fecha De alta del Voluntario(porfavor introduzca la fecha en el siguiente formato --/--/----)");
		antesConversionFecha=br.readLine();
		try {
			conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
		} catch (ParseException e) {
			System.out.println("Formato Fecha incorrecto");
			return null;
		}
		voluntario.setFechaAlta(conversionaFecha);
		
		System.out.println("Introduzca la Fecha Fin estimada del Voluntario(porfavor introduzca la fecha en el siguiente formato --/--/----)");
		antesConversionFecha=br.readLine();
		try {
			conversionaFecha=convertirStringaFecha.parse(antesConversionFecha);
		} catch (ParseException e) {
			System.out.println("Formato Fecha incorrecto");
			return null;
		}		
		voluntario.setFechaBaja(conversionaFecha);
		
		System.out.println("Introduzca si es Nacional o Internacional");
		System.out.println("1.Nacional");
		System.out.println("2.Internacional");
		seleccion=recuperado.nextInt();
		if (seleccion==1) {
			System.out.println("Introduce el Origen");
			nacional.setOrigen(br.readLine());
			voluntario.setNacional(nacional);
		}else if (seleccion==2) {
			System.out.println("Introduce el  Pais Origen");
			internacional.setPaisOrigen(br.readLine());
		}else {
			System.out.println("Opcion No valida ");
		}
		
		return(voluntario);
	}
}

