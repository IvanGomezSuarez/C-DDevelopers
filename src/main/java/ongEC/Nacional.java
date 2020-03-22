package ongEC;

public class Nacional extends Voluntario {

	String Origen;

	public String getOrigen() {
		return Origen;
	}

	public void setOrigen(String origen) {
		Origen = origen;
	}

	public Nacional(String origen) {
		super();
		Origen = origen;
	}

	public Nacional() {
		super();
	}
}
