package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

import excepciones.FueraDeRangoException;
import excepciones.RespuestaIncorrectaException;
import juegos.*;

public class Principal {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int opcion = imprimirMenu(teclado);
		int modo;

		switch (opcion) {
		case 1:
			//7 y Medio
			Juego Siete_y_Medio = new Siete_Y_Medio("Siete y Medio");

			modo = imprimirMenuComoJugar(teclado);			
			modoJuego(Siete_y_Medio, modo);

			break;

		case 2:
			//La Brisca
			Juego Brisca = new Brisca("Brisca");

			modo = imprimirMenuComoJugar(teclado);			
			modoJuego(Brisca, modo);

			break;

		case 3:
			//Tute
			Juego Tute = new Tute("Tute");

			modo = imprimirMenuComoJugar(teclado);			
			modoJuego(Tute, modo);

			break;	

			//		case 8:
			//			Cambiar idioma
			//				
			//			break;

		case 9:
			System.out.println("HASTA PRONTO!");
			break;
			
		}

	}

	public static int imprimirMenu(Scanner teclado) {
		int a = 0;
		boolean seguir = false;

		do {
			try {
				System.out.println("******************************");
				System.out.printf("%24s%n", "JUEGOS DE CARTAS DAM");
				System.out.println("******************************");
				System.out.println();
				System.out.println("1.- 7 y medio");
				System.out.println("2.- La Brisca (Sin implementar)");
				System.out.println("3.- Tute (Sin implementar) ");
				System.out.println();
				System.out.println("8.- Cambiar idioma (Sin implementar)");
				System.out.println();
				System.out.println("9.- Salir");
				System.out.println();
				System.out.print("Opción: ");

				a = teclado.nextInt();

				if(a != 1 && a != 2 && a != 3 && a != 8 && a != 9) {
					throw new FueraDeRangoException();

				}else {
					seguir = false;

				}

			}catch (FueraDeRangoException e) {
				System.err.print("Incorrecto, introduce un número válido");
				System.err.println();

				seguir = true;

			}catch (InputMismatchException e) {
				System.err.println("Incorrecto, introduce un número válido");
				teclado.nextLine();				
				seguir = true;

			}finally {
				System.out.println();

			}

		}while(seguir);
		return a;
	}

	public static int imprimirMenuComoJugar(Scanner teclado) {
		int a = 0;
		boolean seguir = false;

		do {
			try {
				System.out.println("******************************");
				System.out.printf("%25s%n", "ELIJE UN MODO DE JUEGO");
				System.out.println("******************************");
				System.out.println();
				System.out.println("1.- Player1");
				System.out.println("2.- Player1 vs Player2");
				System.out.println("3.- Player1 vs CPU");
				System.out.println("4.- Volver menú anterior");
				System.out.println();
				System.out.println("9.- Salir");
				System.out.println();
				System.out.print("Opción: ");

				a = teclado.nextInt();

				if(a != 1 && a != 2 && a != 3 && a != 4 && a != 9) {
					throw new FueraDeRangoException();

				}else {
					seguir = false;

				}

			}catch (FueraDeRangoException e) {
				System.err.print("Incorrecto, introduce un número válido");
				System.out.println();

				seguir = true;

			}catch (InputMismatchException e) {
				System.err.println("Incorrecto, introduce un número válido");
				teclado.nextLine();				
				seguir = true;

			}finally {
				System.out.println();

			}

		}while(seguir);
		return a;
	}

	public static void modoJuego(Juego j, int opcion){

		String respuesta = "";

		switch (opcion) {
		case 1:
			//Player 1
			do {
				
				j.jugar();
				respuesta = volverAJugar();

			}while(respuesta.equals("si"));

			break;

		case 2:
			//Player1 vs Player2
			do {

				j.jugarPlayer1vsPlayer2();
				respuesta = volverAJugar();

			}while(respuesta.equals("si"));

			break;
		case 3:
			//Player vs CPU
			do {

				j.jugarPlayer1vsCPU();
				respuesta = volverAJugar();

			}while(respuesta.equals("si"));
			
			break;
		case 4:
			main(null);

			break;
		case 9:
			System.out.println("HASTA PRONTO!");

			break;
		}

	}

	public static String volverAJugar() {
		
		Scanner teclado = new Scanner(System.in);

		String respuesta = "";

		try {
			System.out.println();
			System.out.print("Quieres volver a jugar? (si/no): ");
			respuesta = teclado.nextLine();
			respuesta = respuesta.toLowerCase();

			if(respuesta.equals("si") || respuesta.equals("no")) {

			}else {
				throw new RespuestaIncorrectaException();

			}

		}catch (RespuestaIncorrectaException e) {
			do {
				System.out.print("Respuesta invalida, vuelve a intentarlo: ");
				respuesta = teclado.nextLine();
				respuesta = respuesta.toLowerCase();

				if(respuesta.equals("si") || respuesta.equals("no")) {
					break;
				}

			}while(true);

		}

		if(respuesta.equals("si")) {
			System.out.println();
			respuesta = "";
			main(null);

		}else {
			System.out.println("HASTA PRONTO!");
			
		}

		return respuesta;

	}
}
