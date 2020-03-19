package ongEC;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		
		Integer estadoAplicacion=0;//Estado de la aplicacion para decidir que opcion entre todas usar
		Integer seleccionSubMenu=0;//Seleccion del Menu Secundario
		
		
		while (estadoAplicacion!=9){            //Hasta que no se introduzca el numero 9 no se sale de la aplicacion.
			
			opcionesMenuPrincipal();			//Llamamos a la funcion que printea la sopciones principales
			
			estadoAplicacion=comprobacionOpcion();		//Comprobamos con una unica clase (para no tener que estar repitiendo codigo) que el caracter es entero
			
			if (estadoAplicacion!=0) {							
				if (estadoAplicacion==1) { //Despues de comprobar que el numero es correcto pasamos a comprobar que opcion a introducido el usuario
					 System.out.println("1.Dar de alta/modificar/eliminar un Socio");
					 opcionesSecundario();
					 seleccionSubMenu=comprobacionOpcion(); //Comprobamos si es int
					 if (seleccionSubMenu!=0) {				
						 if (seleccionSubMenu==1) {			//Pasamos dependiendo de la seleccion
							 System.out.println("Dar de alta");
						 }else if (seleccionSubMenu==2) {
							 System.out.println("Modificar");
						 }else if (seleccionSubMenu==3) {
							 System.out.println("Eliminar");
						 }else {
							 System.out.println("Opcion no valida");
						 }
					 }
					 
				} else if (estadoAplicacion==2) {
					System.out.println("2.Dar de alta/modificar/eliminar un Proyecto");
					opcionesSecundario();
					seleccionSubMenu=comprobacionOpcion();	//Comprobamos si es int
					if (seleccionSubMenu!=0) {
						 if (seleccionSubMenu==1) {		//Pasamos dependiendo de la seleccion
							 System.out.println("Dar de alta");
						 }else if (seleccionSubMenu==2) {
							 System.out.println("Modificar");
						 }else if (seleccionSubMenu==3) {
							 System.out.println("Eliminar");
						 }else {
							 System.out.println("Opcion no valida");
						 }
					}
				}else if (estadoAplicacion==3){
					System.out.println("3.Dar de alta/modificar/eliminar un Miembro");
					opcionesSecundario();
					seleccionSubMenu=comprobacionOpcion();	//Comprobamos si es int
					 if (seleccionSubMenu!=0) {
						 if (seleccionSubMenu==1) { 	//Pasamos dependiendo de la seleccion
							 System.out.println("Dar de alta");
						 }else if (seleccionSubMenu==2) {
							 System.out.println("Modificar");
						 }else if (seleccionSubMenu==3) {
							 System.out.println("Eliminar");
						 }else {
							 System.out.println("Opcion no valida");
						 }
					 }
				}else if (estadoAplicacion==4){
					System.out.println("4.Dar de alta/modificar/eliminar un Ingreso");
					opcionesSecundario();
					seleccionSubMenu=comprobacionOpcion(); 	//Comprobamos si es int
					 if (seleccionSubMenu!=0) {
						 if (seleccionSubMenu==1) { 	//Pasamos dependiendo de la seleccion
							 System.out.println("Dar de alta");
						 }else if (seleccionSubMenu==2) {
							 System.out.println("Modificar");
						 }else if (seleccionSubMenu==3) {
							 System.out.println("Eliminar");
						 }else {
							 System.out.println("Opcion no valida");
						 }
					 }
				}else if (estadoAplicacion==9) {
					System.exit(0);
				}else {
					System.out.println("El numero que has introducido no esta dentro de las opciones posibles, vuelva a intentarlo.Gracias");
				}
			}
		}
		
		
	}
	
	private static void opcionesMenuPrincipal(){//Opciones del menu principal
		 System.out.println("Seleccione la Opcion deseada");
		 System.out.println("1.Dar de alta/modificar/eliminar un Socio");
		 System.out.println("2.Dar de alta/modificar/eliminar un Proyecto");
		 System.out.println("3.Dar de alta/modificar/eliminar un Miembro");
		 System.out.println("4.Dar de alta/modificar/eliminar un Ingreso");
	}
	private static void opcionesSecundario(){ //Opciones del menu secundario para realizar la accion que queremos
		System.out.println("Seleccione la Opcion deseada");
		System.out.println("1.Dar de alta");
		System.out.println("2.Modificar");
		System.out.println("3.Eliminar");
	}
	private static Integer comprobacionOpcion() { //Comprobamos que la opcion introducida es realmente un entero para que no de ninguna excepcion
		
		int accionARealizar=0;
		
		Scanner opcionARealizar= new Scanner(System.in);
		
		try {
			 accionARealizar=opcionARealizar.nextInt();
			 }catch (InputMismatchException e) {
	                System.out.println("El caracter que has introducido no es valido");
	                return(0);
			 }
		return(accionARealizar);
	}
		
}
