package ongEC;

public class Internacional extends Voluntario {

	String paisOrigen;

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public Internacional(String paisOrigen) {
		super();
		this.paisOrigen = paisOrigen;
	}

	public Internacional() {
		super();
	}
}
