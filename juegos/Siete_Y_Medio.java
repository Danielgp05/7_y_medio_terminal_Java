package juegos;

import java.util.Scanner;

import barajas.Baraja;
import barajas.Carta;
import excepciones.Max7yMedioExcepcion;
import excepciones.RespuestaIncorrectaException;

public class Siete_Y_Medio extends Juego{

	public static final String AMARILLO = "\033[33m";

	public Siete_Y_Medio(String nombre) {
		super(nombre);

	}

	public void jugar() {

		Scanner teclado = new Scanner(System.in);
		Baraja b = new Baraja(1, true);

		System.out.print("Introduce tu nick Jugador1: ");
		this.nombreJugador1 = teclado.nextLine();
		System.out.println();

		imprimirCabecera();

		jugar(this.nombreJugador1, 1, b);

		if(this.puntosJugador1 <= 7.5) {
			imprimirFinJuego(nombreJugador1, "GANADO");

		}else {
			imprimirFinJuego(nombreJugador1, "PERDIDO");
			
		}

	}

	public void jugar(String jugador, int numJugador, Baraja b) {

		Scanner teclado = new Scanner(System.in);

		//Creamos la carta y la baraja
		Carta c;

		String respuesta = "";
		boolean seguir = true;

		//Empezamos a jugar
		b.cortar(20);

		//vamos ofreciendo al usuario si quiere más cartas o quiere plantarse
		do {
			c = b.robar();

			try {

				//Comprobar si es jugador 1 o 2
				if(numJugador == 1) {

					//Asignar nombre
					this.nombreJugador1 = jugador;

					//El usuario roba una carta
					this.puntosJugador1 += c.valor7yMedia();

					//Comprobar si se ha pasado
					if(this.puntosJugador1 > 7.5) {
						throw new Max7yMedioExcepcion(this.nombreJugador1, this.puntosJugador1);

					}else {
						System.out.println("Tu puntuación actual es: " + this.puntosJugador1);

					}

				}else {

					//Asignar nombre
					this.nombreJugador2 = jugador;

					//El usuario roba una carta
					this.puntosJugador2 += c.valor7yMedia();

					//Comprobar si se ha pasado
					if(this.puntosJugador2 > 7.5) {
						throw new Max7yMedioExcepcion(this.nombreJugador2, this.puntosJugador2);

					}else {
						System.out.println("Tu puntuación actual es: " + this.puntosJugador2);

					}
				}

				System.out.println();
				System.out.print("Quieres coger una carta?: ");
				respuesta = teclado.nextLine();
				respuesta = respuesta.toLowerCase();

				if(respuesta.equals("si") || respuesta.equals("no")) {

				}else {
					throw new RespuestaIncorrectaException();

				}

			}catch (Max7yMedioExcepcion e) {
				System.err.println(e.error());
				respuesta = "";
				break;

			}catch (RespuestaIncorrectaException e) {			
				do {
					System.out.print("Respuesta invalida, vuelve a intentarlo: ");
					respuesta = teclado.nextLine();
					respuesta = respuesta.toLowerCase();

					if(respuesta.equals("si") || respuesta.equals("no")) {
						seguir = false;

					}

				}while(seguir);

			}

		}while(respuesta.equals("si"));

	}	

	public void jugarPlayer1vsPlayer2() {
		Scanner teclado = new Scanner(System.in);
		Baraja b = new Baraja(1, true);

		System.out.print("Introduce tu nick Jugador1: ");
		this.nombreJugador1 = teclado.nextLine();

		System.out.print("Introduce tu nick Jugador2: ");
		this.nombreJugador2 = teclado.nextLine();

		System.out.println();
		imprimirCabecera();

		System.out.println("Turno de " + this.nombreJugador1);
		System.out.println();
		jugar(this.nombreJugador1, 1, b);

		System.out.println();
		System.out.println("Turno de " + this.nombreJugador2);
		System.out.println();
		jugar(this.nombreJugador2, 2, b);

		System.out.println();
		System.out.println();
		imprimirPuntuacion();
		System.out.println();

		imprimirGanadorPerdedor();

	}	

	public void jugarPlayer1vsCPU() {
		Scanner teclado = new Scanner(System.in);
		
		Baraja b = new Baraja(1, true);
		Carta c;

		boolean seguir = true;

		System.out.print("Introduce tu nick Jugador1: ");
		this.nombreJugador1 = teclado.nextLine();
		this.nombreJugador2 = "CPU";

		System.out.println();
		imprimirCabecera();

		System.out.println("Turno de " + this.nombreJugador1);
		System.out.println();
		jugar(this.nombreJugador1, 1, b);

		System.out.println();
		System.out.println("Turno de CPU...");

		//Simular que la CPU esta jugando
		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			e.printStackTrace();

		}

		//Aqui empieza a elegir las cartas la CPU (PLAYER2)

		do {
			c = b.robar();

			try {
				if(this.puntosJugador2 < 5.5) {
					this.puntosJugador2 += c.valor7yMedia();

					if(this.puntosJugador2 > 7.5) {
						throw new Max7yMedioExcepcion(this.nombreJugador2, this.puntosJugador2);

					}	

				}else {
					seguir = false;

				}

			}catch (Max7yMedioExcepcion e) {
				System.err.print(e.error());
				System.out.println();
				break;

			}

		}while(seguir);

		System.out.println();
		imprimirPuntuacion();
		System.out.println();

		imprimirGanadorPerdedor();

	}

	public void imprimirGanadorPerdedor() {
		if(this.puntosJugador1 > 7.5 && this.puntosJugador2 > 7.5) {
			System.out.println(AMARILLO + "Los dos han superado 7.5, no hay ganador" + RESET);

		}else if(this.puntosJugador1 == this.puntosJugador2) {
			System.out.println(AMARILLO + "Empate" + RESET);
			
		}else if(this.puntosJugador1 > 7.5) {
			imprimirFinJuego(nombreJugador2, "GANADO");

		}else if(this.puntosJugador2 > 7.5) {
			imprimirFinJuego(nombreJugador1, "GANADO");

		}else if(this.puntosJugador2 > this.puntosJugador1) {
			imprimirFinJuego(nombreJugador2, "GANADO");

		}else if(this.puntosJugador1 > this.puntosJugador2) {
			imprimirFinJuego(nombreJugador1, "GANADO");

		}

	}
}
