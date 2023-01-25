package batalhaNaval;
public class Tabuleiro {
	
	private char[][] tabuleiro = new char[10][10];

	public void posiciona(int c, int l) {
		this.tabuleiro[c][l] = 'N';
	}

	public void preencheTabuleiro() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				tabuleiro[i][j] = '.';
			}
		}
	}
	
	public void imprimeTabuleiro() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(this.tabuleiro[j][i]);
			}
			System.out.println();
		}
	}
	
}	

