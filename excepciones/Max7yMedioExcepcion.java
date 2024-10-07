package excepciones;

public class Max7yMedioExcepcion extends Exception {

	//Atributos
	private String nombreJugador;
	private double puntos;

	//Constructor
	public Max7yMedioExcepcion(String nombreJugador, double puntos) {
		this.nombreJugador = nombreJugador;
		this.puntos = puntos;
		
	}
	
	//Metodos
	public String error() {
		return "El jugador/a " + this.nombreJugador + " ha superado 7.5 con " + this.puntos;
				
	}
	
	
}
