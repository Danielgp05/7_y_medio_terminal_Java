package barajas;

public class Carta implements Relacionable{

	//Atributos
	private int numero; //un entero (1 .. 10) que nos representa el número de la carta, siendo el 8 la sota, el 9 el caballo y el 10 el rey.
	int palo; // un entero (0, 1, 2, 3) que nos representa el palo de la carta (oros, copas, espadas y bastos).

	//Constructor
	public Carta(int numero, int palo) {
		this.numero = numero;
		this.palo = palo;

	}

	public Carta(int id) {
		//a la que le pasamos un número entre 1 y 40 que representa la carta, siendo 1 el as de oros y 40 el rey de bastos.
		this.numero = (id-1) % 10 + 1;
		this.palo = (id - 1) / 10 ;

	}

	//Metodos

	public int getNumero() {
		return numero;

	}

	public int getPalo() {
		return palo;

	}

	public String getNombreNumero() {

		String[] v = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo", "rey"};		
		
		return v[getNumero()-1];
	}
	
	public String getNombrePalo() {
		
		String[] v = {"oros", "copas", "espadas", "bastos"};				

		return v[getPalo()-1];
		
	}
	
	public String getNombreCarta() {
		return String.format("%s de %s",getNombreNumero(), getNombrePalo() );
		
	}

	public double valor7yMedia() {
		 double valor = 0;
		 
		 if(this.numero == 8 || this.numero == 9 || this.numero == 10) {
			 valor += 0.5;
			 
		 }else {
			 valor += this.numero;
			 
		 }
		 
		 return valor;
		
	}

	public void esMayorQue() {
		// TODO esMayorQue
		
	}

	public void esMenorQue() {
		// TODO esMenorQue
		
	}

	public void esIgualQue() {
		// TODO esIgualQue
		
	}
}
