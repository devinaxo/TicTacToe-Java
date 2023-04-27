import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Juego {
	private Tabla tablero2;
	private ArrayList<Jugador> jugadores;
	private Jugador jugadorAct;
	
	public Juego() {
		this.tablero2 = new Tabla();
		this.jugadores = new ArrayList<>();
	}
	public void agregarUsuario(Jugador player1) {
		this.jugadores.add(player1);
	}
	public void agregarJugador() {
		this.jugadores.add(new Jugador());
	}
	public void setCasillero(int a, int b, char c) {
		this.tablero2.getTablero()[a][b].setValor(c);
	}
	public void iniciarJuego(int dificultad) {
		Random rand = new Random();
		boolean Continue = true, jugo = false;
		int a = 0;
		this.tablero2.mostrarTablero();
		do {
			this.jugadorAct = this.jugadores.get(0);
			if(this.jugadorAct == this.jugadores.get(0)) { //jugador activo es el usuario
				do {
					a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición en la que insertar X (1 al 9)"));
					switch(a) {
					case 1: //0,0
						if(!this.tablero2.verOcupado(0, 0)) {
							setCasillero(0,0,'X');
							jugo = true;
						}else {
							JOptionPane.showMessageDialog(null,"El casillero "+a+" se encuentra ocupado. Elija otro.");
						}
						break;
					case 2: //0,1
						if(!this.tablero2.verOcupado(0, 1)) {
							setCasillero(0,1,'X');
							jugo = true;
						}else {
							JOptionPane.showMessageDialog(null,"El casillero "+a+" se encuentra ocupado. Elija otro.");
						}
						break;
					case 3: //0,2
						if(!this.tablero2.verOcupado(0, 2)) {
							setCasillero(0,2,'X');
							jugo = true;
						}else {
							JOptionPane.showMessageDialog(null,"El casillero "+a+" se encuentra ocupado. Elija otro.");
						}
						break;
					case 4: //1,0
						if(!this.tablero2.verOcupado(1, 0)) {
							setCasillero(1,0,'X');
							jugo = true;
						}else {
							JOptionPane.showMessageDialog(null,"El casillero "+a+" se encuentra ocupado. Elija otro.");
						}
						break;
					case 5: //1,1
						if(!this.tablero2.verOcupado(1, 1)) {
							setCasillero(1,1,'X');
							jugo = true;
						}else {
							JOptionPane.showMessageDialog(null,"El casillero "+a+" se encuentra ocupado. Elija otro.");
						}
						break;
					case 6: //1,2
						if(!this.tablero2.verOcupado(1, 2)) {
							setCasillero(1,2,'X');
							jugo = true;
						}else {
							JOptionPane.showMessageDialog(null,"El casillero "+a+" se encuentra ocupado. Elija otro.");
						}
						break;
					case 7: //2,0
						if(!this.tablero2.verOcupado(2, 0)) {
							setCasillero(2,0,'X');
							jugo = true;
						}else {
							JOptionPane.showMessageDialog(null,"El casillero "+a+" se encuentra ocupado. Elija otro.");
						}
						break;
					case 8: //2,1
						if(!this.tablero2.verOcupado(2, 1)) {
							setCasillero(2,1,'X');
							jugo = true;
						}else {
							JOptionPane.showMessageDialog(null,"El casillero "+a+" se encuentra ocupado. Elija otro.");
						}
						break;
					case 9: //2,2
						if(!this.tablero2.verOcupado(2, 2)) {
							setCasillero(2,2,'X');
							jugo = true;
						}else {
							JOptionPane.showMessageDialog(null,"El casillero "+a+" se encuentra ocupado. Elija otro.");
						}
						break;
					}
				}while(jugo == false);
				jugo = false;
				this.tablero2.mostrarTablero();
				this.jugadorAct = this.jugadores.get(1);
				this.tablero2.verGanador();
			}
			if(this.jugadorAct == this.jugadores.get(1)) { //jugador activo es la maquina
				do {
					int[] mejorMov = new int[2];
					int[] movBlock = new int[2];
					int probabilidad = rand.nextInt(10) + 1;
					mejorMov = this.tablero2.encontrarMejorMov();
					movBlock = this.tablero2.encontrarBlockMov();
					if((mejorMov != null && mejorMov[0] == 0 && mejorMov[1] == 0)||
							 (movBlock != null && movBlock[0] == 0 && movBlock[1] == 0 && probabilidad < 4 && dificultad == 2)||
							 (movBlock != null && movBlock[0] == 0 && movBlock[1] == 0 && dificultad == 3)) {
						a = 1;
					}else if((mejorMov != null && mejorMov[0] == 0 && mejorMov[1] == 1)||
							 (movBlock != null && movBlock[0] == 0 && movBlock[1] == 1 && probabilidad < 4 && dificultad == 2)||
							 (movBlock != null && movBlock[0] == 0 && movBlock[1] == 1 && dificultad == 3)) {
						a = 2;
					}else if((mejorMov != null && mejorMov[0] == 0 && mejorMov[1] == 2)||
							 (movBlock != null && movBlock[0] == 0 && movBlock[1] == 2 && probabilidad < 4 && dificultad == 2)||
							 (movBlock != null && movBlock[0] == 0 && movBlock[1] == 2 && dificultad == 3)) {
						a = 3;
					}else if((mejorMov != null && mejorMov[0] == 1 && mejorMov[1] == 0)||
							 (movBlock != null && movBlock[0] == 1 && movBlock[1] == 0 && probabilidad < 4 && dificultad == 2)||
							 (movBlock != null && movBlock[0] == 1 && movBlock[1] == 0 && dificultad == 3)) {
						a = 4;
					}else if((mejorMov != null && mejorMov[0] == 1 && mejorMov[1] == 1)||
							 (movBlock != null && movBlock[0] == 1 && movBlock[1] == 1 && probabilidad < 4 && dificultad == 2)||
							 (movBlock != null && movBlock[0] == 1 && movBlock[1] == 1 && dificultad == 3)) {
						a = 5;
					}else if((mejorMov != null && mejorMov[0] == 1 && mejorMov[1] == 2)||
							 (movBlock != null && movBlock[0] == 1 && movBlock[1] == 2 && probabilidad < 4 && dificultad == 2)||
							 (movBlock != null && movBlock[0] == 1 && movBlock[1] == 2 && dificultad == 3)) {
						a = 6;
					}else if((mejorMov != null && mejorMov[0] == 2 && mejorMov[1] == 0)||
							 (movBlock != null && movBlock[0] == 2 && movBlock[1] == 0 && probabilidad < 4 && dificultad == 2)||
							 (movBlock != null && movBlock[0] == 2 && movBlock[1] == 0 && dificultad == 3)) {
						a = 7;
					}else if((mejorMov != null && mejorMov[0] == 2 && mejorMov[1] == 1)||
							 (movBlock != null && movBlock[0] == 2 && movBlock[1] == 1 && probabilidad < 4 && dificultad == 2)||
							 (movBlock != null && movBlock[0] == 2 && movBlock[1] == 1 && dificultad == 3)) {
						a = 8;
					}else if((mejorMov != null && mejorMov[0] == 2 && mejorMov[1] == 2)||
							 (movBlock != null && movBlock[0] == 2 && movBlock[1] == 2 && probabilidad < 4 && dificultad == 2)||
							 (movBlock != null && movBlock[0] == 2 && movBlock[1] == 2 && dificultad == 3)) {
						a = 9;
					}else {
						a = rand.nextInt(9) + 1;
					}
					switch(a) {
					case 1: //0,0
						if(!this.tablero2.verOcupado(0, 0)) {
							setCasillero(0,0,'O');
							jugo = true;
						}
						break;
					case 2: //0,1
						if(!this.tablero2.verOcupado(0, 1)) {
							setCasillero(0,1,'O');
							jugo = true;
						}
						break;
					case 3: //0,2
						if(!this.tablero2.verOcupado(0, 2)) {
							setCasillero(0,2,'O');
							jugo = true;
						}
						break;
					case 4: //1,0
						if(!this.tablero2.verOcupado(1, 0)) {
							setCasillero(1,0,'O');
							jugo = true;
						}
						break;
					case 5: //1,1
						if(!this.tablero2.verOcupado(1, 1)) {
							setCasillero(1,1,'O');
							jugo = true;
						}
						break;
					case 6: //1,2
						if(!this.tablero2.verOcupado(1, 2)) {
							setCasillero(1,2,'O');
							jugo = true;
						}
						break;
					case 7: //2,0
						if(!this.tablero2.verOcupado(2, 0)) {
							setCasillero(2,0,'O');
							jugo = true;
						}
						break;
					case 8: //2,1
						if(!this.tablero2.verOcupado(2, 1)) {
							setCasillero(2,1,'O');
							jugo = true;
						}
						break;
					case 9: //2,2
						if(!this.tablero2.verOcupado(2, 2)) {
							setCasillero(2,2,'O');
							jugo = true;
						}
						break;
					}
				}while(jugo == false);
				jugo = false;
				this.tablero2.mostrarTablero();
				this.jugadorAct = this.jugadores.get(0);
				this.tablero2.verGanador();
			}
		}while(Continue != false);
		JOptionPane.showMessageDialog(null, "Gracias por probar este humilde juego pendejo.");
	}
}
