import javax.swing.JOptionPane;

public class Tabla {
	private Casilla[][] tablero;
	
	public Tabla(){
		this.tablero = new Casilla[3][3];
		char a = '0';
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				a++;
				this.tablero[i][j] = new Casilla(a); 
			}
		}
	}
	public boolean verOcupado(int a, int b) { //verdadero si esta ocupado, falso si no
		return (this.tablero[a][b].getValor() == 'X' || this.tablero[a][b].getValor() == 'O');
	}
	public boolean verLleno() {
		int a = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(this.tablero[i][j].getValor() == 'X' || this.tablero[i][j].getValor() == 'O') {
					a++;
				}
			}
		}
		if(a == 9) {
			return true;
		}else {
			return false;
		}
	}
	public Casilla[][] getTablero() {
		return tablero;
	}
	public void mostrarTablero() {
		JOptionPane.showMessageDialog(null, ""+this.tablero[0][0].getValor()+"|"+this.tablero[0][1].getValor()+"|"+this.tablero[0][2].getValor()+"\n"
				+this.tablero[1][0].getValor()+"|"+this.tablero[1][1].getValor()+"|"+this.tablero[1][2].getValor()+"\n"+this.tablero[2][0].getValor()+"|"
				+this.tablero[2][1].getValor()+"|"+this.tablero[2][2].getValor());
	}
	/*public void verGanador() {
		if( (this.tablero[0][0].getValor() == 'X')&&(this.tablero[0][1].getValor() == 'X')&&(this.tablero[0][2].getValor() == 'X')||
			(this.tablero[1][0].getValor() == 'X')&&(this.tablero[1][1].getValor() == 'X')&&(this.tablero[1][2].getValor() == 'X')||
			(this.tablero[2][0].getValor() == 'X')&&(this.tablero[2][1].getValor() == 'X')&&(this.tablero[2][2].getValor() == 'X')||
			(this.tablero[0][0].getValor() == 'X')&&(this.tablero[1][0].getValor() == 'X')&&(this.tablero[2][0].getValor() == 'X')||
			(this.tablero[0][1].getValor() == 'X')&&(this.tablero[1][1].getValor() == 'X')&&(this.tablero[2][1].getValor() == 'X')||
			(this.tablero[0][2].getValor() == 'X')&&(this.tablero[1][2].getValor() == 'X')&&(this.tablero[2][2].getValor() == 'X')||
			(this.tablero[0][0].getValor() == 'X')&&(this.tablero[1][1].getValor() == 'X')&&(this.tablero[2][2].getValor() == 'X')||
			(this.tablero[2][0].getValor() == 'X')&&(this.tablero[1][1].getValor() == 'X')&&(this.tablero[0][2].getValor() == 'X')) {
			ganaX();
		}else if( (this.tablero[0][0].getValor() == 'O')&&(this.tablero[0][1].getValor() == 'O')&&(this.tablero[0][2].getValor() == 'O')||
			(this.tablero[1][0].getValor() == 'O')&&(this.tablero[1][1].getValor() == 'O')&&(this.tablero[1][2].getValor() == 'O')||
			(this.tablero[2][0].getValor() == 'O')&&(this.tablero[2][1].getValor() == 'O')&&(this.tablero[2][2].getValor() == 'O')||
			(this.tablero[0][0].getValor() == 'O')&&(this.tablero[1][0].getValor() == 'O')&&(this.tablero[2][0].getValor() == 'O')||
			(this.tablero[0][1].getValor() == 'O')&&(this.tablero[1][1].getValor() == 'O')&&(this.tablero[2][1].getValor() == 'O')||
			(this.tablero[0][2].getValor() == 'O')&&(this.tablero[1][2].getValor() == 'O')&&(this.tablero[2][2].getValor() == 'O')||
			(this.tablero[0][0].getValor() == 'O')&&(this.tablero[1][1].getValor() == 'O')&&(this.tablero[2][2].getValor() == 'O')||
			(this.tablero[2][0].getValor() == 'O')&&(this.tablero[1][1].getValor() == 'O')&&(this.tablero[0][2].getValor() == 'O')) {
			ganaO();
		}else {
			if(verLleno()) {
				empate();
			}
		}
		
	}*/
	
	 public void verGanador() {
	      for (int i = 0; i < 3; i++) {
	         if (this.tablero[i][0].getValor() == this.tablero[i][1].getValor() && 
	             this.tablero[i][1].getValor() == this.tablero[i][2].getValor()) {
	            gana(this.tablero[i][0].getValor());
	         }
	      }
	      for (int j = 0; j < 3; j++) {
	         if (this.tablero[0][j].getValor() == this.tablero[1][j].getValor() && 
	             this.tablero[1][j].getValor() == this.tablero[2][j].getValor()) {
	            gana(this.tablero[0][j].getValor());
	         }
	      }
	      if (this.tablero[0][0].getValor() == this.tablero[1][1].getValor() && 
	          this.tablero[1][1].getValor() == this.tablero[2][2].getValor()) {
	         gana(this.tablero[0][0].getValor());
	      }
	      if (this.tablero[2][0].getValor() == this.tablero[1][1].getValor() && 
	          this.tablero[1][1].getValor() == this.tablero[0][2].getValor()) {
	         gana(this.tablero[2][0].getValor());
	      }
	      if(verLleno()) {
	    	  gana('n');
	      }
	   }
	 
	 public int[] encontrarMejorMov() {
		 int[] mov = new int[2];
		 for (int i = 0; i < 3; i++) { //veo las filas
			 int contO = 0;
			 int contVacio = 0;
		     for (int j = 0; j < 3; j++) {
		    	 if (this.tablero[i][j].getValor() == 'O') {
		    		 contO++;
		         } else if (this.tablero[i][j].getValor() != 'X') {
		        	 contVacio++;
		             mov[0] = i;
		             mov[1] = j;
		            }
		        }
		        if (contO == 2 && contVacio == 1) {
		            return mov;
		        }
		    }
		for (int j = 0; j < 3; j++) { //veo las columnas
			int contO = 0;
		    int contVacio = 0;
		    for (int i = 0; i < 3; i++) {
		    	if (this.tablero[i][j].getValor() == 'O') {
		    		contO++;
		        } else if (this.tablero[i][j].getValor() != 'X') {
		            contVacio++;
		            mov[0] = i;
		            mov[1] = j;
		        	}
		        }
		        if (contO == 2 && contVacio == 1) {
		            return mov;
		        }
		    }
		int contO = 0;
		int contVacio = 0;
		for (int i = 0; i < 3; i++) { //veo la diagonal
			if (this.tablero[i][i].getValor() == 'O') {
				contO++;
		    } else if (this.tablero[i][i].getValor() != 'X') {
		        contVacio++;
		        mov[0] = i;
		        mov[1] = i;
		        }
		    }
		if (contO == 2 && contVacio == 1) {
			return mov;
		}
		contO = 0;
		contVacio = 0;
		for (int i = 0; i < 3; i++) { //veo la otra diagonal
			if (this.tablero[i][3-i-1].getValor() == 'O') {
				contO++;
		    } else if (this.tablero[i][3-i-1].getValor() != 'X') {
		       contVacio++;
		       mov[0] = i;
		        mov[1] = 3-i-1;
		        }
		    }
		if (contO == 2 && contVacio == 1) {
		    return mov;
		}
		    return null; //por si todavía no hay mejor movimiento
	 }
	 
	 public int[] encontrarBlockMov() {
		 int[] mov = new int[2];
		 for (int i = 0; i < 3; i++) { //veo las filas
			 int contX = 0;
			 int contVacio = 0;
		     for (int j = 0; j < 3; j++) {
		    	 if (this.tablero[i][j].getValor() == 'X') {
		    		 contX++;
		         } else if (this.tablero[i][j].getValor() != 'O') {
		        	 contVacio++;
		             mov[0] = i;
		             mov[1] = j;
		            }
		        }
		        if (contX == 2 && contVacio == 1) {
		            return mov;
		        }
		    }
		for (int j = 0; j < 3; j++) { //veo las columnas
			int contX = 0;
		    int contVacio = 0;
		    for (int i = 0; i < 3; i++) {
		    	if (this.tablero[i][j].getValor() == 'X') {
		    		contX++;
		        } else if (this.tablero[i][j].getValor() != 'O') {
		            contVacio++;
		            mov[0] = i;
		            mov[1] = j;
		        	}
		        }
		        if (contX == 2 && contVacio == 1) {
		            return mov;
		        }
		    }
		int contX = 0;
		int contVacio = 0;
		for (int i = 0; i < 3; i++) { //veo la diagonal
			if (this.tablero[i][i].getValor() == 'X') {
				contX++;
		    } else if (this.tablero[i][i].getValor() != 'O') {
		        contVacio++;
		        mov[0] = i;
		        mov[1] = i;
		        }
		    }
		if (contX == 2 && contVacio == 1) {
			return mov;
		}
		contX = 0;
		contVacio = 0;
		for (int i = 0; i < 3; i++) { //veo la otra diagonal
			if (this.tablero[i][3-i-1].getValor() == 'X') {
				contX++;
		    } else if (this.tablero[i][3-i-1].getValor() != 'O') {
		       contVacio++;
		       mov[0] = i;
		        mov[1] = 3-i-1;
		        }
		    }
		if (contX == 2 && contVacio == 1) {
		    return mov;
		}
		    return null; //por si todavía no hay movimiento de bloqueo
		}

	
	/*public void ganaX() {
		JOptionPane.showMessageDialog(null,"Ganó X.");
		System.exit(0);
	}
	public void ganaO() {
		JOptionPane.showMessageDialog(null,"Ganó O.");
		System.exit(0);
	}
	public void empate() {
		JOptionPane.showMessageDialog(null,"Empate");
		System.exit(0);
	}*/
	 
	 public void gana(char a) {
		 if(a == 'X' || a == 'O') {
			 JOptionPane.showMessageDialog(null,"Ganó "+a+".");
		 }else {
			 JOptionPane.showMessageDialog(null,"Ganó nadie. Empate.");
		 }
		System.exit(0);
	 }
}
