package barajas;

import java.util.ArrayList;
import java.util.Random;

public class Baraja {

	//Atributos
	private ArrayList<Carta> listaCarta;

	//Constructor
	public Baraja() {
		this.listaCarta = new ArrayList<Carta>();

	}

	public Baraja(int tipoBaraja) {

		this();
		for (int i = 0; i < tipoBaraja; i++) {
			for (int j = 1; j <= 40; j++) {							
				Carta c = new Carta(j);
				listaCarta.add(c);

			}

		}

	}

	public Baraja(int tipoBaraja, boolean barajar) {
		this(tipoBaraja);

		if(barajar) {
			this.listaCarta = barajar();

		}

	}

	public ArrayList<Carta> barajar(){
		ArrayList<Carta> a = new ArrayList<Carta>();

		int random;
		int min = 0;
		int	max;

		while(this.listaCarta.size() != 0) {
			max = this.listaCarta.size()-1;
			random = (int) (Math.random() * (max - min + 1) + min);

			Carta c = this.listaCarta.remove(random);
			a.add(c);

		}

		return a;
	}

	public void cortar(int posicion){
		ArrayList<Carta> a = new ArrayList<Carta>();

		try {
			for (int i = 0; i < posicion; i++) {
				Carta c = this.listaCarta.remove(0);
				a.add(c);

			}

			for (Carta carta : a) {
				listaCarta.add(carta);

			}
			
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Has superado el número de cartas disponibles");
			
		}

	}	

	public Carta robar() {
		return this.listaCarta.remove(0);
		
	}

	public void insertaCartaFinal(int id_carta) {
		Carta c = new Carta(id_carta);
		listaCarta.add(c);
		
	}
	
	public void insertaCartaPrincipio(int id_carta) {
		Carta c = new Carta(id_carta);
		listaCarta.add(0, c);
		
	}
	
	public void insertaCartaFinal(Carta c) {
		listaCarta.add(c);
		
	}
	
	public void insertaCartaPrincipio(Carta c) {
		listaCarta.add(0, c);
		
	}
	
//	public void imprimirBaraja() {
//		for (Carta carta : listaCarta) {
//			System.out.println(carta.getNombreCarta());
//
//		}
//
//	}
}
