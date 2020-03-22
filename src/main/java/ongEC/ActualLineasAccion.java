package ongEC;

import java.util.ArrayList;
import java.util.List;

/**
 * esta clase enumera los tipos de lineas de accion existentes.
 * 
 *
 */

public enum ActualLineasAccion { //Definimos la enumeracion

	COOPERACION (0, "Cooperación"),
	FORTALECIMIENTO (1, "Fortalecimiento"),
	EDUCACION (2, "Educación"),
	ACCIONHUMANITARIA (3, "Acción humanitaria");
	
	private final int code;                    //Creamos un codigo y una descipcion de cada Linea de accion para que sea mas facil a la hora de selecionarlp
	private final String description;
	
	private ActualLineasAccion(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public static List<String> listActions() {                  //Recorremos la enumeracion y guardamos en la lista las acciones para ver exactamente cuales son las opciones
		List<String> listaAcciones = new ArrayList<String>();
		for (ActualLineasAccion accion : ActualLineasAccion.values()) {
			listaAcciones.add(accion.getCode() + "." + accion.getDescription());
		}
		return listaAcciones;
	}
	
	public static ActualLineasAccion devActions(int seleccionCreacionProyecto) {                  //Recorremos la enumeracion y guardamos en la lista las acciones para ver exactamente cuales son las opciones	
		for (ActualLineasAccion accion : ActualLineasAccion.values()) {
			if (accion.getCode()==seleccionCreacionProyecto) {
				return accion;
			}
		}
		return null;
	}
	
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
}
