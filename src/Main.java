import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Juego test = new Juego();
		String[] options = {"Fácil","Medio","Dificil"}; 
		int x = JOptionPane.showOptionDialog(null,"Elija su dificultad deseada: ","Ta Te Ti", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); //0:facil, 1:medio, 2:dificil
		test.agregarUsuario(new Jugador("test"));
		test.agregarJugador();
		test.iniciarJuego(x);
	}
}
