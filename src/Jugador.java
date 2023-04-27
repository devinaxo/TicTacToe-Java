import java.util.Random;

public class Jugador {
	private String name;
	private char valor;
	
	public Jugador() {
		String[] nombres = {"Juan","Nico","Rocio","Rafa","Andres","Khalid","Hector","Papito Envido","Sonic"};
		Random rand = new Random();
		this.name = nombres[rand.nextInt(nombres.length)];
		this.valor = 'O';
	}
	public Jugador(String nombre) {
		this.name = nombre;
		this.valor = 'X';
	}
	public char getValor() {
		return valor;
	}
	public String getName() {
		return name;
	}
}
