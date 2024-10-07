package juegos;

import barajas.Baraja;

public abstract class Juego {

	public static final String VERDE    = "\033[32m";
	public static final String RESET   = "\u001B[0m"; 

	//Atributos
	protected Baraja baraja;
	private String nombreJuego;
	protected String nombreJugador1;
	protected String nombreJugador2;
	protected double puntosJugador1;
	protected double puntosJugador2;
	protected int numeroMano;
	//protected Idioma idioma;

	//Constructor
	public Juego(String nombre){
		this.nombreJuego = nombre;

	}

	//Metodos abstractos
	public abstract void jugar();
	public abstract void jugarPlayer1vsPlayer2();
	public abstract void jugarPlayer1vsCPU();

	//Getters y Setters
	public String getNombreJugador1() {
		return nombreJugador1;

	}

	public String getNombreJugador2() {
		return nombreJugador2;

	}



	//Metodos
	public void imprimirCabecera() {
		try {
			String s = this.nombreJuego;
			String guiones = "---------------------------";

			for (int i = 0; i < s.length(); i++) {

				System.out.print( s.charAt(i) + " " );
				Thread.sleep(100);
			}
			System.out.println();

			for (int i = 0; i < guiones.length(); i++) {

				System.out.print( guiones.charAt(i));
				Thread.sleep(70);
			}
			System.out.println();


		} catch (InterruptedException e) {
			e.printStackTrace();

		}		

	}

	public void imprimirFinJuego(String jugador, String ganaPierde) {
		if(ganaPierde.equals("GANADO")) {
			System.out.println(VERDE + "El jugador/a " + jugador + " ha " + ganaPierde + RESET);

		}else {
			System.err.println("El jugador/a " + jugador + " ha " + ganaPierde);
			
		}

	}

	public void imprimirPuntuacion(){
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.printf("|%12s\t   |%11s       |%n", this.nombreJugador1, this.nombreJugador2);
		System.out.println("---------------------------------------");
		if(this.puntosJugador2 >= 10) {
			System.out.printf("|%10.1f\t   |\t    %.1f      |%n", this.puntosJugador1, this.puntosJugador2);

		}else {
			System.out.printf("|%11.1f\t   |\t    %.1f       |%n", this.puntosJugador1, this.puntosJugador2);

		}
		System.out.println("---------------------------------------");

	}

	protected void sumarPuntosJugador(double puntosCarta1, double puntosCarta2, int numJugador){
		//TODO sumarPuntosJugador
	}
}

