package ongEC;


/**
* esta clase permite gestionar contiene la información de la ong
*/


public class ong {
	private String nombreOng;
	private String cifOng;
	//private direccionOng Direccion;
	
	
	// constructor
	
	/**
	 * creacion de nuevo objeto con atributos no inicialiados
	 */
	public ong() {
		super();
	}
	
	
	/**
	 * este constructor crea objeto e inicialia los atributos.
	 * @param cifOng 
	 */
	public ong(String nombreOng, String cifOng) {
		super();
		this.nombreOng = nombreOng;
		this.cifOng = cifOng;
	}

	// metodos

	public String getNombreOng() {
		return nombreOng;
	}

	public void setNombreOng(String nombreOng) {
		this.nombreOng = nombreOng;
	}

	public String getCifOng() {
		return cifOng;
	}

	public void setCifOng(String cifOng) {
		this.cifOng = cifOng;
	}
	
	/**
	 * no implemento los metodos añadir delegación, borrarla o modificarla por el tema del DAO y DAO factory, que en 
	 * teoria son capas donde no se junta el código estandard con las acciones sobre la base de datos
	 * 
	 */

}
